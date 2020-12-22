package io.github.yuegod.mybaits.plus.generator.configuration;

import io.github.yuegod.mybaits.plus.generator.mode.AbstractSelectImport;
import io.github.yuegod.mybaits.plus.generator.property.LocalityTypeProperties;

/**
 * @author YueGod
 * @date 2020/12/15
 * @description 策略类
 **/
public class Locality {

    public void strategy(boolean auto) {
        LocalityFactory factory = new LocalityFactory();
        AbstractSelectImport selectImport = factory.factory(auto);
        selectImport.execute(new LocalityTypeProperties());
    }

}
