package com.one.place.service.impl;

import com.one.place.enums.ApiErrors;
import com.one.place.service.I18nService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

@Service
public class I18nServiceImpl implements I18nService {

  @Autowired
  private ReloadableResourceBundleMessageSource messageSource;


  @Override
  public String getI18Message(ApiErrors apiErrors) {
    return getI18Message(apiErrors,null);
  }

  @Override
  public String getI18Message(ApiErrors apiErrors, Object[] args) {
    return getI18Message(apiErrors.getErrorMsgCode(),args);
  }

  @Override
  public String getI18Message(String errorMsgCode) {
    return getI18Message(errorMsgCode,null);
  }

  @Override
  public String getI18Message(String errorMsgCode, Object[] args) {
    return  messageSource.getMessage(errorMsgCode, args, LocaleContextHolder.getLocale());
  }
}
