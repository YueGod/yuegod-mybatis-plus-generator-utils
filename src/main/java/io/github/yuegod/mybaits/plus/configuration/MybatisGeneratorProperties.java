package io.github.yuegod.mybaits.plus.configuration;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author YueGod
 * @date 2020/12/11
 * @description Mybatis代码生成配置资源
 */
@Data
@Accessors(chain = true)
public class MybatisGeneratorProperties {

    private String entity = "/templates";
    private String entityKt = "/templates";
    private String service = "/templates";
    private String serviceImpl = "/templates";
    private String mapper = "/templates";
    private String xml = "/templates";
    private String controller = "/templates";

}
