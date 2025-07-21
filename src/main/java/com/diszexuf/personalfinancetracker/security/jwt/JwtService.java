package com.diszexuf.personalfinancetracker.security.jwt;

import com.diszexuf.personalfinancetracker.dto.auth.JwtAuthentificationDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
@Slf4j
public class JwtService {
    @Value("181cdd0823849a662aef94575bf6fe16")
    private String jwtSecret;

    public JwtAuthentificationDto generateAuthToken(String email) {
        JwtAuthentificationDto jwtDto = new JwtAuthentificationDto();
        jwtDto.setToken(generateJwtToken(email));
        jwtDto.setRefreshToken(generateRefreshToken(email));
        return jwtDto;
    }

    public JwtAuthentificationDto refreshBaseToken(String email, String refreshToken) {
        JwtAuthentificationDto jwtDto = new JwtAuthentificationDto();
        jwtDto.setToken(generateJwtToken(email));
        jwtDto.setRefreshToken(refreshToken);
        return jwtDto;
    }

    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser()
                    .verifyWith(getSignInKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return true;
        } catch (ExpiredJwtException e) {
            log.error("Expired JwtException", e);
        } catch (UnsupportedJwtException e) {
            log.error("Unsupported JwtException", e);
        } catch (MalformedJwtException e) {
            log.error("Malformed JwtException", e);
        } catch (SecurityException e) {
            log.error("SecurityException", e);
        } catch (Exception e) {
            log.error("Exception", e);
        }
        return false;
    }

    private String generateJwtToken(String email) {
        Date date = Date.from(LocalDateTime.now().plusHours(5L).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(email)
                .expiration(date)
                .signWith(getSignInKey())
                .compact();
    }

    private String generateRefreshToken(String email) {
        Date date = Date.from(LocalDateTime.now().plusDays(1L).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(email)
                .expiration(date)
                .signWith(getSignInKey())
                .compact();
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
