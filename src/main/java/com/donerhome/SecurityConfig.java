package com.donerhome;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class for the DonerHome application.
 * <p>
 * This class configures the security settings for the web application, including:
 * - Permitting all incoming requests temporarily (for testing purposes).
 * - Enforcing HTTPS for all requests.
 * - Disabling CSRF protection (for testing purposes).
 * </p>
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Logger for logging security-related events
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    /**
     * Configures the security filter chain for the web application.
     *
     * <p>
     * - All incoming requests are temporarily permitted for testing.
     * - HTTPS is enforced for all requests to secure communication.
     * - CSRF protection is disabled for testing.
     * </p>
     *
     * @param http the {@link HttpSecurity} object to configure the security settings
     * @return the configured {@link SecurityFilterChain} bean
     * @throws Exception if an error occurs during the configuration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        logger.info("Configuring security settings for the application");

        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().permitAll() // Allow all request.
                )
                .requiresChannel(channel ->
                        channel.anyRequest().requiresSecure() // Need https for all request.
                )
                .csrf(csrf -> csrf.disable()); // Deny CSRF for testing.
        logger.info("Security settings configured successfully");
        return http.build();
    }
}
