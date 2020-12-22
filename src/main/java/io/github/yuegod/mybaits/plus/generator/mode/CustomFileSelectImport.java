package io.github.yuegod.mybaits.plus.generator.mode;

import io.github.yuegod.mybaits.plus.generator.util.FactoriesLoaderUtils;

import java.util.List;

/**
 * @author YueGod
 * @date 2020/12/15
 * @description 自定义文件扫描
 **/
public class CustomFileSelectImport extends AbstractSelectImport {

    @Override
    protected List<String> getCandidateConfiguration() {
        return FactoriesLoaderUtils.loadFactoryNames
                (getFactoriesType(), CustomFileSelectImport.class.getClassLoader(), getProperties().getFilename());
    }
}
