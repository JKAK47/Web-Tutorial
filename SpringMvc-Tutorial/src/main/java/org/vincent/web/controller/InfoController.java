package org.vincent.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author PengRong
 * @package org.vincent.web.controller
 * @date 2019/1/18 - 0:27
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@Controller
public class InfoController {

    @RequestMapping(method = RequestMethod.GET,value = "/pengrong")
    public ModelAndView gg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println(" infoController handleRequest method invoke.");
        ModelAndView view=new ModelAndView();
        /** 设置模型数据，可以是任意的POJO对象 */
        view.addObject("msg","info msg: "+ request.getMethod().toString()+"\t"+request.getRemoteHost());
        /* 视图处理器已经配置了前缀和后缀，就只需要配置访问的 */
        view.setViewName("info");
        return view;
    }
}
