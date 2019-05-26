package org.vincent.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author PengRong
 * @package org.vincent.filter
 * @ClassName TwoFilter.java
 * @date 2019/5/26 - 19:06
 * @ProjectName Web-Tutorial
 * @Description: 通过 org.vincent.config.web.MyWebAppInitializer#getServletFilters() 注册过滤器
 */
public class TwoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("TwoFilter init ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("TwoFilter doFilter ");
        chain.doFilter(request, response);/*不做任何处理，往下流传 */
    }

    @Override
    public void destroy() {
        System.out.println("destory");
    }
}
