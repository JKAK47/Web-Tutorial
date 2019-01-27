package org.vincent.filter.gzip;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
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
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Enumeration<String> enumerations = filterConfig.getInitParameterNames();
        while (enumerations.hasMoreElements()) {
            String key = enumerations.nextElement();
            String value = filterConfig.getInitParameter(key);
            System.out.println("key = "+key+", value = "+value);
        }
    }

    /**
     * 检查这个请求是否接受 响应内容通过gzip 压缩减少体积
     * @param httpRequest 请求参数
     * @return true 接受，false 不接受
     */
    private boolean acceptsGZipEncoding(HttpServletRequest httpRequest) {
        String acceptEncoding = httpRequest.getHeader("Accept-Encoding");
        return acceptEncoding != null && acceptEncoding.trim().indexOf("gzip") != -1;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        System.out.println("SimpleClassName: "+this.getClass().getSimpleName()+"\tRequestURI: "+httpRequest.getRequestURI());
        System.out.println("SimpleClassName: "+this.getClass().getSimpleName()+"\tRequestURL: "+httpRequest.getRequestURL().toString());
        if (acceptsGZipEncoding(httpRequest)) {
            /** 接受就可以对文本内容压缩*/
            /* 第一步 设置响应头表示对文本使用了gzip 压缩*/
            httpResponse.addHeader("Content-Encoding", "gzip");
            /* 第二步 将 HttpServletResponse 响应类 使用包装器 包装到 GZipServletResponseWrapper 类，增加功能，并重写 getOutputStream，getWriter 两个方法 将
             * Gzip 功能添加进去 */
            GZipServletResponseWrapper gzipResponse = new GZipServletResponseWrapper(httpResponse);
            /* 转发到  请求的servlet 进行真正的业务处理  */
            chain.doFilter(request, gzipResponse);
            /* 处理完后关闭 输出流 */
            gzipResponse.close();
        } else {
            /* 浏览器不接受 对文本压缩就 直接跳过，直接转发给Servlet */
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        System.out.println(this.getClass().getSimpleName() +" is destroy. ");
    }
}
