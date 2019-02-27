package org.vincent.servlet;

import org.vincent.listener.MyHttpSessionActivationListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by S0076 on 2019/2/25.
 * HttpSessionActivationListener 监听器测试类，session 空闲 1分钟 即会失效session。然后将session持久化到硬盘，第二次访问，session从硬盘中反序列化出来
 * 基于注解注册Servlet
 *
 */
@WebServlet(
        name = "SessionActivationListenerTestServlet" ,
        urlPatterns = {"/SessionActivationTest"},
        initParams = {
                @WebInitParam(name = "SessionActivationListenerTestServlet-1",value ="SessionActivationListenerTestServlet-1-value" ),
                @WebInitParam(name = "SessionActivationListenerTestServlet-2",value ="SessionActivationListenerTestServlet-2-value" ),
                @WebInitParam(name = "SessionActivationListenerTestServlet-3",value ="SessionActivationListenerTestServlet-3-value" )
        },
        loadOnStartup = 0
)
public class HttpSessionActivationListenerTestServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("a", new MyHttpSessionActivationListener("MyHttpSessionActivationListener-pr"));
        PrintWriter writer = resp.getWriter();
        writer.println("this is from org.vincent.servlet.HttpSessionActivationListenerTestServlet");
        writer.println("this is from org.vincent.listener.MyHttpSessionActivationListener");
        writer.println(getServletConfig().getInitParameter("SessionActivationListenerTestServlet-1"));
        writer.println(getServletConfig().getInitParameter("SessionActivationListenerTestServlet-2"));
        writer.println(getServletConfig().getInitParameter("SessionActivationListenerTestServlet-3"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
