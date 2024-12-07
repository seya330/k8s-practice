package com.honeybug.k8spractice.user.adapterpersistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_password")
@Getter
@NoArgsConstructor
@Setter
public class UserPasswordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;

    private Long userId;
}
