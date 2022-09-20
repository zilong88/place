package com.one.place.general;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import org.junit.jupiter.api.Test;

public class GeneralJavaCode {
  /**
   * 数据源配置
   */
  private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
      .Builder("jdbc:mysql://116.63.143.239:3310/little_hippo?serverTimezone=Asia/Shanghai", "root", "huochain")
      .schema("little_hippo")
      .typeConvert(new MySqlTypeConvert())
      .keyWordsHandler(new MySqlKeyWordsHandler())
      .build();

  @Test
  public void testSimple() {
    AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
    generator.packageInfo(new PackageConfig.Builder().parent("com.one.place")
        .entity("entity")
        .build());
    generator.strategy(new StrategyConfig.Builder()
        .addTablePrefix("t_")
        .addFieldPrefix("f_")
            .entityBuilder()
            .versionColumnName("f_version")
            .versionPropertyName("version")
            .addTableFills(new Column("createdAt", FieldFill.INSERT))
            .addTableFills(new Property("updatedAt",FieldFill.INSERT_UPDATE))
        .build());


    generator.execute();

  }
}
