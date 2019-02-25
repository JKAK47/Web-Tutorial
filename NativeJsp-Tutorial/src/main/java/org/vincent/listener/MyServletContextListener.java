package org.vincent.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebListener;

/**
 * @author PengRong
 * @package org.vincent.listener
 * @date 2019/2/19 - 21:32
 * @ProjectName Web-Tutorial
 * @Description: MyServletContextListener 监听器，需要在web.xml 注册 设置,或者 @WebListener 注解标注即可
 */
@WebListener
public class MyServletContextListener implements ServletContextListener{
    /**
     * 当web应用初始化进程开始的时候，回调这个方法，
     * ServletContext携带在 ServletContextEvent 对象里面
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext context=sce.getServletContext();
        System.out.println("设置监听器属性属性,ServletContext开始初始化");
        context.setAttribute("context-listentr", "asdfsd");
        // SessionCookieConfig 类用于配置许多Cookie 属性用于 session 会话跟踪
       // SessionCookieConfig config =context.getSessionCookieConfig();
        //config.setName("my-sessionId");

    }

    /**
     * 当web 应用进程正在关闭时候回调这个方法。
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        String value= (String) sce.getServletContext().getAttribute("context-listentr");
        System.out.println("value : "+value);
        System.out.println("contextDestroyed");
    }
}
