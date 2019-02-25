package org.vincent.servlet.include;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PengRong
 * @package org.vincent.servlet.include
 * @date 2019/1/26 - 22:00
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class IncludeServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 返回跟当前request 关联的httpsession ，如果没有现成的，则返回null .
        HttpSession session = req.getSession(false);

        session.isNew();
        session.getCreationTime();
        req.getAttribute("onefilter");
        resp.getContentType();
        /**
         * read Cookie
         */
        req.getRequestURL();
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            String key =cookie.getName();
            String value =cookie.getValue();
            System.out.println("key="+key+",value="+value);
        }
        PrintWriter writer = resp.getWriter();
        writer.write(this.getClass().getSimpleName());
        RequestDispatcher dispatcher = req.getRequestDispatcher("includeservlet2");
        //Cannot forward after response has been committed
        // forward 方法必须在  flush， flushBuffer 方法之前 调用。
        dispatcher.include(req, resp);
        // 刷新流
        writer.flush();
        // 强制 刷新 buffer里面发送给client 的内容
        resp.flushBuffer();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
