package com.honeybug.k8spractice.user.core.valueobject;

import jakarta.validation.constraints.NotEmpty;

public record PhoneNumber(
        @NotEmpty String firstPart,
        @NotEmpty String middlePart,
        @NotEmpty String lastPart
) {

    public static PhoneNumber of(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("전화번호는 비어있을 수 없습니다.");
        }

        if (phoneNumber.length() != 11) {
            throw new IllegalArgumentException("전화번호는 11자리여야 합니다.");
        }

        if (phoneNumber.charAt(0) != '0') {
            throw new IllegalArgumentException("전화번호는 0으로 시작해야 합니다.");
        }

        if (!phoneNumber.matches("\\d{11}")) {
            throw new IllegalArgumentException("전화번호는 숫자로만 이루어져야 합니다.");
        }

        String firstPart = phoneNumber.substring(0, 3);
        String middlePart = phoneNumber.substring(3, 7);
        String lastPart = phoneNumber.substring(7, 11);
        return new PhoneNumber(firstPart, middlePart, lastPart);
    }

    @Override
    public String toString() {
        return firstPart + middlePart + lastPart;
    }
}
