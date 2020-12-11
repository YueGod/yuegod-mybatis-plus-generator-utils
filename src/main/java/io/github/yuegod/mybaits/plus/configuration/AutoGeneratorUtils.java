package io.github.yuegod.mybaits.plus.configuration;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author YueGod
 * @date 2020/12/11
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class AutoGeneratorUtils extends AutoGenerator {


    /**
     * 配置信息
     */
    protected ConfigBuilder config;
    /**
     * 注入配置
     */
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    protected InjectionConfig injectionConfig;
    /**
     * 数据源配置
     */
    private DataSourceConfig dataSource;
    /**
     * 数据库表配置
     */
    private StrategyConfig strategy;
    /**
     * 包 相关配置
     */
    private PackageConfig packageInfo;
    /**
     * 模板 相关配置
     */
    private TemplateConfig template;
    /**
     * 全局 相关配置
     */
    private GlobalConfig globalConfig;
    /**
     * 模板引擎
     */
    private AbstractTemplateEngine templateEngine;


    @Override
    public void execute() {
        execute(new YueGodTemplateConfiguration());
    }

    public void execute(YueGodTemplateConfiguration configuration) {
        this.config = new ConfigBuilder(packageInfo, dataSource, strategy, configuration.getTemplateConfig(), globalConfig);
        if (null == templateEngine) {
            // 为了兼容之前逻辑，采用 Velocity 引擎 【 默认 】
            templateEngine = new VelocityTemplateEngine();
        }
        // 模板引擎初始化执行文件输出
        templateEngine.init(this.pretreatmentConfigBuilder(config));
        templateEngine.mkdirs();
        templateEngine.batchOutput();
        templateEngine.open();
        System.out.println("==========================文件生成完成！！！==========================");
    }
}
