package io.github.yuegod.mybaits.plus.generator.configuration;

import io.github.yuegod.mybaits.plus.generator.mode.AbstractSelectImport;
import io.github.yuegod.mybaits.plus.generator.mode.AutoConfigurationSelectImport;
import io.github.yuegod.mybaits.plus.generator.mode.CustomFileSelectImport;

/**
 * @author YueGod
 * @date 2020/12/15
 * @description 局部生成方式工厂创建类
 **/
public class LocalityFactory {

    public AbstractSelectImport factory(boolean auto) {
        if (auto) {
            return new AutoConfigurationSelectImport();
        }
        return new CustomFileSelectImport();
    }

}
