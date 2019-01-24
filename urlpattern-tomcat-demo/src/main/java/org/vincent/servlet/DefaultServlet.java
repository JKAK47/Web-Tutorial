package org.vincent.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author PengRong
 * @package org.vincent.servlet
 * @date 2019/1/24 - 18:34
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class DefaultServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("this", this.getClass().getSimpleName());
        /* 应用上下玩*/
        req.setAttribute("contextPath", req.getContextPath());
        /* 匹配到这个 Servlet 的url 中 去除ip:port/Context 部分后URL 剩下的部分
         * 比如 ：http://localhost:8888/urlpattern/exact.do
         * contextPath:  /urlpattern
         * servletPath: /exact.do
         * */
        req.setAttribute("servletPath", req.getServletPath());
        req.getRequestDispatcher("/WEB-INF/pages/info.jsp").forward(req, resp);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
