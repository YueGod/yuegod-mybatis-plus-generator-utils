package io.github.yuegod.mybaits.plus.generator.property;

import io.github.yuegod.mybaits.plus.generator.property.enums.ScanTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

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

    /**
     * 需要生成模板类型的方式，局部扫描还是全局扫描
     */
    private ScanTypeEnum scanType;

    /**
     * 如果为局部扫描方式，则需要设置此属性
     */
    private LocalityTypeProperties locality;

}
