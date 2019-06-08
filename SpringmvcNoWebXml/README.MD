[toc]
# 基于Servlet 3.1 + SpringMvc 实现 无 web.xml 文件，基于注解驱动 部署javaWeb 项目
## 项目结构
项目结构是标准的基于Maven的javaweb项目结构
## Pom依赖
```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>Web-Tutorial</artifactId>
        <groupId>org.vincent</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>SpringmvcNoWebXml</artifactId>
    <packaging>war</packaging>

    <name>基于Servlet 3.1 + Springmvc 实现无 web.xml 文件javaweb 项目构建</name>
    <!-- FIXME change it to the project's website -->
    <url>http://www.example.com</url>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- Servlet3.1 begin tomcat8.0.x
        servlet 3.1 JSP 2.3, EL 3.0
        -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>javax.servlet.jsp-api</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.el</groupId>
            <artifactId>javax.el-api</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
        </dependency>
        <!-- Servlet3.1 end -->
        <!-- SpringMVC begin

           引入spring-web和 spring-webmvc 会间接引入：
           spring-jcl
           spring-core
           spring-beans
        -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
        </dependency>
        <!-- SpringMVC stop -->
        <!-- context 导入 会间接引入
            aop 和 expression
        -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
        </dependency>
    </dependencies>

    <build>
        <finalName>SpringmvcNoWebXml</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-clean-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-resources-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
            </plugin>
            <!--  使用 maven-war-plugin 插件 申明如果确实web.xml 文件也不要构建失败，因为这个案例实现没有web.xml 部署构建文件的 javaweb 案例
                该插件如果不配置将报错
              -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.2.2</version>
                <configuration>
                    <!-- <warSourceDirectory>/src/main/webapp</warSourceDirectory>-->
                    <failOnMissingWebXml>false</failOnMissingWebXml> <!-- 申明不要 web.xml 文件， 也可以不配置，默认值是false  -->
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

```

## 创建 Controller 
使用` @Controller ` 注解注释的类承担SpringMVC中控制器角色，SpringMVC中dispatcher Servlet 将自动映射到该类下用 `@RequestMapping`注解注释的方法。
```java
package org.vincent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName HomeController.java
 * @date 2019/5/25 - 12:13
 * @ProjectName Web-Tutorial
 * @Description: 基于SpringMVC 中无 web.xml 文件实现的web项目
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public ModelAndView home() {
        String message = "Hello world from Spring MVC";
        return new ModelAndView("home", "message", message);
    }
}

```
## SpringMVC配置类 
- `@Configuration` 注解定义了注解的类可以通过方法返回Bean定义
- `@EnableWebMvc`注解等同于XML 文件，该注解开启 对于 `@Controller `注解的支持，而`@Controller `注解使用 `@RequestMapping`注解 建立 输入请求和 请求方法之间的映射。
```java
package org.vincent.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author PengRong
 * @package org.vincent.config.web
 * @ClassName WebConfig.java
 * @date 2019/5/25 - 12:08
 * @ProjectName Web-Tutorial
 * @Description: 对应原来的springmvc.xml 配置 文件 的角色,
 * 实现 WebMvcConfigurer 接口 ，所有实现了EnableWebMvc 注解的类 通过实现该接口方法定制 基于 java配置 的 SpringMVC 应用  
 * WebMvcConfigurer 接口只能在实现了  EnableWebMvc 接口的类中使用。
 */
@Configuration
@EnableWebMvc                                //启动SpringMVC
@ComponentScan("org.vincent.controller")            //启动Controller 组件扫描
public class SpringMVCWebConfig implements WebMvcConfigurer {

    /**
     * 配置JSP视图解析器,配置 前缀 和 后缀
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    //配置静态资源的处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();        //对静态资源的请求转发到容器缺省的servlet，而不使用DispatcherServlet
    }

}


```

## 配置  Dispatcher Servlet 
```java
package org.vincent.config.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author PengRong
 * @package org.vincent.config.web
 * @ClassName WebAppInitializer
 * @date 2019/5/25 - 12:05
 * @ProjectName Web-Tutorial
 * @Description: 基于SpringMVC 实现无 web.xml 文件 实现配置javaWeb 项目 ，对应原来的web.xml文件
 *
 */
public class MyWebAppInitializer   extends AbstractAnnotationConfigDispatcherServletInitializer {



    /**
     *  配置根 应用上下文，可以为 null
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { WebRootConfig.class };
    }

    /**
     * 对应 原来在 web.xml中配置 DispatcherServlet 操作
     * 将 Spring MVC java配置类 通过getServletConfigClasses 方法 注册到 Spring mvc 里面
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { SpringMVCWebConfig.class };        //ָ指定Web配置类
    }

    /**
     * 对应原来在web.xml 中配置 DispatcherServlet  Servlet 配置 映射规则。
     * @return
     */
    @Override
    protected String[] getServletMappings() {// 将DispatcherServlet映射到 "/"
        return new String[] { "/" };
    }

    /**
     * 配置 dispatcher  servlet 的servlet名字
     * @return
     */
    @Override
    protected String getServletName() {
        return "springmvc-poc";
    }
}
```

## 设置 Root Application Context (暂时没发现作用)
```java
package org.vincent.config.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author PengRong
 * @package org.vincent.config.web
 * @ClassName RootConfig.java
 * @date 2019/5/25 - 12:08
 * @ProjectName Web-Tutorial
 * @Description: root Application Context，暂时还不知道有什么功能,先注释掉这个类; 在启动时候会根据这个类  创建 WebApplicationContext 实例，并 根据该实例 生成 ContextLoaderListener 监听器实例 
 */
@Configuration
@ComponentScan(basePackages = {"org.vincent"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {EnableWebMvc.class})}
)
public class WebRootConfig {

}

```
## `src/main/webapp/WEB-INF/view` 目录下新建home.jsp文件 当作测试视图
```html
<%--
  Created by IntelliJ IDEA.
  User: PengRong
  Date: 2019/5/25
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br>
<h1>springmvc no web.xml file  </h1>
      <div style='text-align:center;'>
              ${message}
          </div>
</body>
</html>

```
# Java EE 
自从Servlet 3.0 开始 ，WEB-INF/web.xml  文件变成不是必须的配置文件，为了不用web.xml文件 需要做如下两件事
- 写一个类实现 `ServletContainerInitializer` 接口，spring 实现该接口的是：`SpringServletContainerInitializer`  spring-web组件
- 在`META-INF/service/javax.servlet.ServletContainerInitializer` 写上实现 上面接口类的全路径，
有一个问题是：我在Servlet 3.1 版本+ tomcat8.0.53 上面，没有使用springmvc ，基于原生servlet 接口，没有实现上面接口，没有报错，工程可以起来。

# SpringMVC 注解
- @EnableWebMvc 启动SpringMVC,实现 WebMvcConfigurer 接口 ，所有实现了EnableWebMvc 注解的类 通过实现该接口方法定制 SpringMVC 应用配置 
- @EnableAsync
- @EnableScheduling
- @EnableLoadTimeWeaving
- @EnableTransactionManagement

# 增加 slf4就注解 用于创建log

# 参考
[如何用Java类配置Spring MVC(不通过web.xml和XML方式)](https://www.cnblogs.com/chry/p/6239510.html)

[Spring MVC Annotation Example](http://javabycode.com/spring-framework-tutorial/spring-mvc-tutorial/spring-mvc-annotation-example.html)

[Spring @MVC configuration without XML](http://www.rockhoppertech.com/blog/spring-mvc-configuration-without-xml/)