package com.one.place.config;

import static springfox.documentation.builders.PathSelectors.ant;

import com.one.place.web.controller.TestController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@Configuration
@EnableSwagger2
@ConditionalOnProperty(prefix = "place.swagger", name = "enable", havingValue = "true")
public class SwaggerConfig implements WebMvcConfigurer {

  private String apiHost ;



  /**
   * 前台API
   */
  @Bean
  public Docket publicApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("test")
        .select()
        .apis(RequestHandlerSelectors.basePackage(TestController.class.getPackage().getName()))
        .paths(ant("/test/**"))
        .build()
        .host(apiHost)
        .apiInfo(publicApiInfo());

  }

//  /**
//   * 前台API
//   */
//  @Bean
//  public Docket openApi() {
//    return new Docket(DocumentationType.SWAGGER_2)
//        .groupName("openapi")
//        .select()
//        .apis(RequestHandlerSelectors.basePackage(TestController.class.getPackage().getName()))
//        .paths(ant("/openapi/**"))
//        .build()
//        .host(apiHost)
//        .apiInfo(publicApiInfo());
//
//  }
//
//  /**
//   * 前台API
//   */
//  @Bean
//  public Docket loginApi() {
//    return new Docket(DocumentationType.SWAGGER_2)
//        .groupName("app")
//        .select()
//        .apis(RequestHandlerSelectors.basePackage(TestController.class.getPackage().getName()))
//        .paths(ant("/app/**"))
//        .build()
//        .host(apiHost)
//        .apiInfo(loginApiInfo());
//
//  }
//
//
//  /**
//   * 前台API
//   */
//  @Bean
//  public Docket api() {
//    return new Docket(DocumentationType.SWAGGER_2)
//        .globalOperationParameters(singletonList(new ParameterBuilder()
//            .name("Authorization")
//            .description("令牌")
//            .modelRef(new ModelRef("string"))
//            .parameterType("header")
//            .required(false)
//            .build()))
//        .groupName("api")
//        .select()
//        .apis(RequestHandlerSelectors.basePackage(TestController.class.getPackage().getName()))
//        .paths(ant("/api/**"))
//        .build()
//        .host(apiHost)
//        .apiInfo(openApiInfo())
//        .securitySchemes(securitySchemes())
//        .securityContexts(securityContext());
//
//  }
//
//  private ApiInfo loginApiInfo() {
//    return new ApiInfoBuilder()
//        .title("huochain-nft-登录-API")
//        .description("huochain-nft-登录-API")
//        .version("1.0.0")
//        .build();
//  }
//
  private ApiInfo publicApiInfo() {
    return new ApiInfoBuilder()
        .title("huochain-nft-public-前台-API")
        .description("huochain-nft-public-前台-API")
        .version("1.0.0")
        .build();
  }
//
//  private ApiInfo openApiInfo() {
//    return new ApiInfoBuilder()
//        .title("huochain-nft-前台-API")
//        .description("huochain-nft-前台-API")
//        .version("1.0.0")
//        .build();
//  }
//
//  private List<ApiKey> securitySchemes() {
//    List<ApiKey> apiKeyList = new ArrayList<>();
//    apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
//    return apiKeyList;
//  }
//
//
//  private List<SecurityContext> securityContext() {
//    List<SecurityContext> securityContexts = new ArrayList<>();
//    securityContexts.add(
//            SecurityContext.builder()
//                    .securityReferences(defaultAuth())
//                    .build());
//    return securityContexts;
//  }
//
//  private List<SecurityReference> defaultAuth() {
//    AuthorizationScope authorizationScope
//            = new AuthorizationScope("global", "accessEverything");
//    AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//    authorizationScopes[0] = authorizationScope;
//    return singletonList(
//        new SecurityReference("Authorization", authorizationScopes));
//  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
    registry.addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
    registry.addResourceHandler("/favicon.ico")
            .addResourceLocations("classpath:/META-INF/resources/favicon.ico");
  }
}
