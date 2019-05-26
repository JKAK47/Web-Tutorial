package org.vincent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.vincent.listener.MyHttpSessionBindingListener;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName HomeController.java
 * @date 2019/5/25 - 12:13
 * @ProjectName Web-Tutorial
 * @Description: 基于SpringMVC 中无 web.xml 文件实现的web项目
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request)   {
        request.getSession().setAttribute("MyHttpSessionBindingListener", new MyHttpSessionBindingListener());


        String message = "Hello world from Spring MVC";
        return new ModelAndView("home", "message", message);
    }
}
