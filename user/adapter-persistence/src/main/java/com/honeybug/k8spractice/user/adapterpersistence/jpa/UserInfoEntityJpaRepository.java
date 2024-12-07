package com.honeybug.k8spractice.user.adapterpersistence.jpa;

import com.honeybug.k8spractice.user.adapterpersistence.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoEntityJpaRepository extends JpaRepository<UserInfoEntity, Long> {

    Optional<UserInfoEntity> findByEmail(String email);
}
