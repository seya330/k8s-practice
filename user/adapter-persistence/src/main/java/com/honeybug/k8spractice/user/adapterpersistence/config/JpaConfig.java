package com.honeybug.k8spractice.user.adapterpersistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.honeybug.k8spractice.user")
@EntityScan(basePackages = "com.honeybug.k8spractice.user")
public class JpaConfig {
}
