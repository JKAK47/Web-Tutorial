package org.vincent.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author PengRong
 * @package org.vincent.listener
 * @date 2019/2/20 - 23:06
 * @ProjectName Web-Tutorial
 * @Description: ServletRequestListener 类型监听器 ，每次请求到来, 处理完离开都被监听到
 * ServletRequestListener的实际用途：统计网站的请求数量，可以计算网站性能（实际应用不多）
 */
@WebListener
public class MyServletRequestListener implements ServletRequestListener  {
    /**
     * ServletRequest 请求处理完成之后回调方法
     * @param sre
     */
    @Override
    public void requestDestroyed(ServletRequestEvent  sre) {
        ServletRequest servletRequest = sre.getServletRequest();
        long start = (long) servletRequest.getAttribute("start");
        servletRequest.removeAttribute("start");
        long end = System.nanoTime();
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String url = httpServletRequest.getRequestURI();
        System.out.println("url【"+url+"】请求处理用时【"+(end - start)/(1000*1000*1000) +"】s");

    }
    /**|
     * ServletRequest 请求处理完成进入处理前回调方法
     * @param sre
     */
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        // TODO Auto-generated method stub
        ServletRequest servletRequest  = sre.getServletRequest();
        /*提供相对精确的计时，但是不能用他来计算当前日期*/
        servletRequest.setAttribute("start", System.nanoTime());
    }
}
