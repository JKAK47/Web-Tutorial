package org.vincent.config.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author PengRong
 * @package org.vincent.config.web
 * @ClassName DispatcherConfig.java
 * @date 2019/6/15 - 15:48
 * @ProjectName Web-Tutorial
 * @Description: 使用默认配置即可
 */
@Slf4j
@Configuration
@EnableWebMvc                                //启动 基于注解驱动 SpringMVC  对标 <mvc:annotation-driven/>
@ComponentScan(basePackages = "org.vincent.controller",/*Controller 扫描的base路径*/  //启动Controller 组件扫描， 只扫描 controller
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, RestController.class})},
        useDefaultFilters = false)  // 对标 <context:component-scan/>
/** 指定扫描的类型*/
public class DispatcherConfig {

}
