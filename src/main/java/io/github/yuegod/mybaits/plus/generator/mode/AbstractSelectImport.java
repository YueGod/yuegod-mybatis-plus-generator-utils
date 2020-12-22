package io.github.yuegod.mybaits.plus.generator.mode;

import io.github.yuegod.mybaits.plus.generator.annotation.GeneratorTemplate;
import io.github.yuegod.mybaits.plus.generator.property.LocalityTypeProperties;
import lombok.Getter;

import java.util.List;

/**
 * @author YueGod
 * @date 2020/12/15
 * @description
 **/
public abstract class AbstractSelectImport {

    /**
     * 候选人名单
     */
    @Getter
    private List<String> candidate;

    @Getter
    private LocalityTypeProperties properties;

    /**
     * 获取候选人名单，每个模式获取候选人名单的方式都不一样。因此抽取出来由子类重写
     *
     * @return 返回一个候选人名单，可以是一个class的名称，也可以是一个完整的类路径
     */
    protected abstract List<String> getCandidateConfiguration();

    protected Class<?> getFactoriesType() {
        return GeneratorTemplate.class;
    }

    /**
     * 初始化各配置项
     */
    private void init() {
        init(new LocalityTypeProperties());
    }

    /**
     * 只有自定义的时候需要用到这个方法
     *
     * @param properties 资源配置文件
     */
    private void init(LocalityTypeProperties properties) {
        this.properties = properties;
        this.candidate = getCandidateConfiguration();
    }

    public final void execute(LocalityTypeProperties properties) {
        if (properties.isAuto()) {
            init();
        } else {
            init(properties);
        }
    }

}
