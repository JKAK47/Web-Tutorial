package org.vincent.servlet.tutorial.session;

import org.vincent.servlet.tutorial.session.bean.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PengRong
 * @package org.vincent.servlet.tutorial.session
 * @date 2019/3/7 - 0:45
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@WebServlet(
        name = "BuyServlet",
        urlPatterns = {"/BuyServlet"}
)
public class BuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 请求参数 id */
        String id = request.getParameter("id");
        Book book = DB.getAll().get(id);  //得到用户想买的书
        HttpSession session = request.getSession();
        List<Book> list = (List) session.getAttribute("list");  //得到用户用于保存所有书的容器
        if (list == null) {
            list = new ArrayList<Book>();
            session.setAttribute("list", list);
        }
        list.add(book);
        //response. encodeRedirectURL(java.lang.String url)用于对sendRedirect方法后的url地址进行重写
        String url = response.encodeRedirectURL(request.getContextPath() + "/ListCartServlet");
        System.out.println(url);
        response.sendRedirect(url);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
