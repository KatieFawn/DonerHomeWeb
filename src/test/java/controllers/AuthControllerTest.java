package controllers;

import com.donerhome.controller.AuthController;
import com.donerhome.dto.auth.*;
import com.donerhome.entity.User;
import com.donerhome.service.AddressService;
import com.donerhome.service.AuthService;
import com.donerhome.utils.PasswordUtils;
import com.donerhome.utils.SHA256;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @Mock
    private AuthService authService;

    @Mock
    private AddressService addressService;

    @InjectMocks
    private AuthController authController;

    private User testUser;

    @BeforeEach
    void setUp() {
        // Initialize test user data
        MockitoAnnotations.openMocks(this); // Инициализация моков
        testUser = new User();
        testUser.setId(1L);
        testUser.setEmail("test@example.com");
        testUser.setPassword(PasswordUtils.hashPassword("password"));
        testUser.setRole("USER");
    }

    @Test
    void testHome() {
        // Test home endpoint
        String response = authController.home();
        assertEquals("Welcome to the server!", response);
    }

    @Test
    void testLogin_Success() {
        // Test login when credentials are valid
        LoginRequest loginRequest = new LoginRequest("test@example.com", "password");

        when(authService.findByEmail("test@example.com")).thenReturn(Optional.of(testUser));

        ResponseEntity<AuthDTO> response = authController.login(loginRequest);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(testUser.getEmail(), response.getBody().getUserData().getEmail());
    }

    @Test
    void testLogin_Failure() {
        // Test login when credentials are invalid
        LoginRequest loginRequest = new LoginRequest("test@example.com", "wrongpassword");

        when(authService.findByEmail("test@example.com")).thenReturn(Optional.of(testUser));

        ResponseEntity<AuthDTO> response = authController.login(loginRequest);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testBegin_Success() {
        // Test begin endpoint when refresh token is valid
        TokensDTO tokensDTO = new TokensDTO();
        tokensDTO.setAccessToken("validAccessToken");
        tokensDTO.setRefreshToken("validRefreshToken");

        String hashedRefreshToken = SHA256.hashString("validRefreshToken");
        when(authService.findByRefreshToken(hashedRefreshToken)).thenReturn(testUser);
        when(authService.receiveAllProducts()).thenReturn(new ProductsDTO());

        ResponseEntity<AuthDTO> response = authController.begin(tokensDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(testUser.getEmail(), response.getBody().getUserData().getEmail());
    }

    @Test
    void testBegin_RefreshTokenExpired() {
        // Test begin endpoint when refresh token is expired
        TokensDTO tokensDTO = new TokensDTO();
        tokensDTO.setAccessToken("validAccessToken");
        tokensDTO.setRefreshToken("expiredRefreshToken");

        String hashedRefreshToken = SHA256.hashString("expiredRefreshToken");
        when(authService.findByRefreshToken(hashedRefreshToken)).thenReturn(testUser);
        testUser.setRefreshTokenExpiration(testUser.getRefreshTokenExpiration().minusSeconds(3600)); // Simulate expired token

        ResponseEntity<AuthDTO> response = authController.begin(tokensDTO);

        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testBegin_InvalidAccessToken() {
        // Test begin endpoint when access token is invalid
        TokensDTO tokensDTO = new TokensDTO();
        tokensDTO.setAccessToken("invalidAccessToken");
        tokensDTO.setRefreshToken("validRefreshToken");

        String hashedRefreshToken = SHA256.hashString("validRefreshToken");
        when(authService.findByRefreshToken(hashedRefreshToken)).thenReturn(testUser);

        ResponseEntity<AuthDTO> response = authController.begin(tokensDTO);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testResponse() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Создаем экземпляр контроллера
        AuthController authController = new AuthController();

        // Получаем приватный метод через рефлексию
        Method responseMethod = AuthController.class.getDeclaredMethod("response", User.class, String.class, String.class);
        responseMethod.setAccessible(true);  // Делаем метод доступным

        // Создаем необходимые данные
        User testUser = new User();
        testUser.setId(1L);
        testUser.setEmail("test@example.com");
        testUser.setRole("USER");

        String accessToken = "validAccessToken";
        String refreshToken = "validRefreshToken";

        // Вызываем метод через рефлексию
        AuthDTO authDTO = (AuthDTO) responseMethod.invoke(authController, testUser, accessToken, refreshToken);

        // Проверяем результат
        assertNotNull(authDTO);
        assertEquals(testUser.getEmail(), authDTO.getUserData().getEmail());
        assertEquals(accessToken, authDTO.getTokens().getAccessToken());
        assertEquals(refreshToken, authDTO.getTokens().getRefreshToken());
    }
}
