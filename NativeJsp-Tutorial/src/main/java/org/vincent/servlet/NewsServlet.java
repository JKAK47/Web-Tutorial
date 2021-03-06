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

        /** 转发 浏览器url没有变化，jsp 页面可以取出servlet 传递的request域的值
         * 但是页头对应的标题栏超链接失效，因为url 没有变化所以在 page-header.jsp 里面的页面相对路径失效
         *  解决办法是  page-header.jsp  应用的路径 通过 <%=basePath%> 绝对路径获得web app 的部署根目录
         * */
        req.getClass();
        req.getContextPath();
        req.getServletPath().lastIndexOf('/'); // /newsA index =0;  /newsA/aa http://pengrong.com/nativejsp/
        req.getPathInfo();// null ; null
        req.setAttribute("news", news);
        System.out.println(req.getRequestURL().toString());
        //http://localhost:8088/nativejsp/newsA
        //http://localhost:8088/nativejsp/font/newsFrontList.jsp

        //http://localhost:8088/nativejsp/newsA/aa
        req.getRequestDispatcher("font/newsFrontList.jsp").forward(req, resp);
        /*PrintWriter writer =resp.getWriter();
        resp.setContentType("text/html");
        writer.write("<html><body>Get/POST</body></html>");
        writer.flush();*/
        /** 重定向 浏览器有变化，但是接受不到servlet传递给他的request级别数据 */
        //resp.sendRedirect("newsA?id=80&name=pengrong");
        //resp.sendRedirect("http://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
