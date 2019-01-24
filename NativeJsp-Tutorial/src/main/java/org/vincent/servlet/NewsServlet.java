package org.vincent.servlet;

import org.vincent.dao.NewsDao;
import org.vincent.dao.model.News;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author PengRong
 * @package org.vincent.dao
 * @date 2019/1/20 - 20:14
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class NewsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
        req.setCharacterEncoding("utf-8");
        /** request 获取参数 */
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        /** 获取一个key 的多个参数值*/
        req.getParameterValues("aa");


        resp.setContentType("text/html;charset=utf-8");
        NewsDao dao =new NewsDao();
        List<News> news =dao.querys();
        req.getSession().setAttribute("news", news);
        /** 转发 浏览器url没有变化，jsp 页面可以取出servlet 的值
         * 但是页头对应的标题栏超链接失效，因为url 没有变化所以在 page-header.jsp 里面的页面相对路径失效
         *  解决办法是  page-header.jsp  应用的路径 通过 <%=basePath%> 绝对路径获得web app 的部署根目录
         * */
        req.setAttribute("news", news);
        req.getRequestURL();
        req.getRequestDispatcher("font/newsFrontList.jsp").forward(req, resp);
        /** 重定向 浏览器有变化，但是接受不到servlet传递给他的数据 */
       // resp.sendRedirect("font/newsFrontList.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        doGet(req, resp);
    }
}
