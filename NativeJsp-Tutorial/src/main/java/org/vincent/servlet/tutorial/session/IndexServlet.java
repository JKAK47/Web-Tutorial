package org.vincent.servlet.tutorial.session;

import org.vincent.servlet.tutorial.session.bean.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

/**
 * @author PengRong
 * @package org.vincent.servlet.tutorial.session
 * @date 2019/3/7 - 0:41
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@WebServlet(
        name = "IndexServlet",
        urlPatterns = {"/IndexServlet"}
)
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //创建Session
        request.getSession();
        out.write("本网站有如下书：<br/>");
        Set<Map.Entry<String, Book>> set = DB.getAll().entrySet();
        this.getServletContext().getContextPath();
        for (Map.Entry<String, Book> me : set) {
            Book book = me.getValue();
            String url = request.getContextPath() + "/BuyServlet?id=" + book.getId();
            //response. encodeURL(java.lang.String url)用于对表单action和超链接的url地址进行重写
            /**
             * 将超链接的url地址进行重写, 如果浏览器不支持cookie ，那么 encodeURL 将对url进行附加sessionId 到url里面去
             *
             * 不支持cookie， 加了sessionId
             * <a href='/nativejsp/BuyServlet;jsessionid=DC4FA20DEC477C395DD5F5C39943CA7D?id=5'>购买</a><br/>
             * 支持cookie ，没加sessionId
             * <a href='/nativejsp/BuyServlet?id=5'>购买</a><br/>
             *
             * URL重写这种解决方案解决Session id 数据共享问题
             * encodeURL方法挺智能的，当检测到浏览器没有禁用cookie时，那么就不进行URL重写了
             */
            url = response.encodeURL(url);
            out.println(book.getName() + "   <a href='" + url + "'>购买</a><br/>");
        }
    }
}
