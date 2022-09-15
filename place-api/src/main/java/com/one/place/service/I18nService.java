package com.one.place.service;

import com.one.place.enums.ApiErrors;

public interface I18nService {

  String getI18Message(ApiErrors apiErrors);
  String getI18Message(ApiErrors apiErrors,Object[] args);
  String getI18Message(String errorMsgCode);
  String getI18Message(String errorMsgCode, Object[] args);
}
