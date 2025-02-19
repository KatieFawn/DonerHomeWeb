package com.donerhome.repository;

import com.donerhome.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;

public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by email
    User findByEmail(String email);

    // Update refresh token for a specific user
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.refreshToken = :refreshToken WHERE u.id = :id")
    void updateRefreshToken(@Param("id") Long id, @Param("refreshToken") String refreshToken);

    // Update refresh token and expiration date for a specific user
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.refreshToken = :refreshToken, u.refreshTokenExpiration = :expiration WHERE u.id = :id")
    void updateRefreshTokenAndDate(@Param("id") Long id, @Param("refreshToken") String refreshToken, @Param("expiration") Instant expiration);

    // Find user by refresh token
    @Transactional
    @Query("SELECT u FROM User u WHERE u.refreshToken = :refreshToken")
    User findByRefreshToken(@Param("refreshToken") String refreshToken);

    // Update refresh token expiration date
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.refreshTokenExpiration = :expiration WHERE u.refreshToken = :refreshToken")
    void updateRefreshTokenExpiration(@Param("refreshToken") String refreshToken, @Param("expiration") Instant expiration);
}
