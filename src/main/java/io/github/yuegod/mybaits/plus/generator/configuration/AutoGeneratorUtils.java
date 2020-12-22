package io.github.yuegod.mybaits.plus.generator.configuration;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import io.github.yuegod.mybaits.plus.generator.property.enums.ScanTypeEnum;

import javax.lang.model.element.UnknownElementException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author YueGod
 * @date 2020/12/11
 * @description
 */
public class AutoGeneratorUtils extends AutoGenerator {

    private AbstractTemplateEngine templateEngine;


    private final Map<ScanTypeEnum, Consumer<Object>> MAP = new HashMap<>();

    public AutoGeneratorUtils(ScanTypeEnum scanType) {
        this.MAP.put(ScanTypeEnum.LOCALITY, locality());
        this.MAP.put(ScanTypeEnum.ALL, all());
    }

    public AutoGeneratorUtils() {
        this(ScanTypeEnum.ALL);
    }

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
        Consumer<Object> consumer = MAP.get(ScanTypeEnum.ALL);
        consumer.accept(null);
        System.out.println("==========================文件生成完成！！！==========================");
    }

    public void execute(YueGodTemplateConfiguration configuration, ScanTypeEnum scanType) {
        switch (scanType) {
            case ALL:
                execute(configuration);
                break;
            case LOCALITY:
                MAP.get(ScanTypeEnum.LOCALITY).accept(configuration);
                break;
            default:
                throw new RuntimeException("未知的类型");
        }
    }

    public Consumer<Object> locality() {
        return e -> {};
    }

    public Consumer<Object> all() {
        return e -> templateEngine.init(this.pretreatmentConfigBuilder(config)).mkdirs().batchOutput().open();
    }
}
