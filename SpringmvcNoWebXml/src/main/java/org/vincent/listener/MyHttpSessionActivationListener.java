package org.vincent.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

/**
 * @author PengRong
 * @package org.vincent.listener
 * @date 2019/2/21 - 0:34
 * @ProjectName Web-Tutorial
 * @Description: HttpSessionActivationListener
 * https://stephen830.iteye.com/blog/2312003
 * 当一个对象绑定到一个会话中，该对象对容器的session 事件感兴趣，对 session 属性的序列化和反序列化感兴趣 即可实现 HttpSessionActivationListener 接口，该接口不用注册
 * 当一个会话从一个JVM 转移到另外一个 JVM 时候或者需要持久化会话 容器对这两个过程进行通知操作即可实现这个接口；
 * 触发实现 HttpSessionActivationListener 接口的监听器类
 * <p>
 * http://www.cnblogs.com/caijh/p/7687514.html
 * http://www.cnblogs.com/stono/p/4862540.html
 * https://blog.csdn.net/wl_xt/article/details/19576589
 * //实现 HttpSessionActivationListener 接口的类 一定要实现Serializable接口，否则不能被序列化
 */
public class MyHttpSessionActivationListener implements HttpSessionActivationListener, Serializable {
    @Override
    public String toString() {
        return "MyHttpSessionActivationListener{" +
                "name='" + name + '\'' +
                '}';
    }

    private String name;

    public MyHttpSessionActivationListener(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * session钝化前执行（session从内存到硬盘）,或者在 会话 迁移（从AJVM 迁移到 BJVM） 前将序列化，
     *
     * @param se
     */
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        HttpSession Session = se.getSession();
        System.out.println("com.stono.servlet.listeners.MyHttpSessionActivationListener.sessionWillPassivate(HttpSessionEvent):" + se.getSession().getId() + " Session.attribute: " + Session.getAttribute("a").toString());
        System.out.println("session被存到硬盘中去了");
    }

    /**
     * session活化后执行（session从硬盘到内存） 或者在 会话 迁移（从AJVM 迁移到 BJVM） 后调用
     *
     * @param se
     */
    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        HttpSession Session = se.getSession();
        System.out.println("com.stono.servlet.listeners.MyHttpSessionActivationListener.sessionDidActivate(HttpSessionEvent):" + se.getSession().getId() + " Session.attribute: " + Session.getAttribute("a").toString());
        System.out.println("session从硬盘读入内存了");
    }
}
