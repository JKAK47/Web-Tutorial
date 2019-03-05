package org.vincent.servlet.download;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author PengRong
 * @package org.vincent.servlet.download
 * @date 2019/3/5 - 8:24
 * @ProjectName Web-Tutorial
 * @Description: HttpServlet 实现文件下载
 *
 */
@WebServlet(
        name = "fileDownloadServlet",
        displayName = "downloadImg",
        urlPatterns = {"/download/img/v1"},
        initParams = {
                /*图片存储路径设置 */
                @WebInitParam(name = "imgLocation", value = "/img/1.gif")
        }
)
public class FileDownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * //下载文件，通过OutputStream流
         */
        downloadFileByOutputStream(resp, getServletConfig().getInitParameter("imgLocation"));
    }

    /**
     * @param response
     * @param filePath
     * @throws FileNotFoundException
     * @throws UnsupportedEncodingException
     */
    private void downloadFileByOutputStream(HttpServletResponse response, String filePath) throws FileNotFoundException, UnsupportedEncodingException {
        String realPath = this.getServletContext().getRealPath("/img/1.gif");//获取要下载的文件的绝对路径
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);//获取要下载的文件名
        response.setHeader("content-type", "image/gif");//使用content-type响应头指定发送给浏览器的数据类型为"image/jpeg"
        //设置content-disposition响应头控制浏览器以下载的形式打开文件，中文文件名要使用URLEncoder.encode方法进行编码，否则会出现文件名乱码
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        InputStream in = new FileInputStream(realPath);//获取文件输入流
        int len = 0;
        byte[] buffer = new byte[1024];
        OutputStream out = null;
        try {
            out = response.getOutputStream();
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0, len);//将缓冲区的数据输出到客户端浏览器
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
