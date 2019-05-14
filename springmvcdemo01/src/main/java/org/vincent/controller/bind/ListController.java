package org.vincent.controller.bind;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vincent.pojo.User;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * @author PengRong
 * @package org.vincent.controller.bind
 * @ClassName ListController.java
 * @date 2019/5/15 - 0:10
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@Controller
public class ListController {

    /**
     * produces = {"application/json; charset=utf-8"} 可以解决 responseBody 中文乱码问题
     * */
    @RequestMapping(value="/listType")
    @ResponseBody
    public String listType(UserList userList ) throws UnsupportedEncodingException {
        StringBuffer sbf = new StringBuffer();
        for(User user:userList.getUsers()){
            sbf.append(user);
        }
        String value="用户："+sbf.toString();
        System.out.println(value);
        return value;
    }
}
