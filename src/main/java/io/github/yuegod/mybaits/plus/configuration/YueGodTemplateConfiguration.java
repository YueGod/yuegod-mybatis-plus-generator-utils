package io.github.yuegod.mybaits.plus.configuration;

import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import io.github.yuegod.mybaits.plus.constant.TemplateFileNameConstants;
import lombok.Getter;

/**
 * @author YueGod
 * @date 2020/12/11
 * @description 自定义模板配置
 */

public class YueGodTemplateConfiguration extends TemplateConfig {

    @Getter
    private final TemplateConfig templateConfig;

    public YueGodTemplateConfiguration() {
        this(new MybatisGeneratorProperties());
    }

    public YueGodTemplateConfiguration(MybatisGeneratorProperties properties) {
        templateConfig = properties2TemplateConfig(properties);
    }

    public TemplateConfig properties2TemplateConfig(MybatisGeneratorProperties properties) {
        //初始化模板数据
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntityKt(properties.getEntityKt() + TemplateFileNameConstants.ENTITY_KT_FILE);
        templateConfig.setEntity(properties.getEntity() + TemplateFileNameConstants.ENTITY_FILE);
        templateConfig.setService(properties.getService() + TemplateFileNameConstants.SERVICE_FILE);
        templateConfig.setServiceImpl(properties.getServiceImpl() + TemplateFileNameConstants.SERVICE_IMPL_FILE);
        templateConfig.setMapper(properties.getMapper() + TemplateFileNameConstants.MAPPER_FILE);
        templateConfig.setXml(properties.getXml() + TemplateFileNameConstants.XML_FILE);
        templateConfig.setController(properties.getController() + TemplateFileNameConstants.CONTROLLER_FILE);
        return templateConfig;
    }
}
