package org.vincent.filter.gzip;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author PengRong
 * @package org.vincent.filter.gzip
 * @date 2019/1/27 - 13:22
 * @ProjectName Web-Tutorial
 * @Description: 继承 HttpServletResponseWrapper 实现对  HttpServletResponse 类型数据的包装.含有两个成员属性 GZipServletOutputStream，PrintWriter
 *                  这两个类是对内容使用GZip压缩的实例，获取他的实例引用即可压缩文本。
 */
public class GZipServletResponseWrapper extends HttpServletResponseWrapper {
    /* 以字节方式输出 流*/
    private GZipServletOutputStream gzipOutputStream = null;
    /* 以字符方式输出流 */
    private PrintWriter printWriter = null;

    public GZipServletResponseWrapper(HttpServletResponse httpResponse) {
        super(httpResponse);
    }

    /**
     *关闭两个成员属性资源 GZipServletOutputStream，PrintWriter
     * @throws IOException
     */
    public void close() throws IOException {
        //PrintWriter.close does not throw exceptions.
        //Hence no try-catch block.
        if (this.printWriter != null) {
            this.printWriter.close();
        }
        if (this.gzipOutputStream != null) {
            this.gzipOutputStream.close();
        }
    }

    /**
     * 同时刷新 Flush OutputStream and PrintWriter
     *
     * @throws IOException
     */
    @Override
    public void flushBuffer() throws IOException {
        //PrintWriter.flush() does not throw exception
        if (this.printWriter != null) {
            this.printWriter.flush();
        }
        IOException exception1 = null;
        try {
            if (this.gzipOutputStream != null) {
                this.gzipOutputStream.flush();
            }
        } catch (IOException e) {
            exception1 = e;
        }
        IOException exception2 = null;
        try {
            super.flushBuffer();
        } catch (IOException e) {
            exception2 = e;
        }
        if (exception1 != null) throw exception1;
        if (exception2 != null) throw exception2;
    }

    /**
     * 将初始化 gzipOutputStream 获取到 GZipServletOutputStream 输出流( 字节方式)并不会初始化 printWriter。修改
     * ServletReponseWrapper.getOutputStream 接口方法 让他返回 GZipServletOutputStream 实现对 response 文本进行gzip 压缩
     * @return
     * @throws IOException 如果 printWriter实例不为空将抛 异常。默认是需要先获取OutputStream 字节流方式 才可以获取字符流方式
     */
    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (this.printWriter != null) {
            throw new IllegalStateException("PrintWriter obtained already - cannot get OutputStream");
        }
        if (this.gzipOutputStream == null) {
            this.gzipOutputStream = new GZipServletOutputStream(getResponse().getOutputStream());
        }
        return this.gzipOutputStream;
    }


    /**
     * 将初始化 gzipOutputStream 获取到 GZipServletOutputStream 输出流( 字节方式) 以及初始化 printWriter(字符流方式)
     * @return
     * @throws IOException
     */
    @Override
    public PrintWriter getWriter() throws IOException {
        if (this.printWriter == null && this.gzipOutputStream != null) {
            throw new IllegalStateException("OutputStream obtained already - cannot get PrintWriter");
        }
        if (this.printWriter == null) {
            this.gzipOutputStream = new GZipServletOutputStream(getResponse().getOutputStream());
            this.printWriter = new PrintWriter(new OutputStreamWriter(this.gzipOutputStream, getResponse().getCharacterEncoding()));
        }
        return this.printWriter;
    }

    @Override
    public void setContentLength(int len) {
        //ignore, since content length of zipped content
        //does not match content length of unzipped content.
    }
}