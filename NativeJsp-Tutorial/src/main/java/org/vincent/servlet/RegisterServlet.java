package org.vincent.servlet;

import org.vincent.dao.model.UserBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @author PengRong
 * @package org.vincent.servlet
 * @date 2019/1/21 - 7:53
 * @ProjectName Web-Tutorial
 * @Description: 这个servlet 接受 login.jsp 页面的请求 ，组织login.jsp提交的数据，并转发 在 font/userlist.jsp 输出。
 */
/*@WebServlet(name = "asdf",urlPatterns = {"/sdf","/sdf"}, loadOnStartup = 0,
        initParams = {
        @WebInitParam(name = "key1",value = "asdfasd"),
        @WebInitParam(name = "key2",value = "sdfas")})*/
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /** ServletContext 使用场景 */
        /* 1、 获取在web.xml 通过context-param元素定义的全局变量  */
        String nativejsp = this.getServletContext().getInitParameter("nativejsp");
        System.out.println(nativejsp);
        /* 2、 读web根目录目录下,webapp 目录下 */
        InputStream inputStream = this.getServletContext().getResourceAsStream("/one.md");
        Objects.nonNull(inputStream);
        /*WEB-INF目录下的资源文件文件*/
        inputStream = this.getServletContext().getResourceAsStream("/WEB-INF/two.md");
        /*读取src/main/resources/目录下文件,该目录下最后打包后是复制到
         * WEB-INF/classes目录下，该目录下是 src/main/resources/目录，src/main/java/目录两个目录的资源文件
         * */
        inputStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/" + "mysql.properties");

        /* 3、 构建文件绝对路径
         *  路径参数如果以: "/"(代表web项目根目录) 字符开始，获取的路径是相对web 项目的根目录(也即webapp 目录下)
         *
         * */
        String path = this.getServletContext().getRealPath("/images/1.png");
        /* getResource 方法必须以 / 符号开始，从webApp root 目录开始寻找资源文件 */
        this.getServletContext().getResource("/");
        /* ServletContext 属性 */
        this.getServletContext().setAttribute("ServletContextKey","ServletContextValue");
        /** ServletContext 使用场景 end  */

        /* 获取Servlet 初始化定义的变量 */
        String registerone = this.getServletConfig().getInitParameter("registerone");

        String id = req.getSession().getId();
        req.setCharacterEncoding("utf-8");
        resp.getClass();
        resp.setContentType("text/html;charset=utf-8");
        /* 获取 query 查询参数  ?id=10&name=20 形式参数 */
        String account = req.getParameter("account");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        /* 获取 key 对应的 一组值， 对应前端是checkbox 多选框选定的值 */
        String[] interest = req.getParameterValues("interest");
        String msg = req.getParameter("msg");
        /* 获取query 查询参数另外一种方式*/
        Enumeration<String> enumerations = req.getParameterNames();
        while (enumerations.hasMoreElements()) {
            String key = enumerations.nextElement();
            System.out.println("key: " + key + ",\tvalue: " + req.getParameter(key));
        }
        /* 获取Http Header */
        Enumeration<String>  headers = req.getHeaderNames();
        while (headers.hasMoreElements()){
            String headerkey =headers.nextElement();
            System.out.println("headerkey: "+headerkey+",\theaderValue: "+req.getHeader(headerkey));
        }
        UserBean userBean = new UserBean();
        userBean.setAccount(account);
        userBean.setName(name);
        userBean.setGender(gender);
        userBean.setInterest(interest);
        userBean.setMsg(msg);


        req.setAttribute("USERLIST", userBean);
        req.getRequestURL();
        req.getRequestURI();
        /* 转发给 另外一个jsp  */
        req.getRequestDispatcher("font/userlist.jsp").forward(req, resp);
        /* 路径必须以 / 符号开始 解析为相对context root 目录下 */
        //this.getServletContext().getRequestDispatcher("/xx").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
