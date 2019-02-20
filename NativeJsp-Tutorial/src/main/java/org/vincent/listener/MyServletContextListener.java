package org.vincent.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author PengRong
 * @package org.vincent.listener
 * @date 2019/2/19 - 21:32
 * @ProjectName Web-Tutorial
 * @Description: MyServletContextListener 监听器
 */
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
