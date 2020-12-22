package io.github.yuegod.mybaits.plus.generator.util;

import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @author YueGod
 * @date 2020/12/15
 * @description Factories文件读取工具
 **/
public class FactoriesLoaderUtils {

    /**
     * 通过facoryType和filename加载对应配置项
     * @param factoryType 配置类中的key
     * @param classLoader 对应的类加载器
     * @param filename 需要读取的文件名
     *
     * @return 返回一个搜索到的对应的候选人名单
     */
    public static List<String> loadFactoryNames(Class<?> factoryType, @Nullable ClassLoader classLoader, String filename) {
        String factoryTypeName = factoryType.getName();
        return loadFactories(classLoader, filename).getOrDefault(factoryTypeName, Collections.emptyList());
    }

    public static Map<String, List<String>> loadFactories(ClassLoader classLoader, String filename) {
        try {
            Enumeration<URL> urls = classLoader != null ? classLoader.getResources(filename) : ClassLoader.getSystemResources(filename);
            LinkedMultiValueMap result = new LinkedMultiValueMap();

            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                UrlResource resource = new UrlResource(url);
                Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                Iterator var6 = properties.entrySet().iterator();

                while (var6.hasNext()) {
                    Map.Entry<?, ?> entry = (Map.Entry) var6.next();
                    String factoryTypeName = ((String) entry.getKey()).trim();
                    String[] var9 = StringUtils.commaDelimitedListToStringArray((String) entry.getValue());
                    int var10 = var9.length;

                    for (int var11 = 0; var11 < var10; ++var11) {
                        String factoryImplementationName = var9[var11];
                        result.add(factoryTypeName, factoryImplementationName.trim());
                    }
                }
            }

            return result;
        } catch (IOException var13) {
            throw new IllegalArgumentException("Unable to load factories from location [" + filename + "]", var13);
        }
    }

}
