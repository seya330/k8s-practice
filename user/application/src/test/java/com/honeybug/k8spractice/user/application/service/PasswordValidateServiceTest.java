package com.honeybug.k8spractice.user.application.service;

import com.honeybug.k8spractice.shared.fixture.FixtureHelper;
import com.honeybug.k8spractice.user.application.port.out.UserPasswordFindPort;
import com.honeybug.k8spractice.user.core.domain.UserPassword;
import com.honeybug.k8spractice.user.core.exception.UserPasswordNotMatchedException;
import com.honeybug.k8spractice.user.core.valueobject.UserId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.navercorp.fixturemonkey.api.expression.JavaGetterMethodPropertySelector.javaGetter;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PasswordValidateServiceTest {

    @InjectMocks
    PasswordValidateService passwordValidateService;

    @Mock
    UserPasswordFindPort userPasswordFindPort;

    @Mock
    PasswordEncoder passwordEncoder;

    @Captor
    ArgumentCaptor<UserId> userIdCaptor;

    @Captor
    ArgumentCaptor<String> savedPasswordCaptor;

    @Captor
    ArgumentCaptor<String> inputPasswordCaptor;

    @Test
    void validateForLogin() {
        final UserId userId = FixtureHelper.get().giveMeBuilder(UserId.class)
                .sample();
        final String password = FixtureHelper.get().giveMeBuilder(String.class)
                .sample();
        final UserPassword userPassword = FixtureHelper.get().giveMeBuilder(UserPassword.class)
                .set(javaGetter(UserPassword::userId), userId)
                .set(javaGetter(UserPassword::password), password)
                .sample();

        given(userPasswordFindPort.getByUserId(any()))
                .willReturn(userPassword);
        given(passwordEncoder.matches(anyString(), anyString()))
                .willReturn(true);

        passwordValidateService.validateForLogin(userId, password);
        verify(userPasswordFindPort).getByUserId(userIdCaptor.capture());
        verify(passwordEncoder).matches(inputPasswordCaptor.capture(), savedPasswordCaptor.capture());

        assertThat(userIdCaptor.getValue()).isEqualTo(userId);
        assertThat(inputPasswordCaptor.getValue()).isEqualTo(password);
        assertThat(savedPasswordCaptor.getValue()).isEqualTo(password);
    }

    @Test
    void validateForLogin_userIdIsNull() {
        final UserId userId = null;
        final String password = FixtureHelper.get().giveMeBuilder(String.class)
                .sample();

        assertThatThrownBy(() -> passwordValidateService.validateForLogin(userId, password))
                .isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    void validateForLogin_passwordIsNull() {
        final UserId userId = FixtureHelper.get().giveMeBuilder(UserId.class)
                .sample();
        final String password = null;

        assertThatThrownBy(() -> passwordValidateService.validateForLogin(userId, password))
                .isExactlyInstanceOf(NullPointerException.class);
    }

    @Test
    void validateForLogin_passwordNotMatched() {
        final UserId userId = FixtureHelper.get().giveMeBuilder(UserId.class)
                .sample();
        final String password = FixtureHelper.get().giveMeBuilder(String.class)
                .sample();
        final UserPassword userPassword = FixtureHelper.get().giveMeBuilder(UserPassword.class)
                .set(javaGetter(UserPassword::userId), userId)
                .set(javaGetter(UserPassword::password), password + "a")
                .sample();

        given(userPasswordFindPort.getByUserId(any()))
                .willReturn(userPassword);
        given(passwordEncoder.matches(anyString(), anyString()))
                .willReturn(false);

        assertThatThrownBy(() -> passwordValidateService.validateForLogin(userId, password))
                .isExactlyInstanceOf(UserPasswordNotMatchedException.class);
    }
}