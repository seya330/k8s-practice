package com.honeybug.k8spractice.user.api.config;

import jakarta.annotation.Nullable;
import lombok.Builder;
import org.zalando.problem.StatusType;
import org.zalando.problem.ThrowableProblem;
import org.zalando.problem.violations.Violation;

import java.util.Collections;
import java.util.List;

public class ConstraintViolationProblem extends ThrowableProblem {

  private final String title;
  private final StatusType status;
  private final List<Violation> violations;
  private final String detail;

  @Builder
  public ConstraintViolationProblem(final String title, final StatusType status, final List<Violation> violations, final String detail) {
    this.title = title == null ? "Constraint Violation" : title;
    this.status = status;
    this.violations = violations != null ? Collections.unmodifiableList(violations) : Collections.emptyList();
    this.detail = detail;
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public StatusType getStatus() {
    return status;
  }

  @Override
  public @Nullable String getDetail() {
    return detail;
  }

  public List<Violation> getViolations() {
    return violations;
  }

}
