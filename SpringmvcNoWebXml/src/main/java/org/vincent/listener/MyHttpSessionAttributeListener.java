package org.vincent.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * @author PengRong
 * @package org.vincent.listener
 * @date 2019/2/20 - 23:55
 * @ProjectName Web-Tutorial
 * @Description: HttpSessionAttributeListener 当 往 HttpSession 中添加属性时候，删除属性，更新属性时候，将触发接口方法回调
 *
 */
@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("增加了 key : " + event.getName() + " value : " +
                event.getValue() );
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("删除了 key : " + event.getName() + " value : " +
                event.getValue() );
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("修改了 key : " + event.getName() + " oldvalue : " +
                event.getValue() + " newValue : "+event.getSession().getAttribute(event.getName()) );
    }
}
