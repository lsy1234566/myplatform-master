package com.lsy.platform.business;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootTest
public class BusinessApplicationTest {
    @Value("${spring.datasource.url}")
    private String dbUrl;
    @Value("${spring.datasource.driver-class-name}")
    private String dbDriverClassName;
    @Value("${spring.datasource.username}")
    private String dbUsername;
    @Value("${spring.datasource.password}")
    private String dbPassword;

    /**
     * 要自动生成代码的数据库表名，例如表名为demo
     */
    private static String[] TABLE_NAMES = new String[]{"t_a_activity"};

    @Test
    public void t1() {
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");//这里写你自己的java目录
        gc.setFileOverride(true);//是否覆盖
        gc.setOpen(false);//生成后是否打开文件夹
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor("lsy");
        gc.setIdType(IdType.AUTO);
        //gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(dbDriverClassName);
        dsc.setUsername(dbUsername);
        dsc.setPassword(dbPassword);
        dsc.setUrl(dbUrl);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(null);
        pc.setEntity("com.lsy.platform.business.model");
        pc.setMapper("com.lsy.platform.business.mapper");
        pc.setXml("com.lsy.platform.business.mappers");
        pc.setService("com.lsy.platform.business.service");
        pc.setServiceImpl("com.lsy.platform.business.service.impl");
        pc.setController("com.lsy.platform.business.controller");
        mpg.setPackageInfo(pc);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.no_change);//字段不使用驼峰
        strategy.setInclude(TABLE_NAMES);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        mpg.setStrategy(strategy);

        // 执行生成
        mpg.execute();


    }
}
