package org.vincent.filter.gzip;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPOutputStream;

/**
 * @author PengRong
 * @package org.vincent.filter.gzip
 * @date 2019/1/27 - 13:22
 * @ProjectName Web-Tutorial
 * @Description: 实现对  OutputStream 字节输出流使用 GZip 文件格式压缩字节数据。内部组合 GZIPOutputStream 类引用 使用具体实施gzip 压缩工作
 */
public class GZipServletOutputStream extends ServletOutputStream {
    private GZIPOutputStream gzipOutputStream = null;
    /* 流是否打开的标识  */
    final AtomicBoolean openFlag = new AtomicBoolean(true);

    /**
     * @param output 输出流
     * @throws IOException
     */
    public GZipServletOutputStream(OutputStream output)
            throws IOException {
        super();
        this.gzipOutputStream = new GZIPOutputStream(output);
    }

    @Override
    public void close() throws IOException {
        if (openFlag.compareAndSet(true, false)) {
            this.gzipOutputStream.close();
        }
    }

    @Override
    public void flush() throws IOException {
        this.gzipOutputStream.flush();
    }

    /*************************************************************** 覆盖OutputStream类中定义的三个write方法 ***************************/
    /**
     * @param b
     * @throws IOException
     */
    @Override
    public void write(byte b[]) throws IOException {
        if (openFlag.get() && b != null) {
            super.write(b);
        }else {
            throw new IOException("Stream closed!");
        }
    }

    @Override
    public void write(byte b[], int off, int len) throws IOException {
        if (openFlag.get()) {
           super.write(b, off, len);
        } else {
            throw new IOException("Stream closed!");
        }
    }

    @Override
    public void write(int b) throws IOException {
        if (openFlag.get()) {
            this.gzipOutputStream.write(b);
        } else {
            throw new IOException("Stream closed!");
        }
    }
    /*************************************************************** 覆盖OutputStream类中定义的三个write方法 ***************************/
}
