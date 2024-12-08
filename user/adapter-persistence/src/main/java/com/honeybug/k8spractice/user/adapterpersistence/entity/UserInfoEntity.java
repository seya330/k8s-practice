package com.honeybug.k8spractice.user.adapterpersistence.entity;

import com.honeybug.k8spractice.user.core.valueobject.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_info")
@NoArgsConstructor
@Getter
@Setter
public class UserInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    private String email;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
