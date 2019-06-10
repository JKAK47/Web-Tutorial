package org.vincent.config.web;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.vincent.filter.TwoFilter;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PengRong
 * @package org.vincent.config.web
 * @ClassName WebAppInitializer.java
 * @date 2019/5/25 - 12:05
 * @ProjectName Web-Tutorial
 * @Description: 基于SpringMVC 实现无 web.xml 文件 实现配置javaWeb 项目 ， 是Spring 下 javaWeb 项目启动配置 ，可以配置 Root Application， ServletFilter， ServletMapping
 *  该类实现web.xml 文件功能 ，最终实现 WebApplicationInitializer 接口，该接口 是Spring提供用来配置Servlet3.0+配置的接口 ；实现此接口将会自动被SpringServletContainerInitializer获取到，SpringServletContainerInitializer用来启动Servlet3.0容器。所以他不用注解
 *
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        /** 可以省略 这句*/
        //servletContext.setInitParameter("logbackConfigLocation", "classpath:logback.xml");
    }

    /**
     *  配置根 应用上下文，可以返回 null
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { WebRootConfig.class };
       // return null;
    }

    /**
     * 对应 原来在 web.xml中配置 DispatcherServlet 操作
     * 将 Spring MVC DispatcherServlet 类配置以  java配置类形式 通过getServletConfigClasses 方法 注册到 Spring mvc 里面
     * DispatcherServlet 是所有Springmvc 应用的进入点，该类的功能是拦截所有Http 请求，并分发给正确组件处理该请求。
     *在Spring 3.1 之前，配置 DispatcherServlet 必须在WEB-INF/web.xml 中进行配置，
     * @return
     * org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer.getServletConfigClasses()
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
     * 增加 过滤器映射到 DispatcherServlet，
     * 这种方式对于jar 包实现的 filter 有很好的兼容性，可以通过手动注册上去。
     * */
    @Override
    protected Filter[] getServletFilters() {
        List<Filter> filters =new ArrayList<>();
        filters.add(new TwoFilter());
        /** 设置字符集 编码 UTF-8 */
        CharacterEncodingFilter filter = new CharacterEncodingFilter("UTF-8",true);
        filters.add(filter);
        return filters.toArray(new Filter[0]);
    }
}
