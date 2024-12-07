package com.honeybug.k8spractice.user.core.exception;

public class UserPasswordNotFoundException extends RuntimeException {

    public UserPasswordNotFoundException() {
        super("관리자에게 문의해 주세요.");
    }
}
