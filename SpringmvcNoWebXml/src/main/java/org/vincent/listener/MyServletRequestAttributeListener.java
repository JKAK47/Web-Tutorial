package org.vincent.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * @author PengRong
 * @package org.vincent.listener
 * @date 2019/2/20 - 23:19
 * @ProjectName Web-Tutorial
 * @Description: 在Httpservlet 属性变更 监听器
 */
@WebListener
public class MyServletRequestAttributeListener  implements ServletRequestAttributeListener{
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        ServletRequest request = srae.getServletRequest();
        //获取添加的属性名和属性值
        String key = srae.getName();
        Object value = srae.getValue();
        //System.out.println("ServletRequest= "+request.toString() + "范围内添加了名为" + "key : " + key + " value :" + value);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        ServletRequest request = srae.getServletRequest();
        //获取添加的属性名和属性值
        String key = srae.getName();
        Object value = srae.getValue();
        //System.out.println("ServletRequest= "+request.toString() + "范围内删除了名为" + "key : " + key + " value :" + value);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        ServletRequest request = srae.getServletRequest();
        //获取添加的属性名和属性值
        String key = srae.getName();
        Object oldValue = srae.getValue();//获取的是旧值
        Object newValue =srae.getServletRequest().getAttribute(srae.getName());
        //System.out.println("ServletRequest= "+request.toString() + "范围内修改了名为" + "key : " + key + " Oldvalue :" + oldValue + " newValue: " + newValue);
    }
}
