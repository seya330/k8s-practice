package com.honeybug.k8spractice.user.api.component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtComponent {

    //todo 변경 필요
    private static final String ISSUER = "localhost";
    private static final String BEARER = "Bearer ";
    private static final long DEFAULT_EXPIRATION_MS = 1000L * 60 * 60 * 24 * 14; // 14일
    private final String secret = "53J3su8NiGxb4JRCXlOPQk_BbpqBkkm5UEJ_fjyVsqIWD7RwQ6OXaGz1hmbUEAGjss-aw4LGtUNYvQ44qW2EBI3hpp_mlhN-qM6ajCeKF3BPTWX25lHTl-5E31Xo0xoP-6Tf_fA-rVJHHNMWh2bO0Oq4KomFCTQ_erNqC7chASs";

    private String buildToken(final String key, final long duration, boolean withBearerPrefix) {
        Map<String, Object> header = Jwts.header();
        Date expireDate = new Date(System.currentTimeMillis() + duration);
        Claims claims = Jwts.claims()
                .setIssuer(ISSUER)
                .setSubject(key)
                .setAudience("")
                .setExpiration(expireDate)
                .setNotBefore(new Date())
                .setIssuedAt(new Date());

        Key secretKey = Keys.hmacShaKeyFor(secret.getBytes());

        String token = Jwts.builder()
                .setHeader(header)
                .setClaims(claims)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();

        return withBearerPrefix ? BEARER + token : token;
    }

    public String createToken(final String key, final long duration) {
        return buildToken(key, duration, false);
    }

    public String createBearerToken(final String key) {
        return buildToken(key, DEFAULT_EXPIRATION_MS, true);
    }

    public Claims verify(String token) {
        if (!StringUtils.hasLength(token)) {
            throw new OAuth2AuthenticationException(OAuth2ErrorCodes.UNAUTHORIZED_CLIENT);
        }

        if (!token.startsWith(BEARER)) {
            throw new OAuth2AuthenticationException(OAuth2ErrorCodes.UNAUTHORIZED_CLIENT);
        }
        token = token.substring(BEARER.length());
        return Jwts.parserBuilder()
                .setSigningKey(secret.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
