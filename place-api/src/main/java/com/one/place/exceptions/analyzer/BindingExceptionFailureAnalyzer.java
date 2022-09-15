package com.one.place.exceptions.analyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;

public class BindingExceptionFailureAnalyzer extends AbstractFailureAnalyzer<BindException> {

  @Override
  protected FailureAnalysis analyze(Throwable rootFailure, BindException cause) {
    FieldError fe = cause.getFieldError();
    return new FailureAnalysis(
        "reject invalid argument field value: " + fe.getField() + "=[" + fe.getRejectedValue()
            + "], reject message: " + fe.getDefaultMessage(), null, cause);
  }
}