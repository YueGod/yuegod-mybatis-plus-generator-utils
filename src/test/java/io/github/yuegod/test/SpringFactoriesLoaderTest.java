package io.github.yuegod.test;

import io.github.yuegod.mybaits.plus.generator.annotation.GeneratorTemplate;
import io.github.yuegod.mybaits.plus.generator.mode.AbstractSelectImport;
import io.github.yuegod.mybaits.plus.generator.mode.AutoConfigurationSelectImport;
import io.github.yuegod.mybaits.plus.generator.mode.CustomFileSelectImport;
import io.github.yuegod.mybaits.plus.generator.property.LocalityTypeProperties;

import java.util.List;
import java.util.Properties;

/**
 * @author YueGod
 * @date 2020/12/15
 * @description
 **/
public class SpringFactoriesLoaderTest {

    public static void main(String[] args) {
        load2();
//        load();
    }

    public static void load() {
        AbstractSelectImport selectImport = new AutoConfigurationSelectImport();
        selectImport.execute(new LocalityTypeProperties());
        List<String> candidate = selectImport.getCandidate();
        System.out.println(candidate);
    }

    public static void load2() {
        AbstractSelectImport selectImport = new CustomFileSelectImport();
        LocalityTypeProperties properties = new LocalityTypeProperties();
        properties.setFilename("META-INF/custom.factories");
//        selectImport.init(properties);
        List<String> candidate = selectImport.getCandidate();
        System.out.println(candidate);
    }

}
