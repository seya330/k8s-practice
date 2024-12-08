package com.honeybug.k8spractice.user.api.config;

import com.honeybug.k8spractice.user.api.component.JwtComponent;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {

    private final JwtComponent jwtComponent;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
                .ifPresent(token -> {
                    try {
                        Claims claims = jwtComponent.verify(token);
                        Authentication auth = new PreAuthenticatedAuthenticationToken(claims.getSubject(), token,
                                Collections.singletonList(new OAuth2UserAuthority(claims)));
                        SecurityContextHolder.getContext().setAuthentication(auth);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
        filterChain.doFilter(request, response);
    }
}
