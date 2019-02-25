package org.vincent.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author PengRong
 * @package org.vincent.listener
 * @date 2019/2/20 - 23:31
 * @ProjectName Web-Tutorial
 * @Description: HttpSessionListener
 * 当一个浏览器第一次访问网站的时候，J2EE应用服务器会新建一个HttpSession对象 ，并触发 HttpSession创建事件 ，如果注册了HttpSessionListener 事件监听器，
 * 则会调用HttpSessionListener事件监听器的sessionCreated方法。相反，当这个浏览器访问结束超时的时候，J2EE应用服务器会销毁相应的HttpSession对象，
 * 触发 HttpSession销毁事件，同时调用所注册HttpSessionListener事件监听器的sessionDestroyed方法。
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener  {
    /**
     * 当httpsession 刚创建时候回调这个方法
     *
     * @param se
     */
    @Override
    public void sessionCreated(HttpSessionEvent  se) {
        se.getSession().getMaxInactiveInterval();
        System.out.println("create session : "+se.getSession().getId());
        ServletContext ctx = se.getSession().getServletContext();
        Integer numSessions = (Integer) ctx.getAttribute("numSessions");
        if (numSessions == null) {
            numSessions = new Integer(1);
        } else {
            int count = numSessions.intValue();
            numSessions = new Integer(count + 1);
        }
        ctx.setAttribute("numSessions", numSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext ctx = se.getSession().getServletContext();
        System.out.println("delete session : "+se.getSession().getId());
        Integer numSessions = (Integer) ctx.getAttribute("numSessions");
        if (numSessions == null) {
            numSessions = new Integer(0);
        } else {
            int count = numSessions.intValue();
            numSessions = (count - 1 > 0) ? new Integer(count - 1) : new Integer(0);
        }
        ctx.setAttribute("numSessions", numSessions);
    }
}
