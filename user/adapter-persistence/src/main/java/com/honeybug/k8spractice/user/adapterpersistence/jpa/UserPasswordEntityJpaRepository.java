package com.honeybug.k8spractice.user.adapterpersistence.jpa;

import com.honeybug.k8spractice.user.adapterpersistence.entity.UserPasswordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPasswordEntityJpaRepository extends JpaRepository<UserPasswordEntity, Long> {

    Optional<UserPasswordEntity> findByUserId(Long userId);
}
