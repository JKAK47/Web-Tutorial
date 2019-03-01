package org.vincent.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PengRong
 * @package org.vincent.servlet
 * @date 2019/1/24 - 18:34
 * @ProjectName Web-Tutorial
 * @Description: Servlet 处理所有请求不能匹配的URL,通通到这里来 Servlet 默认匹配，除了 精确匹配，路径匹配，扩展名匹配
 */
public class DefaultServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {


        resp.setContentType("text/plain;charset=UTF-8");
        String uri = req.getRequestURI();
        PrintWriter writer = resp.getWriter();
        writer.println("process Servlet: " + this.getClass().getSimpleName());
        writer.println("DefaultServlet requestUrL : " +  req.getRequestURL());
        writer.println("DefaultServlet requestUri : " + uri );

        /* 模拟servlet 抛出异常了，然后页面返回 error-page 设定的  throwable.jsp 页面 */
        if ( 1 > 0 ){
            throw  new  IOException("ASLDFASD");
        }

        writer.println("ServletPath : " + req.getServletPath());
        writer.println("contextPath : " + req.getContextPath());
        writer.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        doGet(req, resp);
    }
}
