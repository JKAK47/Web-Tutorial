package org.vincent.servlet;

import org.vincent.dao.model.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author PengRong
 * @package org.vincent.servlet
 * @date 2019/1/21 - 7:53
 * @ProjectName Web-Tutorial
 * @Description: 这个servlet 接受 login.jsp 页面的请求 ，组织login.jsp提交的数据，并转发 在 font/userlist.jsp 输出。
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** ServletContext 使用场景 */
        /* 1、 获取在web.xml 通过context-param元素定义的全局变量  */
        String nativejsp = this.getServletContext().getInitParameter("nativejsp");
        System.out.println(nativejsp);
        /* 2、 读web根目录目录下 */
        InputStream inputStream = this.getServletContext().getResourceAsStream("/one.md");
        Objects.nonNull(inputStream);
        /*WEB-INF目录下的资源文件文件*/
        inputStream = this.getServletContext().getResourceAsStream("/WEB-INF/two.md");
          /*读取src/main/resources/目录下文件,该目录下最后打包后是复制到
           * WEB-INF/classes目录下
            * */
        inputStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/" + "mysql.properties");

        /* 3、 构建文件绝对路径
        *  路径参数如果以: "/"(代表web项目根目录) 字符开始，获取的路径是相对web 项目的根目录(也即webapp 目录下)
        *
        * */
        String path = this.getServletContext().getRealPath("/images/1.png");
        /* getResource 方法必须以 / 符号开始，从webApp root 目录开始寻找资源文件 */
        this.getServletContext().getResource("/");

        /** ServletContext 使用场景 end  */

        /* 获取Servlet 初始化定义的变量 */
        String registerone = this.getServletConfig().getInitParameter("registerone");

        String id = req.getSession().getId();
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        /* 获取 query 查询参数*/
        String account = req.getParameter("account");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String[] interest = req.getParameterValues("interest");
        String msg = req.getParameter("msg");

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
