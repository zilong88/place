package com.one.place.exceptions;

import com.one.place.enums.ApiErrors;
import com.one.place.exceptions.analyzer.ApiExceptionFailureAnalyzer;
import com.one.place.exceptions.analyzer.BindingExceptionFailureAnalyzer;
import com.one.place.exceptions.analyzer.ConstraintViolationFailureAnalyzer;
import com.one.place.exceptions.analyzer.MethodArgumentValidFailureAnalyzer;
import com.one.place.service.I18nService;
import com.one.place.web.resp.ApiResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
 private static Logger log  = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  private final ApiExceptionFailureAnalyzer apiExceptionAnalyzer = new ApiExceptionFailureAnalyzer();
  private final MethodArgumentValidFailureAnalyzer methodArgumentValidAnalyzer = new MethodArgumentValidFailureAnalyzer();
  private final ConstraintViolationFailureAnalyzer validationFailureAnalyzer = new ConstraintViolationFailureAnalyzer();
  private final BindingExceptionFailureAnalyzer bindingFailureAnalyzer = new BindingExceptionFailureAnalyzer();

  @Autowired
  private I18nService i18nService;

  @ExceptionHandler(value = ApiException.class)
  @ResponseBody
  public ApiResponse<Void> apiException(ApiException exception) {
    doFailureAnalysis(apiExceptionAnalyzer.analyze(exception), exception);
    ApiErrors error = exception.getError();
    String errorMsgCode = error.getErrorMsgCode();
    String errMsg = i18nService.getI18Message(errorMsgCode, exception.getArgsHolder());
    return ApiResponse.error(errMsg, errorMsgCode);
  }

  @ExceptionHandler(value = ConstraintViolationException.class)
  @ResponseBody
  public ApiResponse<Void> constraintViolationException(
      ConstraintViolationException exception) {
    doFailureAnalysis(validationFailureAnalyzer.analyze(exception), exception);
    ConstraintViolation<?> constraintViolation =
        (ConstraintViolation<?>) exception.getConstraintViolations().toArray()[0];
    String fieldName = constraintViolation.getPropertyPath().toString();
    String errorMsgCode = ApiErrors.BAD_ARGUMENT_ERROR.getErrorMsgCode();
    return ApiResponseWithField.withField(constraintViolation.getMessage(), errorMsgCode,
        fieldName);
  }

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  @ResponseBody
  public ApiResponse<Void> methodArgumentNotValidException(
      MethodArgumentNotValidException exception) {
    doFailureAnalysis(methodArgumentValidAnalyzer.analyze(exception), exception);
    String errorMsgCode = ApiErrors.BAD_ARGUMENT_ERROR.getErrorMsgCode();
    FieldError fe = exception.getBindingResult().getFieldError();
    if (fe != null) {
      String fieldName = fe.getField();
      return ApiResponseWithField.withField(fe.getDefaultMessage(), errorMsgCode, fieldName);
    }
    String i18Message = i18nService.getI18Message(errorMsgCode, null);
    return ApiResponse.error(i18Message, errorMsgCode);
  }


  private void doFailureAnalysis(FailureAnalysis analysis, Exception ex) {
    if (analysis == null) {
      log.error("系统异常",ex);
      return;
    }
    if (analysis.getDescription() == null) {
      log.warn("api error handler : " + ex.getMessage(), ex);
    } else {
      log.warn(analysis.getDescription(), ex);
    }
  }
}
