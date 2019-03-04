package org.vincent.servlet.include;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PengRong
 * @package org.vincent.servlet.include
 * @date 2019/1/26 - 22:00
 * @ProjectName Web-Tutorial
 * @Description: 派发器案例 Include方法，组合两个servlet 的结果为一个响应。 实际中很少使用include方法
 */
public class IncludeServlet2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        PrintWriter writer=resp.getWriter();
        writer.write(this.getClass().getSimpleName());
        writer.flush();
        resp.flushBuffer();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
