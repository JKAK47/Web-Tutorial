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
 * @Description: root Application Context，暂时还不知道有什么功能,先注释掉这个类; 在启动时候会根据这个类  创建 Root WebApplicationContext 实例，
 * 并 根据该实例 生成 ContextLoaderListener 监听器实例
 */
@Configuration
@ComponentScan(basePackages = {"org.vincent"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {EnableWebMvc.class})}
)
public class WebRootConfig {

}
