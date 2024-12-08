package com.honeybug.k8spractice.user.api.component;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuthUtils {

    public static Long getUserId() {
        return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getPrincipal)
                .map(String::valueOf)
                .filter(StringUtils::isNumeric)
                .map(Long::parseLong)
                .orElse(null);
    }
}