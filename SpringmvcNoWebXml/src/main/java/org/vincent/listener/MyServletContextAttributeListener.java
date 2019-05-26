package org.vincent.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * @author PengRong
 * @package org.vincent.listener
 * @date 2019/2/20 - 22:38
 * @ProjectName Web-Tutorial
 * @Description: ServletContextAttributeListener 类型监听器，需要在web.xml 注册 设置,或者 @WebListener 注解标注即可
 */
@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        ServletContext application = event.getServletContext();
        //获取添加的属性名和属性值
        String key = event.getName();
        Object value = event.getValue();
        // System.out.println(application + "范围内添加了名为" + "key : " + key + " value :" + value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        ServletContext application = event.getServletContext();
        //获取被删除的属性名和属性值
        String name = event.getName();
        Object value = event.getValue();
        // System.out.println(application + "范围内名为" + name + "值为" + value + "的属性被删除了");


    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        ServletContext application = event.getServletContext();
        //获取被替换的属性名和属性值
        String name = event.getName();
        Object value = event.getValue();
        // System.out.println(application + "范围内" + name + "值为" + value + "的属性被替换了");
    }
}
