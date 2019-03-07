package org.vincent.servlet.tutorial.session.mutilsubmit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PengRong
 * @package org.vincent.servlet.tutorial.session.mutilsubmit
 * @date 2019/3/7 - 8:07
 * @ProjectName Web-Tutorial
 * @Description: 表单处理类
 */
@WebServlet(
        name = "DoFormServlet",
        urlPatterns = {"/DoFormServlet"}
)
public class DoFormServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* 服务器告诉书写器使用utf-8 字符集编码成字节流 */
        response.setCharacterEncoding("UTF-8");
        /* 通知浏览器 使用utf-8 字符集解码*/
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter writer =response.getWriter();
        boolean b = isRepeatSubmit(request);//判断用户是否是重复提交
        if(b==true){
            writer.write("请不要重复提交");
            System.out.println("请不要重复提交");
            return;
        }
        request.getSession().removeAttribute("token");//移除session中的token
        System.out.println("处理用户提交请求！！");
        writer.write("处理用户提交请求！！");
    }

    /**
     * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
     * @param request
     * @return
     *         true 用户重复提交了表单
     *         false 用户没有重复提交表单
     */
    private boolean isRepeatSubmit(HttpServletRequest request) {
        String client_token = request.getParameter("token");
        //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
        if(client_token==null){
            return true;
        }
        //取出存储在Session中的token
        String server_token = (String) request.getSession().getAttribute("token");
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        if(server_token==null){
            return true;
        }
        //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
        if(!client_token.equals(server_token)){
            return true;
        }

        return false;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
