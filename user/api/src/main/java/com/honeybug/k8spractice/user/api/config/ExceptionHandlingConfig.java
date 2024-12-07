package com.honeybug.k8spractice.user.api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.spring.web.advice.security.SecurityAdviceTrait;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlingConfig implements TodoAdviceTrait, SecurityAdviceTrait, ProblemHandling {

}
