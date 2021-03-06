package org.vincent.filter;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PengRong
 * @package org.vincent.filter
 * @ClassName OneFilter.java
 * @date 2019/5/26 - 17:53
 * @ProjectName Web-Tutorial
 * @Description: 基于注解 的filter 案例实现 ,可以手动  通过 WebFilter 注解添加到应用总，也可以在  org.springframework.web.servlet.support.AbstractDispatcherServletInitializer#getServletFilters() 方法中 手动创建添加进去
 */
@WebFilter(description = "web filter impl", displayName = " filter display", filterName = " filter display 2",
        initParams = {@WebInitParam(name = "filter1", value = "12"), @WebInitParam(name = "filter2", value = "ssdf")},
        asyncSupported = true, //异步支持
        urlPatterns = {"/*", "/"},//匹配规则
        dispatcherTypes = {DispatcherType.REQUEST}
)
public class OneFilter implements Filter {
    private FilterConfig filterConfig;
    private ServletContext servletContext;

    /**
     * init 方法由web容器调用，在Filter 实例化成功后调用一次；在filter 执行任何过滤逻辑前这个方法必须执行成功。
     * 容器通过FilterConfig向Filter传递Filter配置参数； 可以获取这个Filter 的name，以及初始化参数 InitParameter
     * 和 ServletContext 实例，用于加载资源。
     *
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        servletContext = filterConfig.getServletContext();
        servletContext.log("SimpleClassName: " + this.getClass().getSimpleName() + "\t" + "oneFilter init");
        servletContext.log("filter1 = " + filterConfig.getInitParameter("filter1") + ", filter2 = " + filterConfig.getInitParameter("filter2"));
    }

    /**
     * 在doFilter 方法中 执行具体的拦截事宜，该方法被容器调用
     * <p>一旦一个请求到达web 应用程序，被该filter 拦截；在doFilter方法中可以检查请求url,请求参数，请求头等参数是否合规，然后根据检查结果</p>
     * 决定是否需要拦截或者转发请求给目标 Servlet，JSP等
     *
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        System.out.println("SimpleClassName: " + this.getClass().getSimpleName() + "\tRequestURI: " + httpServletRequest.getRequestURI());
        System.out.println("SimpleClassName: " + this.getClass().getSimpleName() + "\tRequestURL: " + httpServletRequest.getRequestURL().toString());

        response.setContentType("text/plain;charset=UTF-8");
        /**
         * 检查request 的 url 查询参数myParam是否是  blockTheRequest，
         * 如果不是 通过 chain.doFilter 方法将 request 转发到目标 servlet,
         * 如果是 不执行 chain.doFilter 方法，将拦截request请求，request只能到这个请求这里
         */

        String myParam = request.getParameter("myParam");
        if (!"blockTheRequest".equals(myParam)) {
            servletContext.log("SimpleClassName: " + this.getClass().getSimpleName() + " filterName: " + this.filterConfig.getFilterName());
            /** 触发filter 链上的下一个filter 被调用  */
            chain.doFilter(request, response);

        } else {
            /* 不通过 chain.doFilter 转发 ，拦截请求 */
            PrintWriter printWriter = response.getWriter();
            //获取当前的字符编码
            String CurCharacterEncoding = response.getCharacterEncoding();
            //指定返回的字符串字符编码
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/plain;charset=UTF-8");
            printWriter.write("你被拦截了,myParam = " + myParam);
            printWriter.flush();
            response.flushBuffer();
        }

    }

    /**
     * 销毁filter 进行扫尾工作
     */
    @Override
    public void destroy() {
        System.out.println("OneFilter destroy ");
    }
}

