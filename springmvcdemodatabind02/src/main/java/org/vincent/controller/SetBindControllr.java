package org.vincent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vincent.UserSet;
import org.vincent.pojo.User;

/**
 * @Package org.vincent.controller
 * @ClassName SetBindControllr.java
 * @date 2019/5/15 - 13:09
 * @description :接受来自 浏览器的数据乱码，返回去的不会乱码了
 * Created by PengRong .
 */
@Controller
public class SetBindControllr {
    @RequestMapping(path = "/settype")
    @ResponseBody
    public String settype(UserSet userSet){
        StringBuffer sbf = new StringBuffer();
        for(User user:userSet.getUsers()){
            sbf.append(user);
        }
        return "用户："+sbf.toString();
    }
}
