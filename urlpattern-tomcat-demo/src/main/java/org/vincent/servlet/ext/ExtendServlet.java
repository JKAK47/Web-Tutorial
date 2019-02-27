package org.vincent.servlet.ext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PengRong
 * @package org.vincent.servlet.ext
 * @date 2019/2/28 - 0:53
 * @ProjectName Web-Tutorial
 * @Description: 处理扩展URL 请求的 Servlet, 所有url 以 .do 结尾的资源访问通过这个访问
 * http://localhost:8888/urlpattern/vincent/asdf/werwqe/ex11act.do
 * http://localhost:8888/urlpattern/vincent/ex11act.do
 * http://localhost:8888/urlpattern/vincent/werwqe/ex11act.do
 */
public class ExtendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        String uri = req.getRequestURI();
        req.getRequestURL();
        PrintWriter writer = resp.getWriter();
        writer.println("process Servlet: " + this.getClass().getSimpleName());
        writer.println("ExtendServlet requestUri : " + uri);// 包括 ContxtName/ServletPath :  上下文名称/Servlet url
        writer.println("ServletPath : " + req.getServletPath());
        writer.println("contextPath : " + req.getContextPath());
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
