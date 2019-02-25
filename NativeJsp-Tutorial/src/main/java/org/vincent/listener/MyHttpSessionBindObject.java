package org.vincent.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author PengRong
 * @package org.vincent.listener
 * @date 2019/2/21 - 0:13
 * @ProjectName Web-Tutorial
 * @Description: HttpSessionBindingListener 监听器是用于
 * 当一个普通java 类被 添加到 httpsession 作为属性或者从httpsession 中删除时 希望可以被通知到，则实现 HttpSessionBindingListener 接口
 */
public class MyHttpSessionBindObject implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        String Id=event.getSession().getId();
        System.out.println("触发绑定事件! 添加绑定到 HttpSession.Id : "+Id +" ,name ： "+name +" ,value : "+value);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        String name = event.getName();
        Object value = event.getValue();
        String Id=event.getSession().getId();
        System.out.println("触发解绑定事件! 解绑定 HttpSession.Id : "+Id +" ,name ： "+name +" ,value : "+value);
    }
}
