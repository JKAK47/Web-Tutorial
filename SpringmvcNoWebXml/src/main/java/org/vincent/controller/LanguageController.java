package org.vincent.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName LanguageController.java
 * @date 2019/6/11 - 0:46
 * @ProjectName Web-Tutorial
 * @Description: 关于语言国际化 Controller
 */
@RestController
@Slf4j
public class LanguageController {

    /**
     * 根据 请求头获取不同的国际化资源
     *
     * @param request
     * @return
     */
    @RequestMapping(path = "/language")
    public String hello(HttpServletRequest request) {
        RequestContext requestContext = new RequestContext(request);
        String loginname = requestContext.getMessage("loginname");

        log.info(loginname);
        return loginname;

    }
}
