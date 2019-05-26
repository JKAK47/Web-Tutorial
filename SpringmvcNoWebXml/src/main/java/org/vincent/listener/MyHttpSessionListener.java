package org.vincent.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author PengRong
 * @package org.vincent.listener
 * @date 2019/2/20 - 23:31
 * @ProjectName Web-Tutorial
 * @Description: HttpSessionListener
 * 当一个浏览器第一次访问网站的时候，J2EE应用服务器会新建一个HttpSession对象 ，并触发 HttpSession创建事件 ，如果注册了HttpSessionListener 事件监听器，
 * 则会调用HttpSessionListener事件监听器的sessionCreated方法。相反，当这个浏览器访问结束超时的时候，J2EE应用服务器会销毁相应的HttpSession对象，
 * 触发 HttpSession销毁事件，同时调用所注册HttpSessionListener事件监听器的sessionDestroyed方法。
 * <p>
 * <p>统计当前有多少用户在使用</p>
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    private AtomicLong atomicLong = new AtomicLong(0);

    /**
     * 当 httpsession 刚创建时候回调这个方法
     *
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        int maxInactiveInterval = se.getSession().getMaxInactiveInterval();
        System.out.println(maxInactiveInterval);
        System.out.println("create session : " + se.getSession().getId());
        ServletContext ctx = se.getSession().getServletContext();
        ctx.setAttribute("numSessions", atomicLong.getAndIncrement() + 1);
    }

    /**
     * 当httpsession 失效时候回调这个方法
     *
     * @param se
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        System.out.println("delete session : " + se.getSession().getId());
        Long numSessions = (Long) ctx.getAttribute("numSessions");
        if (numSessions == null) {
            atomicLong.getAndSet(0);
            ctx.setAttribute("numSessions", 0);
        } else {
            if (numSessions == 0) {
                atomicLong.getAndSet(0);
                ctx.setAttribute("numSessions", 0);
            } else {
                ctx.setAttribute("numSessions", atomicLong.getAndDecrement() - 1);
            }

        }
    }
}
