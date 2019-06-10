package org.vincent.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * @author PengRong
 * @package org.vincent.config.web
 * @ClassName MyViewConfig.java
 * @date 2019/6/10 - 23:09
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@Configuration
@EnableWebMvc
public class MyViewConfig {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
