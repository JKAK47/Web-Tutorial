package org.vincent.config.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.vincent.filter.OneFilter;
import org.vincent.filter.TwoFilter;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PengRong
 * @package org.vincent.config.web
 * @ClassName MyWebAppInitializer.java
 * @date 2019/5/25 - 12:05
 * @ProjectName Web-Tutorial
 * @Description: 基于SpringMVC 实现无 web.xml 文件 实现配置javaWeb 项目 ，对应原来的web.xml文件
 *
 */
public class MyWebAppInitializer   extends AbstractAnnotationConfigDispatcherServletInitializer {



    /**
     *  配置根 应用上下文，可以返回 null
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        //return new Class<?>[] { WebRootConfig.class };
        return null;
    }

    /**
     * 对应 原来在 web.xml中配置 DispatcherServlet 操作
     * 将 Spring MVC DispatcherServlet 类配置以  java配置类形式 通过getServletConfigClasses 方法 注册到 Spring mvc 里面
     * DispatcherServlet 是所有Springmvc 应用的进入点，该类的功能是拦截所有Http 请求，并分发给正确组件处理该请求。
     *在Spring 3.1 之前，配置 DispatcherServlet 必须在WEB-INF/web.xml 中进行配置，
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

    /**
     * 增加 过滤器映射到 DispatcherServlet
     * */
    @Override
    protected Filter[] getServletFilters() {
        List<Filter> filters =new ArrayList<>();
        filters.add(new TwoFilter());
        return filters.toArray(new Filter[0]);
    }
}
