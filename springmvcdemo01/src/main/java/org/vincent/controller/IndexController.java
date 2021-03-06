package org.vincent.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.vincent.pojo.User;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName IndexController.java
 * @date 2019/5/13 - 22:07
 * @ProjectName Web-Tutorial
 * @Description: 最简单的基于 Controller 注解，处理逻辑，输出一个View
 * 不要使用 RestController 注解， 不然返回的对象会当作 Http返回，
 * Controller 注解，返回String值 当作视图名称
 */

@Controller
@RequestMapping("/index")
public class IndexController {
    /**
     * /index/v1 url 通过GET访问
     * produces 表示返回的数据类型。
     * @return
     */
    @RequestMapping(path = "/v1",method = GET,produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String index(){
        System.out.println("v1 index");
        return "{\"num\":7,\"name\":\"张晓天\",\"boolean\":true,\"double\":34.5,\"null\":null}";// 返回view 视图名称和相对 requestMapping 请求路径的 相对视图路径。
    }

    /**
     * RequestParam 参数绑定 ，将HTTP 请求参数和方法参数进行绑定
     *  @requestParam在业务方法中获取URL的参数 name 属性或者value 属性 是必须是HTTP 请求参数，该属性指定的参数绑定到接口方法参数，名称必须一致；可以获取中文参数不乱码
     *  http://localhost:8080/springmvc-demo-01/index/v2/?param=%E4%B8%AD%E5%9B%BD&age=44
     * @param param
     * @param age
     * @return
     */
    @RequestMapping(path = "/v2",method = GET)
    public String v2(@RequestParam(name = "param" ,required = true) String param, @RequestParam(name = "age") int age, HttpServletRequest request){
        request.getParameter("");
        System.out.println(param);
        System.out.println(age);
        return "index3";
    }


    /**
     * PathVariable 注解 将 RequestMapping 注解中模版变量绑定到接口方法参数中（支持restful风格的URL）
     * Restful风格 也支持中文路径： http://localhost:8080/springmvc-demo-01/index/v2/%E6%B1%9F%E8%A5%BF/?parxxam=%E4%B8%AD%E5%9B%BD&age=44
     * RequestParam 注解将http请求中请求参数绑定到接口方法参数中
     * RequestHeader 注解将http请求头属性绑定到接口方法中
     * CookieValue 注解 将cookie 值获取到
     * @param param
     * @return
     */
    @RequestMapping(path = "/v2/{param}",method = GET)
    public String v20(@PathVariable(name = "param" ,required = true) String param, @RequestParam(name = "age") int age,
                      @RequestHeader(name="Accept") String[] accepts,
                      @RequestHeader(name = "Cookie") String Cookie,
                      @CookieValue (name = "JSESSIONID") String sessionId){
        System.out.println(sessionId);
        System.out.println(Cookie);
        System.out.println(param);
        System.out.println(age);
        System.out.println(accepts);
        return "index3";
    }

    /**
     * 引入两个 PathVariable
     * @param fooid
     * @param barid
     * @return
     */
    @RequestMapping(value = "/ex/foos/{fooid}/bar/{barid}", method = GET)
    @ResponseBody
    public String getFoosBySimplePathWithPathVariables
            (@PathVariable long fooid, @PathVariable long barid) {
        return "Get a specific Bar with id=" + barid +
                " from a Foo with id=" + fooid;
    }

    /**
     * PathVariable 仅接受 数字，使用正则表达式描述
     * @param numericId
     * @return
     */
    @RequestMapping(value = "/ex/bars/{numericId:[\\d]+}", method = GET)
    @ResponseBody
    public String getBarsBySimplePathWithPathVariable(
            @PathVariable long numericId) {
        return "Get a specific Bar with id=" + numericId;
    }


}
