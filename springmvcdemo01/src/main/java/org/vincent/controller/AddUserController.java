package org.vincent.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vincent.pojo.User;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName AddUserController.java
 * @date 2019/5/13 - 23:34
 * @ProjectName Web-Tutorial
 * @Description: 从页面提交一个javaBean 数据，Controller 自动映射到 javabean
 * 还有问题
 */
@Controller
public class AddUserController {

    @RequestMapping(path = "/addUser", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String xx(@RequestBody User user) {
        System.out.println(user);
        return "index";
    }
}
