package org.vincent.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @author PengRong
 * @package org.vincent.servlet
 * @ClassName JsonDataServletDo.java
 * @date 2019/5/25 - 11:47
 * @ProjectName Web-Tutorial
 * @Description: 基于 注解，工程没有web.xml 文件 的java web 项目
 */
@WebServlet(
        name = "jsonDataServlet",
        displayName = "JsonDataServlet",
        urlPatterns = "/jsondemo",
        initParams = {
                @WebInitParam(name = "key1", value = "asdfsd"),
                @WebInitParam(name = "key2", value = "wwwwww")},
        loadOnStartup = 1
)
public class JsonDataServletDo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置content-type消息头，告诉浏览器， 服务器返回的数据类型。

        //我这里是返回 json 类型
        resp.setContentType("application/json;charset=utf-8");

        //通过response对象获得输出流。
        PrintWriter out = resp.getWriter();

        /* 组装json 数据*/
        String json = "{\"firstName\": \"Json\",a: \"Hello\", b: \"World\"}";
        out.println(json);
        /** 获取servlet 注解注入的初始化参数 */
        json ="{\"InitParam key1\": \""+this.getServletConfig().getInitParameter("key1")+"\",InitParam key2: \""+this.getServletConfig().getInitParameter("key2");
        out.println(json);
        Enumeration<String> keys = req.getParameterNames();
        if (Objects.nonNull(keys)){
            while (keys.hasMoreElements()){
                String key =keys.nextElement();
                String value =req.getParameter(key);
                StringBuilder builder = new StringBuilder();
                builder.append("{\"");
                builder.append(key);
                builder.append("\": \"");
                builder.append(value);
                builder.append("\"}");
                out.println(builder.toString());
            }
        }
        /* 将json数据刷新到客户端浏览器 并关闭流*/
        out.flush();
        /** //如果没有调用out.close，则容器会自动 关闭out */
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
