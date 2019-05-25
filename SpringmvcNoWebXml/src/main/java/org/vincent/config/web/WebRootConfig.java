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
 * @Description: 对应原来的web.xml 文件
 */
@Configuration
@ComponentScan( basePackages={"org.vincent"},
        excludeFilters = { @ComponentScan.Filter(type= FilterType.ANNOTATION,value=EnableWebMvc.class)}
)
public class WebRootConfig {

}
