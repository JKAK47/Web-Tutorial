package org.vincent.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @author PengRong
 * @package org.vincent.listener
 * @date 2019/2/21 - 0:34
 * @ProjectName Web-Tutorial
 * @Description: HttpSessionActivationListener
 * https://stephen830.iteye.com/blog/2312003
 */
public class MyHttpSessionActivationListener implements HttpSessionActivationListener {
    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("session被存到硬盘中去了");
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("session从硬盘读入内存了");
    }
}
