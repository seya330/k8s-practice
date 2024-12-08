package com.honeybug.k8spractice.user.core.exception;

public class InvalidUserPasswordException extends IllegalArgumentException {
    public InvalidUserPasswordException() {
        super("패스워드가 올바르지 않습니다.");
    }
}
