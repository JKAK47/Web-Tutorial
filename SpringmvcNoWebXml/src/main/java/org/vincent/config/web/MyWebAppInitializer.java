package org.vincent.config.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author PengRong
 * @package org.vincent.config.web
 * @ClassName MyWebAppInitializer.java
 * @date 2019/5/25 - 12:05
 * @ProjectName Web-Tutorial
 * @Description: 基于SpringMVC 实现无 web.xml 实现配置javaWeb 项目
 */
public class MyWebAppInitializer   extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     *  类似于原来java web项目中必须的web.xml 文件 配置
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    /**
     * 类似于原来在 web.xml中配置的 DispatcherServlet
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };        //ָ指定Web配置类
    }

    @Override
    protected String[] getServletMappings() {// 将DispatcherServlet映射到 "/"
        return new String[] { "/" };
    }
}
