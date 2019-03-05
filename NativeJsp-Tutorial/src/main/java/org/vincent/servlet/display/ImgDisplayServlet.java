package org.vincent.servlet.display;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author PengRong
 * @package org.vincent.servlet.download
 * @date 2019/3/5 - 7:26
 * @ProjectName Web-Tutorial
 * @Description: 以字节流形式返回一个图片资源
 */
@WebServlet(
        name = "imgDownLoadServlet",
        displayName = "downloadImg",
        urlPatterns = {"/display/img/v1"},
        initParams = {
                /*图片存储路径设置 */
                @WebInitParam(name = "imgLocation",value = "/img/1.gif")
        }
)
public class ImgDisplayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 浏览器能接收(Accept)的数据类型有:
         * application/x-ms-application,
         * image/jpeg,
         * application/xaml+xml,
         * image/gif,
         * image/pjpeg,
         * application/x-ms-xbap,
         * application/vnd.ms-excel,
         * application/vnd.ms-powerpoint,
         * application/msword,
         */
        resp.setHeader("content-type", "image/gif");//使用content-type响应头指定发送给浏览器的数据类型为"image/jpeg"
        //读取位于项目根目录下的img文件夹里面的WP_20131005_002.jpg这张图片，返回一个输入流
        InputStream in = this.getServletContext().getResourceAsStream(getServletConfig().getInitParameter("imgLocation"));
        byte buffer[] = new byte[1024];
        int len = 0;
        OutputStream out = resp.getOutputStream();//得到输出流
        while ( ( len = in.read(buffer) ) > 0) {//读取输入流(in)里面的内容存储到缓冲区(buffer)
            out.write(buffer, 0, len);//将缓冲区里面的内容输出到浏览器
        }
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
