package com.one.place.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.Map;

/**
 * json 工具类
 */
public enum JsonUtil {
  ;
  private static ObjectMapper snakeCaseMapper = createObjectMapper(
      PropertyNamingStrategies.SNAKE_CASE);



  static ObjectMapper createObjectMapper(PropertyNamingStrategy strategy) {
    final ObjectMapper mapper = new ObjectMapper();
    mapper.setPropertyNamingStrategy(strategy);
    mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
    // disabled features:
    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    // register module
    //SimpleModule simpleModule = new SimpleModule();
    //simpleModule.addSerializer(BigDecimal.class, new Number2StringSerializer());
    //mapper.registerModule(simpleModule);
    // mapper.registerModule(new JavaTimeModule());
    return mapper;
  }

  public static <T> T readValue(String json, Class<T> clazz) {
    try {
      return snakeCaseMapper.readValue(json, clazz);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static <T> T readValue(String json, TypeReference<T> typeReference) {
    try {
      return snakeCaseMapper.readValue(json, typeReference);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static Map<String, Object> readMapValue(String json) {
    return readValue(json, new TypeReference<Map<String, Object>>() {
    });
  }

  public static String writeValueAsString(Object obj) {
    try {
      if (obj != null) {
        return snakeCaseMapper.writeValueAsString(obj);
      }
      return "";
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
