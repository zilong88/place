package com.one.place.exceptions.analyzer;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class ConstraintViolationFailureAnalyzer extends
    AbstractFailureAnalyzer<ConstraintViolationException> {

  @Override
  public FailureAnalysis analyze(Throwable rootFailure, ConstraintViolationException cause) {
    ConstraintViolation<?>[] cvs = cause.getConstraintViolations()
        .toArray(new ConstraintViolation<?>[]{});
    ConstraintViolation<?> cv = cvs[0];
    return new FailureAnalysis(
        "reject invalid field: [" + cv.getInvalidValue() + "], reject message: " + cv
            .getMessage(), null, cause);
  }
}