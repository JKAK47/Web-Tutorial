package org.vincent.config.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.vincent.TradeService;
import org.vincent.converter.TradeIdToTradeConverter;

/**
 * @author PengRong
 * @package org.vincent.config.web
 * @ClassName SpringMVCWebConfig.java
 * @date 2019/6/10 - 23:11
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.vincent.controller",/*Controller 扫描的base路径*/  //启动Controller 组件扫描， 只扫描 controller
        includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class, RestController.class})},
        useDefaultFilters = false)
@Import(value = {MyViewConfig.class}) /**导入其他配置 类似于原来xml 文件中import 元素 */
public class SpringMVCWebConfig implements WebMvcConfigurer {
    @Bean
    public TradeService tradeService(){
        return new TradeService();
    }


    @Override
    public void addFormatters (FormatterRegistry registry) {
        registry.addConverter(new TradeIdToTradeConverter(tradeService()));
    }
}
