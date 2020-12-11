# Mybaits-plus代码自动生成工具类

###### 1.Maven引入

```
<dependency>
	<groupId>io.github.yuegod</groupId>
    <artifactId>yuegod-mybatis-plus-generator-utils</artifactId>
    <version>1.0</version>
</dependency>
```
###### 2.使用方法
使用方法大体和之前的AutoGenerator无异，主要是增加了以下可选方法配置
1.使用自定义模板路径
```java 
 //设置模板文件目录路径
         // 代码生成器
        AutoGeneratorUtils mpg = new AutoGeneratorUtils();
        
        String url = "/mybatis/templates";
        MybatisGeneratorProperties properties = new MybatisGeneratorProperties();
        properties
                .setEntity(url)
                .setMapper(url)
                .setService(url)
                .setServiceImpl(url)
                .setXml(url)
                .setController(url)
                .setEntityKt(url);
        YueGodTemplateConfiguration yueGodTemplateConfiguration = new YueGodTemplateConfiguration(properties);
        // 执行生成
        mpg.execute(yueGodTemplateConfiguration);
```
只需要传入模板相应的资源地址就可以自定义模板生成，但是文件名有一定约束，约束如下：

```java
/**
 * @author YueGod
 * @date 2020/12/11
 * @description 文件名称常量类
 */
public interface TemplateFileNameConstants {
    String ENTITY_FILE = "/entity.java";
    String ENTITY_KT_FILE = "/entity.kt";
    String SERVICE_FILE = "/service.java";
    String SERVICE_IMPL_FILE = "/serviceImpl.java";
    String MAPPER_FILE = "/mapper.java";
    String XML_FILE = "/mapper.xml";
    String CONTROLLER_FILE = "/controller.java";
}

```
最后文件名后缀以需要使用的模板结尾，例如我使用默认的模板引擎，则需要以

> controller.java.vm

这样的格式来命名模板文件。
