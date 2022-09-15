package com.one.place.exceptions.analyzer;

import com.one.place.enums.ApiErrors;
import com.one.place.exceptions.ApiException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

public class ApiExceptionFailureAnalyzer extends AbstractFailureAnalyzer<ApiException> {

  @Override
  protected FailureAnalysis analyze(Throwable rootFailure, ApiException cause) {
    ApiErrors error = cause.getError();
    if (error == ApiErrors.SYSTEM_ERROR) {
      return new FailureAnalysis(null, null, cause);
    } else {
      StringBuilder builder = new StringBuilder(250);
      builder.append("handler checked api exception: ").append(cause.getError().getErrorMsgCode())
          .append("(").append(cause.getMessage()).append(").");
      StackTraceElement[] traces = cause.getStackTrace();
      builder.append(" Caused by ").append(traces[0].getClassName()).append(".")
          .append(traces[0].getMethodName())
          .append("(").append(traces[0].getFileName()).append(":")
          .append(traces[0].getLineNumber()).append(").");
      if (traces.length >= 2) {
        builder.append(" Caused by ").append(traces[1].getClassName()).append(".")
            .append(traces[1].getMethodName())
            .append("(").append(traces[1].getFileName()).append(":")
            .append(traces[1].getLineNumber()).append(").");
      }
      return new FailureAnalysis(builder.toString(), null, cause);
    }
  }
}