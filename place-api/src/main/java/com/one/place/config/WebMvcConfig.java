package com.one.place.config;

import java.nio.charset.StandardCharsets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

  /**
   * 国际化配置
   * @return
   */
  @Bean
  public ReloadableResourceBundleMessageSource resourceBundleMessageSource() {
    ReloadableResourceBundleMessageSource rbms = new ReloadableResourceBundleMessageSource();
    rbms.setDefaultEncoding(StandardCharsets.UTF_8.name());
    rbms.setFallbackToSystemLocale(false);
    rbms.addBasenames(
        "classpath:i18n/ValidationMessages",
        "classpath:i18n/PlaceMessages",
        "classpath:org/hibernate/validator/ValidationMessages");
    return rbms;
  }

  @Override
  public Validator getValidator() {
    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    bean.setValidationMessageSource(resourceBundleMessageSource());
    return bean;
  }

//  /**
//   * 国际化配置
//   *
//   * @param resourceBundleMessageSource
//   * @return
//   */
//  public LocalValidatorFactoryBean validator(
//      ReloadableResourceBundleMessageSource resourceBundleMessageSource) {
//    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
//    bean.setValidationMessageSource(resourceBundleMessageSource);
//    return bean;
//  }
  

}
