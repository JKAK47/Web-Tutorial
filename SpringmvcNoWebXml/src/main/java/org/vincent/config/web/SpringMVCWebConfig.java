package org.vincent.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Arrays;

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
@ComponentScan("org.vincent.controller")            //启动Controller 组件扫描， 只扫描 controller
public class SpringMVCWebConfig implements WebMvcConfigurer {

    /**
     * 配置JSP视图解析器,配置 前缀 和 后缀
     *
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


    /**
     * 解决springmvc 请求接受 json字符串 不支持问题
     * Resolved [org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/json;charset=UTF-8' not supported]
     * <p>
     * 从Http 协议字符串转成 JavaBean 使用的转换器；注解@ResponseBody的时候去配置 HttpMessageConverter ,同个这个bean 将根据Content-Type 属性 解析成对应的JavaBean;
     * json转化器，它可以将结果转化从JavaBean 转为JSON 字符串 ,用于处理响应结果返回json字符串时候使用
     */
    @Bean(name = "httpMessageConverter")
    public HttpMessageConverter httpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(
                new MediaType[]{MediaType.valueOf(MediaType.APPLICATION_JSON_UTF8_VALUE),
                        MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE),
                        MediaType.valueOf(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8")
                }
        ));

        return mappingJackson2HttpMessageConverter;
    }

    /**
     * 注入上面定义的 messageConverter Bean
     *
     * @param httpMessageConverter
     * @return
     */
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(HttpMessageConverter httpMessageConverter) {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        requestMappingHandlerAdapter.setMessageConverters(Arrays.asList(
                httpMessageConverter
        ));
        return requestMappingHandlerAdapter;
    }


    //配置静态资源的处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();        //对静态资源的请求转发到容器缺省的servlet，而不使用DispatcherServlet
    }

    /**
     * 对静态资源  images, js, and, css 指定在哪里找
     * 可以指定多个
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**", "/js/**", "/css/**")
                .addResourceLocations("/static/", "/js/", "/css/")/** 在 webapp/static/目录下寻找 */

        ;

    }

}
