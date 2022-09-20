package com.one.place.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import java.time.ZonedDateTime;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

  @Override
  public void insertFill(MetaObject metaObject) {
    Long nowAt = ZonedDateTime.now().toInstant().toEpochMilli();
    this.strictInsertFill(metaObject,"createdAt",Long.class, nowAt);
    this.strictInsertFill(metaObject,"updatedAt",Long.class,nowAt);
  }

  @Override
  public void updateFill(MetaObject metaObject) {
    Long nowAt = ZonedDateTime.now().toInstant().toEpochMilli();
    this.setFieldValByName("updatedAt",nowAt,metaObject);
    //metaObject.setValue("updatedAt",nowAt);
    //this.strictUpdateFill(metaObject,"updatedAt",Long.class,nowAt);
  }
}
