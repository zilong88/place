package com.one.place.exceptions.analyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class MethodArgumentValidFailureAnalyzer extends
    AbstractFailureAnalyzer<MethodArgumentNotValidException> {

  @Override
  protected FailureAnalysis analyze(Throwable rootFailure,
      MethodArgumentNotValidException cause) {
    FieldError fe = cause.getBindingResult().getFieldError();
    if (fe != null) {
      return new FailureAnalysis(
          "reject invalid argument field value: " + fe.getField() + "=[" + fe.getRejectedValue()
              + "], reject message: " + fe
              .getDefaultMessage(), null, cause);
    }
    ObjectError oe = cause.getBindingResult().getGlobalError();
    if (oe != null) {
      return new FailureAnalysis(
          "reject invalid argument object: " + oe.getObjectName() + ", reject message: " + oe
              .getDefaultMessage(),
          null,
          cause);
    }
    return new FailureAnalysis(null, null, cause);
  }
}