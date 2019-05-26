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
