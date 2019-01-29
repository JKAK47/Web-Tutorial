package org.vincent.filter.gzip;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @author PengRong
 * @package org.vincent.filter.gzip
 * @date 2019/1/27 - 11:17
 * @ProjectName Web-Tutorial
 * @Description: 实现对浏览器支持 对文本内容进行 gzip 压缩格式的浏览器服务端拦截，并将他的输出
 */
public class GZipServletFilter implements Filter {
    private FilterConfig filterConfig;
    private ServletContext servletContext;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.servletContext = filterConfig.getServletContext();
        filterConfig.getServletContext().log("simpleClass: " + this.getClass().getSimpleName());
        Enumeration<String> enumerations = filterConfig.getInitParameterNames();
        while (enumerations != null && enumerations.hasMoreElements()) {
            String key = enumerations.nextElement();
            String value = filterConfig.getInitParameter(key);
            System.out.println("key = " + key + ", value = " + value);
        }
        servletContext.log(filterConfig.getFilterName() + " initialized.");
    }

    /**
     * 检查这个请求是否接受 响应内容通过gzip 压缩减少体积
     *
     * @param httpRequest 请求参数
     * @return true 接受，false 不接受
     */
    private boolean acceptsGZipEncoding(HttpServletRequest httpRequest) {
        String acceptEncoding = httpRequest.getHeader("Accept-Encoding");
        return acceptEncoding != null && acceptEncoding.trim().indexOf("gzip") != -1;
    }

    /**
     * filter.doFilter方法是 过滤器 被servlet容器回调的接口方法
     *
     * @param request  请求参数
     * @param response 响应参数
     * @param chain    过滤器链
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletContext servletContext = request.getServletContext();
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        System.out.println("SimpleClassName: " + this.getClass().getSimpleName() + "\tRequestURI: " + httpRequest.getRequestURI());
        System.out.println("SimpleClassName: " + this.getClass().getSimpleName() + "\tRequestURL: " + httpRequest.getRequestURL().toString());
        if (acceptsGZipEncoding(httpRequest)) {
            /** 接受就可以对文本内容压缩*/
            /* 第一步 设置响应头表示对文本使用了gzip 压缩*/
            httpResponse.addHeader("Content-Encoding", "gzip");
            /* 第二步 将 HttpServletResponse 响应类 使用包装器 包装到 GZipServletResponseWrapper 类，增加功能，并重写 getOutputStream，getWriter 两个方法 将
             * Gzip 功能添加进去 */
            GZipServletResponseWrapper gzipResponse = new GZipServletResponseWrapper(httpResponse);
            /*FilterChain.doFilter接口 存在的意义是调用 那个filter.doFilter方法 或者 链尾的 Servlet 转发到  请求的servlet 进行真正的业务处理  */
            chain.doFilter(request, gzipResponse);
            gzipResponse.flushBuffer();
            /* 处理完后关闭 输出流 */
            gzipResponse.close();
            servletContext.log(filterConfig.getFilterName() + " finished the request.");
        } else {
            servletContext.log(filterConfig.getFilterName() + " no encoding performed.");
            /* 浏览器不接受 对文本压缩就 直接跳过，直接转发给Servlet */
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        filterConfig = null;
        servletContext = null;
        servletContext.log(this.getClass().getSimpleName() + " is destroy. ");
    }
}
