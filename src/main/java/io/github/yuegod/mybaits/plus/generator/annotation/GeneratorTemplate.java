package io.github.yuegod.mybaits.plus.generator.annotation;

import java.lang.annotation.*;

/**
 * @author YueGod
 * @date 2020/12/15
 * @description
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface GeneratorTemplate {
    /**
     * 以注解方式扫描的会通过该值判断具体读取哪个文件
     */
    String value() default "";
}
