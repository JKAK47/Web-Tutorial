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
 * @Description: 从页面提交一个 form 表单 数据，Controller 自动映射到 javabean
 *
 */
@Controller
public class AddUserController {

    /**
     *
     * 参数绑定 ：Pojo
     * */

    /**
     * http://localhost:8080/springmvc-demo-01/addUser.jsp
     * addUser.jsp 提交 一个表单过来，spiingMVC 的handleAdapter 自动将表单数据和javaBean 转换
     * 现在不能用  @RequestBody  注解，这个注解表示方法参数接受http 请求体中的内容，这个内容通过 HttpMessageConverter 接口 转换 ，默认是json形式的，所以form提交形式应该是表单才可以。
     * 所以先去掉 这个注解，可以正常获取
     * @param user
     * @return
     */
    @RequestMapping(path = "/addUser", method = RequestMethod.POST)
    public String xx(  User user) {
        System.out.println(user);
        return "index";
    }
}
