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
 * @date 2019/1/24 - 18:02
 * @ProjectName Web-Tutorial
 * @Description: 精确匹配 http://localhost:8888/urlpattern/vincent/exact.do Url必须是这个
 */
public class ExactServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/plain;charset=UTF-8");
        String uri = req.getRequestURI();
        req.getRequestURL();
        PrintWriter writer = resp.getWriter();
        writer.println("process Servlet: " + this.getClass().getSimpleName());
        writer.println("requestUri : " + uri);
        writer.println("ServletPath : " + req.getServletPath());
        writer.println("contextPath : " + req.getContextPath());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
