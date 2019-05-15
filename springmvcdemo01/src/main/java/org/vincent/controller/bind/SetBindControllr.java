package org.vincent.controller.bind;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vincent.pojo.User;

/**
 * @Package org.vincent.controller
 * @ClassName SetBindControllr.java
 * @date 2019/5/15 - 13:09
 * @description :   这里需要定义表单有多少个 User，然后初始化多少个User（在 UserSet 中设置），不能缺一个都不行
 * 这不是坑嘛, 这已经说明表单不可能提交Set这种数据类型了
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
