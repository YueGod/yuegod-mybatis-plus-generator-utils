package io.github.yuegod.mybaits.plus.configuration;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

/**
 * @author YueGod
 * @date 2020/12/11
 * @description
 */
public class AutoGeneratorUtils extends AutoGenerator {

    private AbstractTemplateEngine templateEngine;

    @Override
    public void execute() {
        execute(new YueGodTemplateConfiguration());
    }

    public void execute(YueGodTemplateConfiguration configuration) {
        this.config = new ConfigBuilder(this.getPackageInfo(), this.getDataSource(), this.getStrategy(), configuration.getTemplateConfig(), this
                .getGlobalConfig());
        if (null == this.getTemplateEngine()) {
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
