package org.vincent.servlet.forward;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PengRong
 * @package org.vincent.servlet.forward
 * @date 2019/1/26 - 21:46
 * @ProjectName Web-Tutorial
 * @Description: 用于测试forward 方法 转发 最终页面是否有第一个servlet输出的结果
 */
public class ForwardServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        HttpSession session =req.getSession();
        session.setAttribute("foo", "sdfqwese");
        String FOO ="";
        // 失效 session 后 再次获取属性报错： java.lang.IllegalStateException: getAttribute: Session already invalidated
        //session.invalidate();
        //FOO = (String) session.getAttribute("foo");
        writer.write(this.getClass().getSimpleName()+FOO);
        //writer.flush();
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doGet(req, resp);
    }
}
