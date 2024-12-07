package com.honeybug.k8spractice.user.api.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.zalando.problem.spring.web.advice.security.SecurityProblemSupport;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
@Import(SecurityProblemSupport.class)
public class WebSecurityConfig {

  private final SecurityProblemSupport problemSupport;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http, AuthFilter authFilter) throws Exception {
    http.cors(AbstractHttpConfigurer::disable)
        .csrf(AbstractHttpConfigurer::disable);

    http.sessionManagement(customizer -> customizer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    http.authorizeHttpRequests(authManager ->
        authManager
            .requestMatchers("/users/**").permitAll()
            .anyRequest().authenticated()
    );
    http.exceptionHandling(
        configurer ->
            configurer.authenticationEntryPoint(problemSupport).accessDeniedHandler(problemSupport));

    http.addFilterAfter(authFilter, AnonymousAuthenticationFilter.class);
    return http.build();
  }
}
