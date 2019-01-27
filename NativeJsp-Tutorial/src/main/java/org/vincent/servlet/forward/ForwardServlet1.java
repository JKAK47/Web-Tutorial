package org.vincent.servlet.forward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PengRong
 * @package org.vincent.servlet.forward
 * @date 2019/1/26 - 21:44
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class ForwardServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * set Cookie
         */
        Cookie cookie = new Cookie("myCookie", "myCookieValue");
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);

        resp.addCookie(new Cookie("key","vincent"));

        PrintWriter writer = resp.getWriter();
        writer.write(this.getClass().getSimpleName());
        RequestDispatcher dispatcher = req.getRequestDispatcher("forwardservlet2");
        //Cannot forward after response has been committed
        // forward 方法必须在  flush， flushBuffer 方法之前 调用。
        dispatcher.forward(req, resp);
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
