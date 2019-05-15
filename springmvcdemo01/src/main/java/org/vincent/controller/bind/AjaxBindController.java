package org.vincent.controller.bind;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vincent.pojo.User;

/**
 * @author PengRong
 * @package org.vincent.controller.bind
 * @ClassName AjaxBindController.java
 * @date 2019/5/16 - 0:46
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@Controller
public class AjaxBindController {
    /**
     * jquery 发送来的网络请求，请求体重数据是用json格式提交的，所以可以使用 RequestBody 注解自动绑定 请求体和接口方法形参
     * */
    @RequestMapping(value="/jsonType")
    @ResponseBody
    public User jsonType(@RequestBody User user){
        //修改id
        user.setId(user.getId()+10);
        //返回前端
        return user;
    }
}
