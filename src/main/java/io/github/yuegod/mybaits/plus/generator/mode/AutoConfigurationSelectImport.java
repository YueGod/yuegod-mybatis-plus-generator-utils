package io.github.yuegod.mybaits.plus.generator.mode;

import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;

/**
 * @author YueGod
 * @date 2020/12/15
 * @description 自动装配
 **/
public class AutoConfigurationSelectImport extends AbstractSelectImport {

    @Override
    public List<String> getCandidateConfiguration() {
        //扫描spring.factories文件路径下的希望生成表的配置类
        return SpringFactoriesLoader.loadFactoryNames(getFactoriesType(), AutoConfigurationSelectImport.class.getClassLoader());
    }
}
