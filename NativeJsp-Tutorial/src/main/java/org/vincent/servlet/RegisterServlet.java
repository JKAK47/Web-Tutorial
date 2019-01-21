package org.vincent.servlet;

import org.vincent.dao.model.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author PengRong
 * @package org.vincent.servlet
 * @date 2019/1/21 - 7:53
 * @ProjectName Web-Tutorial
 * @Description: 这个servlet 接受 login.jsp 页面的请求 ，组织login.jsp提交的数据，并转发 在 font/userlist.jsp 输出。
 */
public class RegisterServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getSession().getId();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String account = req.getParameter("account");
        String name =req.getParameter("name");
        String gender = req.getParameter("gender");
        String[] interest =req.getParameterValues("interest");
        String msg =req.getParameter("msg");

        UserBean userBean = new UserBean();
        userBean.setAccount(account);
        userBean.setName(name);
        userBean.setGender(gender);
        userBean.setInterest(interest);
        userBean.setMsg(msg);


        req.setAttribute("USERLIST", userBean);
        req.getRequestDispatcher("font/userlist.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
