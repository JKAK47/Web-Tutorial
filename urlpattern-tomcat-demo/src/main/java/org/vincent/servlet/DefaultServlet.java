package org.vincent.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * @author PengRong
 * @package org.vincent.servlet
 * @date 2019/1/24 - 18:34
 * @ProjectName Web-Tutorial
 * @Description: Servlet 处理所有请求不能匹配的URL,通通到这里来 Servlet 默认匹配，除了 精确匹配，路径匹配，扩展名匹配
 */
public class DefaultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
/**
 * read Cookie
 */
        Cookie[] cookies = req.getCookies(); // getCookies() 方法可能返回null ，获取客户端提交的所有 Cookie
        /**
         * key=JSESSIONID,value=E32CF424EC6CF65263A89C9DAB501472
         */
        if (Objects.nonNull(cookies)) {
            for (Cookie cookie : cookies) {
                String key = cookie.getName();
                String value = cookie.getValue();
                System.out.println("key=" + key + ",value=" + value);
            }
        }
        resp.setContentType("text/plain;charset=UTF-8");
        String uri = req.getRequestURI();
        PrintWriter writer = resp.getWriter();
        writer.println("process Servlet: " + this.getClass().getSimpleName());
        writer.println("DefaultServlet requestUrL : " + req.getRequestURL());
        writer.println("DefaultServlet requestUri : " + uri);

        /* 模拟servlet 抛出异常了，然后页面返回 error-page 设定的  throwable.jsp 页面
         * 下面代码段会造成抛出异常
         * */
       /* if (1 > 0) {
            throw new IOException("ASLDFASD");
        }*/

        writer.println("ServletPath : " + req.getServletPath());
        writer.println("contextPath : " + req.getContextPath());
        writer.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
