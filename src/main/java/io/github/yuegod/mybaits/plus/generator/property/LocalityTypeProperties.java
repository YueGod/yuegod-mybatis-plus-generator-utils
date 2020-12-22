package io.github.yuegod.mybaits.plus.generator.property;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author YueGod
 * @date 2020/12/15
 * @description 局部扫描方式
 **/
@Data
@Accessors(chain = true)
public class LocalityTypeProperties {
    /**
     * 是否启用自动装配的模式
     * </p>
     * 如果为true则会读取spring.factories文件下的内容
     * 如果为false则会读取filename中配置的文件名
     */
    private boolean auto;

    /**
     * 需要扫描文件的文件路径
     * </p>
     * 如果启用文件扫描模式，则会读取出该属性下的文件。
     * 文件名随意，但是文件类型是properties类型。
     */
    private String filename;
}
