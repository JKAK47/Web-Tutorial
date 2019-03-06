package org.vincent.servlet.tutorial;

import org.apache.commons.lang3.CharSetUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.Enumeration;

/**
 * @author PengRong
 * @package org.vincent.servlet.tutorial
 * @date 2019/3/5 - 23:13
 * @ProjectName Web-Tutorial
 * @Description: RequestClentServlet 关于获取客户端主机信息的servlet
 */
@WebServlet(
        name = "RequestClentServlet",
        urlPatterns = {"/RequestClentServlet"}
)
public class RequestClentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.获得客户机信息
         */
        String requestUrl = request.getRequestURL().toString();//得到请求的URL地址
        String requestUri = request.getRequestURI();//得到请求的资源
        /* 返回的url 参数字符串中文会乱码 */
        String queryString = request.getQueryString();//得到请求的URL地址中附带的参数
        String name = new String(request.getParameter("sdf").getBytes("UTF-8"),"UTF-8");
        /* 处理get 参数中有中文的问题
         * request.getParameter(key) 能处理中文乱码问题。
         *
          * */
        Enumeration<String> keys=request.getParameterNames();
        if (keys!=null){
            StringBuilder builder =new StringBuilder();
            while (keys.hasMoreElements()){
                String key =keys.nextElement();
                String value =request.getParameter(key);
               /*
                以超链接形式GET 传递中文参数的乱码问题不能这样处理
                key= new String(key.getBytes("ISO8859-1"),"UTF-8");
                value = new String(value.getBytes("ISO8859-1"),"UTF-8");*/
                builder.append(key+"="+value);
                builder.append("&");
            }
            queryString =builder.substring(0, builder.length()-1).toString();
        }

        String remoteAddr = request.getRemoteAddr();//得到来访者的IP地址
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String remoteUser = request.getRemoteUser();
        String method = request.getMethod();//得到请求URL地址时使用的方法
        String pathInfo = request.getPathInfo();
        String localAddr = request.getLocalAddr();//获取WEB服务器的IP地址
        String localName = request.getLocalName();//获取WEB服务器的主机名
        response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("获取到的客户机信息如下：");
        out.write("<hr/>");
        out.write("请求的URL地址：" + requestUrl);
        out.write("<br/>");
        out.write("请求的资源：" + requestUri);
        out.write("<br/>");
        out.write("请求的URL地址中附带的参数：" + queryString);
        out.write("<br/>");
        out.write("来访者的IP地址：" + remoteAddr);
        out.write("<br/>");
        out.write("来访者的主机名：" + remoteHost);
        out.write("<br/>");
        out.write("使用的端口号：" + remotePort);
        out.write("<br/>");
        out.write("remoteUser：" + remoteUser);
        out.write("<br/>");
        out.write("请求使用的方法：" + method);
        out.write("<br/>");
        out.write("pathInfo：" + pathInfo);
        out.write("<br/>");
        out.write("localAddr：" + localAddr);
        out.write("<br/>");
        out.write("localName：" + localName);
        out.write("<hr/>");

        Enumeration<String> reqHeadInfos = request.getHeaderNames();//获取所有的请求头
        out.write("获取到的客户端所有的请求头信息如下：");
        out.write("<hr/>");
        while (reqHeadInfos.hasMoreElements()) {
            String headName = (String) reqHeadInfos.nextElement();
            String headValue = request.getHeader(headName);//根据请求头的名字获取对应的请求头的值
            out.write(headName + "\t:\t" + headValue);
            out.write("<br/>");
        }
        out.write("<br/>");
        out.write("获取到的客户端Accept-Encoding请求头的值：");
        out.write("<hr/>");
        String value = request.getHeader("Accept-Encoding");//获取Accept-Encoding请求头对应的值
        out.write(value);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
