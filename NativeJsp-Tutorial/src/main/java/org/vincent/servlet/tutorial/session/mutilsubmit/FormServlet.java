package org.vincent.servlet.tutorial.session.mutilsubmit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author PengRong
 * @package org.vincent.servlet.tutorial.session.mutilsubmit
 * @date 2019/3/7 - 8:00
 * @ProjectName Web-Tutorial
 * @Description: 通过 session 达到防止表单多次提交目的，
 */
@WebServlet(
        name = "FormServlet",
        urlPatterns = {"/FormServlet"}
)
public class FormServlet extends HttpServlet {
    /**
     * 用于生成Token(令牌)和跳转到form.jsp页面
     * 为什么获取一个jsp页面还需要一个FormServlet 来实现访问？
     * 主要是给 jsp 中隐藏域 赋值一个令牌 Token 。
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = TokenProccessor.getInstance().makeToken();//创建令牌
        System.out.println("在FormServlet中生成的token：" + token);
        request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
        request.getRequestDispatcher("/WEB-INF/session/form.jsp").forward(request, response);//跳转到form.jsp页面
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
