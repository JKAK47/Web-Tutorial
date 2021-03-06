package org.vincent.servlet.tutorial;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author PengRong
 * @package org.vincent.servlet.tutorial
 * @date 2019/3/7 - 0:06
 * @ProjectName Web-Tutorial
 * @Description: Session 案例
 * <p>
 * 使用request对象的getSession()获取session，如果session不存在则创建一个,
 * 如果浏览器存储 cookie 数据，意味着服务器传递给浏览器的cookie 都丢失了，再次请求并不会返回给服务器。
 * 所以sessionId也即丢失了，所以第二次请求过来服务器不认识客户端是第二次请求了。
 * request.getSession(); 每次都是返回一个新的session。
 */
@WebServlet(
        name = "SessionServlet",
        urlPatterns = {"/sessionServlet"}
)
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getClass().getClassLoader().getResource("").toString();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        //将数据存储到session中
        session.setAttribute("data", "孤傲苍狼");
        //获取session的Id
        String sessionId = session.getId();
        //判断session是不是新创建的
        if (session.isNew()) {
            response.getWriter().print("session创建成功，session的id是：" + sessionId);
            Cookie ShareCookie =new Cookie("ShareCookie","ShareCookie-value");
            //ShareCookie.setDomain(request);
            ShareCookie.setMaxAge(70);
            ShareCookie.setPath("/");
            ShareCookie.setDomain(request.getServerName());
            ShareCookie.setComment("vincent-comment");
            response.addCookie(ShareCookie);
        } else {
            response.getWriter().print("服务器已经存在该session了，session的id是：" + sessionId);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
