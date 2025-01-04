package org.kna;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.inject.Inject;

public class TokenResponse {
    private Timestamp defaultTimestamp;
    
    private String access_token;
    private String RefreshToken;
    private String TokenType;
    private String ExpiresIn;

    public TokenResponse() {
        defaultTimestamp=Timestamp.from(Instant.now());
    }

    public TokenResponse( String access_token, String refreshToken, String tokenType, String expiresIn) {
        defaultTimestamp=Timestamp.from(Instant.now());
        this.access_token = access_token;
        RefreshToken = refreshToken;
        TokenType = tokenType;
        ExpiresIn = expiresIn;
    }

    public Timestamp getDefaultTimestamp() {
        return defaultTimestamp;
    }

    public void setDefaultTimestamp(Timestamp defaultTimestamp) {
        this.defaultTimestamp = defaultTimestamp;
    }

    public String getaccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefreshToken() {
        return RefreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        RefreshToken = refreshToken;
    }

    public String getTokenType() {
        return TokenType;
    }

    public void setTokenType(String tokenType) {
        TokenType = tokenType;
    }

    public String getExpiresIn() {
        return ExpiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        ExpiresIn = expiresIn;
    }
}

