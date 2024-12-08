package com.honeybug.k8spractice.user.api.rest;

import com.honeybug.k8spractice.user.api.component.JwtComponent;
import com.honeybug.k8spractice.user.api.converter.UserApiConverter;
import com.honeybug.k8spractice.user.api.dto.UserLoginRequest;
import com.honeybug.k8spractice.user.api.dto.UserRegisterRequest;
import com.honeybug.k8spractice.user.api.dto.UserResponse;
import com.honeybug.k8spractice.user.application.port.in.UserLoginUseCase;
import com.honeybug.k8spractice.user.application.port.in.UserRegisterUseCase;
import com.honeybug.k8spractice.user.core.domain.UserInfo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserApiConverter userApiConverter;

    private final UserRegisterUseCase userRegisterUseCase;

    private final UserLoginUseCase userLoginUseCase;

    private final JwtComponent jwtComponent;


    @PostMapping("/signup")
    public ResponseEntity<UserResponse> signUp(@RequestBody @Valid final UserRegisterRequest request) {
        final UserInfo registered = userRegisterUseCase.register(userApiConverter.convert(request));
        final String accessToken = jwtComponent.createBearerToken(registered.getUserId().id().toString());
        return ResponseEntity.ok(new UserResponse(accessToken, registered.getEmail()));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody @Valid final UserLoginRequest request) {
        final UserInfo logined = userLoginUseCase.login(request.email(), request.password());
        final String accessToken = jwtComponent.createBearerToken(logined.getUserId().id().toString());
        return ResponseEntity.ok(new UserResponse(accessToken, logined.getEmail()));
    }
}
