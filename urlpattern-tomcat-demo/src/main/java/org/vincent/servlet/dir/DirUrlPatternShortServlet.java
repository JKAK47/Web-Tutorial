package org.vincent.servlet.dir;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PengRong
 * @package org.vincent.servlet.dir
 * @date 2019/2/28 - 1:16
 * @ProjectName Web-Tutorial
 * @Description: 路径匹配 长路径匹配
 * 匹配 URL
 * http://localhost:8888/urlpattern/vincent/dir/v1/asdf.do ( 长路径匹配模式 /vincent/dir/v1/* 比 短路径匹配模式 /vincent/dir/* ,该URL 能匹配到长路径匹配模式，将优先匹配到路径模式中长路径模式)
 * http://localhost:8888/urlpattern/vincent/dir/v12/asdf.do 如果只有长路径匹配，将不匹配路径匹配，只匹配扩展名匹配，所以通过扩展匹配Servlet处理
 * http://localhost:8888/urlpattern/vincent/dir/v12/asdf.do 但是一旦加了短路径匹配后，将匹配路径匹配，不匹配扩展名匹配
 */
public class DirUrlPatternShortServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        String uri = req.getRequestURI();
        req.getRequestURL( );
        PrintWriter writer = resp.getWriter();
        writer.println("process Servlet: " + this.getClass().getSimpleName());
        writer.println("DirUrlPatternShortServlet requestUri : " + uri );
        writer.println("ServletPath : " + req.getServletPath());
        writer.println("contextPath : " + req.getContextPath());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
