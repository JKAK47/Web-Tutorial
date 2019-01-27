package org.vincent.servlet.forward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PengRong
 * @package org.vincent.servlet.forward
 * @date 2019/1/26 - 21:46
 * @ProjectName Web-Tutorial
 * @Description: 用于测试forward 方法 转发 最终页面是否有第一个servlet输出的结果
 */
public class ForwardServlet2  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
