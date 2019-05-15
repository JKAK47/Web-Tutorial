package org.vincent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName forwordController.java
 * @date 2019/5/14 - 22:58
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@Controller
public class forwordController {
    /**
     * http://localhost:8080/springmvc-demo-01/forwardTest 回车，url 上面没有变化
     * 页面跳转方式：转发
     * 在浏览器上面不能看到 url 变化
     * springmvc 默认的方式
     * */
    @RequestMapping("/forwardTest")
    public String forward(){
        return "forward:/index3.jsp";
    }
    /**
     * 页面跳转方式：转发
     * 在浏览器上面能看到 url 变化
     * http://localhost:8080/springmvc-demo-01/redirectTest 变成：
     * http://localhost:8080/springmvc-demo-01/index.jsp
     * */
    @RequestMapping("redirectTest")
    public String redirectTest(){
        return "redirect:/index.jsp";
    }
}
