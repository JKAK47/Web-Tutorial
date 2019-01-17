package org.vincent.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author PengRong
 * @package org.vincent.web.controller
 * @date 2019/1/18 - 0:00
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@Controller
@RequestMapping("/")
public class OneController {
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map){
        map.addAttribute("msg", "SpringMVC 5.1.3");
        return "index";
    }
}
