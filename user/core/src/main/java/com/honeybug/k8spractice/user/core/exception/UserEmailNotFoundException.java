package com.honeybug.k8spractice.user.core.exception;

public class UserEmailNotFoundException extends IllegalArgumentException {

    public UserEmailNotFoundException() {
        super("이메일이 존재하지 않습니다.");
    }
}
