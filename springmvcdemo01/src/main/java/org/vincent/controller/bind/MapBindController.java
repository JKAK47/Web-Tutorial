package org.vincent.controller.bind;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vincent.pojo.User;

/**
 * @author PengRong
 * @package org.vincent.controller.bind
 * @ClassName MapBindController.java
 * @date 2019/5/16 - 0:35
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@Controller
public class MapBindController {
    /**
     *  userMap 拿不到值，接受到的是null
     *  */
    @RequestMapping(value="/mapType")
    @ResponseBody
    public String mapType(UserMap userMap){
        StringBuffer sbf = new StringBuffer();
        for(String key:userMap.getUserMap().keySet()){
            User user = userMap.getUserMap().get(key);
            sbf.append(user);
        }
        return "用户："+sbf.toString();
    }
}
