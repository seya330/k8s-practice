package com.honeybug.k8spractice.user.core.domain;

import com.honeybug.k8spractice.user.core.valueobject.PhoneNumber;
import com.honeybug.k8spractice.user.core.valueobject.UserId;
import com.honeybug.k8spractice.user.core.valueobject.UserType;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserInfo {

    private UserId userId;

    private String name;

    @Email
    private String email;

    private PhoneNumber phoneNumber;

    private UserType userType;

    @Builder
    public UserInfo(String name, String email, PhoneNumber phoneNumber, UserType userType) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;
    }
}
