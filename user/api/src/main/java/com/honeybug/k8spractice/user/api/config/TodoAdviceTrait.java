package com.honeybug.k8spractice.user.api.config;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.ProblemBuilder;
import org.zalando.problem.Status;
import org.zalando.problem.StatusType;
import org.zalando.problem.spring.web.advice.AdviceTrait;
import org.zalando.problem.spring.web.advice.validation.ValidationAdviceTrait;
import org.zalando.problem.violations.Violation;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;

public interface TodoAdviceTrait extends AdviceTrait, ValidationAdviceTrait  {

  @Override
  default ProblemBuilder prepare(final Throwable throwable, final StatusType status, final URI type) {
    return Problem.builder()
        .withTitle(status.getReasonPhrase())
        .withStatus(status)
        .withDetail(throwable.getMessage())
        .withCause(Optional.ofNullable(throwable.getCause())
            .filter(cause -> isCausalChainsEnabled())
            .map(this::toProblem)
            .orElse(null));
  }

  @Override
  default ResponseEntity<Problem> newConstraintViolationProblem(final Throwable throwable, final Collection<Violation> stream, final NativeWebRequest request) {
    final StatusType status = defaultConstraintViolationStatus();
    final List<Violation> violations = stream.stream()
        .sorted(comparing(Violation::getField).thenComparing(Violation::getMessage))
        .toList();
    final Problem problem = ConstraintViolationProblem.builder()
        .status(status)
        .detail("요청 제약조건에 맞지 않습니다.")
        .violations(violations)
        .build();
    return create(throwable, problem, request);
  }

  @ExceptionHandler
  default ResponseEntity<Problem> expiredJwtExceptionHandle(final ExpiredJwtException exception, final NativeWebRequest request) {
    return create(Status.UNAUTHORIZED, exception, request);
  }

  @ExceptionHandler
  default ResponseEntity<Problem> asdf(final IllegalArgumentException exception, final NativeWebRequest request) {
    return create(Status.BAD_REQUEST, exception, request);
  }
}
