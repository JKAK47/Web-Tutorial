package org.vincent.config.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
@Slf4j
@Configuration
@EnableWebMvc                                //启动 基于注解驱动 SpringMVC  对标 <mvc:annotation-driven/>
@ComponentScan(basePackages = "org.vincent.controller",/*Controller 扫描的base路径*/  //启动Controller 组件扫描， 只扫描 controller
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, RestController.class})},
        useDefaultFilters = false)  // 对标 <context:component-scan/>
/** 指定扫描的类型*/
public class SpringMVCWebConfig implements WebMvcConfigurer {

    /**
     * 第一步： 创建基于注解映射处理器，根据请求查找 映射的Controller 类
     * 创建一个基于注解的 映射处理器  RequestMappingHandlerMapping, 基于注解的Controller，
     * 对请求url 和请求 Handler ( 就是 Controller，RestController ) 实例之间建立映射关系
     *
     * @return
     */
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        return new RequestMappingHandlerMapping();
    }


    /**
     * 控制器中使用@ ResponseBody 或@ RequestBody,spring MVC就会自动帮我们 做“java对象<--->对应格式数据”的转换，用到的就是message converter。
     * <p>
     * 解决springmvc 请求接受 json字符串 不支持问题
     * Resolved [org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/json;charset=UTF-8' not supported]
     * <p>
     * 从Http 协议字符串转成 JavaBean 使用的转换器；注解@ResponseBody的时候去配置 HttpMessageConverter ,同个这个bean 将根据Content-Type 属性 解析成对应的JavaBean;
     * json转化器，它可以将结果转化从 JavaBean 转为JSON 字符串 ,用于处理响应结果返回json字符串时候使用。
     * MappingJackson2HttpMessageConverter 是SpringMvc 提供的处理JSON格式数据请求和响应消息的 HttpMessageConverter 类 实现
     */
    @Bean(name = "httpMessageConverter")
    public HttpMessageConverter httpMessageConverter() {
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(
                MediaType.valueOf(MediaType.APPLICATION_JSON_UTF8_VALUE),
                MediaType.valueOf(MediaType.APPLICATION_JSON_VALUE),
                MediaType.valueOf(MediaType.TEXT_HTML_VALUE + ";charset=UTF-8")

        ));
        mappingJackson2HttpMessageConverter.setDefaultCharset(Charset.forName("UTF-8"));
        return mappingJackson2HttpMessageConverter;
    }

    /**
     * * 第二步： 创建基于注解处理器适配器
     * 配置基于注解的 处理器适配器, 完成对@RequestMapping 注解方法的调用
     * 注入上面定义的 messageConverter Bean； 实现 JavaBean 和 Json 结构体的转换
     *
     * @param httpMessageConverter
     * @return
     */
    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(HttpMessageConverter httpMessageConverter) {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        List<HttpMessageConverter<?>> messageConverters = requestMappingHandlerAdapter.getMessageConverters();
        messageConverters.add(httpMessageConverter);
        /** 通过反射给指定属性赋值；设置字符串 字符串字符集 defaultCharset = UTF-8 */
        messageConverters.parallelStream().forEach(e -> {
            Class<?> aClass = e.getClass();
            for (; aClass != Object.class; aClass = aClass.getSuperclass()) {
                //Field defaultCharset = e.getClass().getDeclaredField("defaultCharset");// 该方法只是获取本类的属性值,父类属性获取不到； getDeclaredFields 方法也是只能获取本类属性
                Field[] fields = aClass.getDeclaredFields();
                for (Field field : fields) {
                    int mod = field.getModifiers();
                    if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                        continue;/** 对应不可修改的字段就不用在修改了 */
                    }
                    String fieldName = field.getName();
                    if (Objects.nonNull(fieldName) && fieldName.equals("defaultCharset")) {
                        try {
                            field.setAccessible(true);
                            field.set(e, Charset.forName("UTF-8"));/** 设置元素 e 属性 */
                        } catch (IllegalAccessException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        });
        requestMappingHandlerAdapter.setMessageConverters(messageConverters);
        return requestMappingHandlerAdapter;
    }


    //配置静态资源的处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();        //开启转发到默认Servlet， 对静态资源的请求转发到容器缺省的servlet，而不使用DispatcherServlet
        //configurer.enable("defaultServletName"); // 指定默认Servlet 名字
    }

    /**
     * 第三步： 创建视图处理器
     * 配置JSP视图解析器,配置 前缀 和 后缀
     *
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        log.info("viewResolver ");
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * 对静态资源  images, js, and, css 指定在哪里找资源
     * 可以指定多个，
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        ResourceHandlerRegistration resourceHandlerRegistration = registry.addResourceHandler("/static/**", "/js/**", "/css/**");
        resourceHandlerRegistration.addResourceLocations("/static/", "/js/", "/css/");/** 在 webapp/static/目录下寻找 */
    }

    /**
     * 加一个日期格式转换器,全局加转换器没有用 不生效
     * */

    /*@Bean
    public CustomDateConverter dateFormatBean(){
        *//*ConversionServiceFactoryBean formattingConversionServiceFactoryBean =new   ConversionServiceFactoryBean();
        HashSet<CustomDateConverter> hashSet =new HashSet<>();
        CustomDateConverter customDateConverter =new CustomDateConverter();
        customDateConverter.setDateParttern("yyyy-MM-dd");
        hashSet.add(customDateConverter);
        formattingConversionServiceFactoryBean.setConverters(hashSet);
        return formattingConversionServiceFactoryBean;*//*
        CustomDateConverter customDateConverter =new CustomDateConverter();
        customDateConverter.setDateParttern("yyyy-MM-dd");
        return customDateConverter;
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        //registry.addConverter(dateFormatBean());
        registry.addFormatter(dateFormatBean());
    }*/


    /**
     * SpringMVC 国际化相关配置 开始
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames("language/message");/** 指定国际化文件 ： 说明该文件在src/main/resources/language/目录下的message 文件 */
        return source;
    }

    /**
     * 国际化操作拦截器 如果基于 Session/Cookie 设置 则必须设置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor());
    }

    /**
     * 默认的语言区域解析器设置 可以忽略
     *
     * @return
     */
    @Bean
    public AcceptHeaderLocaleResolver acceptHeaderLocaleResolver() {
        return new AcceptHeaderLocaleResolver();
    }
    /**
     * SpringMVC 国际化相关配置 结束
     */
}
