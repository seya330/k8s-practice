package com.honeybug.k8spractice.user.core.exception;

public class DuplicatedUserEmailException extends IllegalArgumentException {

    public DuplicatedUserEmailException() {
        super("중복된 이메일 입니다.");
    }
}
