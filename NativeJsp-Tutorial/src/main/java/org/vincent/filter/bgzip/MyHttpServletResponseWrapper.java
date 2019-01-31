package org.vincent.filter.bgzip;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Package: org.vincent.filter.bgzip
 * Created by PengRong on 2019/1/31.
 * ProjectName: Web-Tutorial
 * https://blog.csdn.net/KokJuis/article/details/77371324
 * https://blog.csdn.net/qq_29721419/article/details/81747477
 * https://blog.csdn.net/hg_zw/article/details/44041741
 */
public class MyHttpServletResponseWrapper extends HttpServletResponseWrapper{
    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response
     * @throws IllegalArgumentException if the response is null
     */
    public MyHttpServletResponseWrapper(HttpServletResponse response) {
        super(response);
    }
}
