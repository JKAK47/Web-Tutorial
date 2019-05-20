package org.vincent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vincent.service.SimpleService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName ServiceController.java
 * @date 2019/5/21 - 0:10
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@Controller
public class ServiceController {
    @Autowired
    private SimpleService simpleService;

    /**
     * Controller 依赖service 并实现调用service
     *
     * */
    @RequestMapping(path = "/service")
    @ResponseBody
    public Map<String, Object> xx(@RequestParam String name, @RequestParam int age) {
        System.out.println(name);
        System.out.println(age);
        String s = simpleService.simpleMethod(name, age);
        Map<String, Object> map = new HashMap<>();
        map.put("key", s);
        return map;
    }
}
