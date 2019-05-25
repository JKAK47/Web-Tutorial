package org.vincent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName HomeController.java
 * @date 2019/5/25 - 12:13
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/home", method= RequestMethod.GET)
    public ModelAndView home() {
        String message = "Hello world from Spring MVC";
        return new ModelAndView("home", "message", message);
    }
}
