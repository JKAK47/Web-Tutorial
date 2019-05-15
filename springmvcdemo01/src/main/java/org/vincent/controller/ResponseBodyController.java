package org.vincent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName ResponseBodyController.java
 * @date 2019/5/14 - 23:22
 * @ProjectName Web-Tutorial
 * @Description: @ResponseBody注解直接返回字符串到前端， 可以将方法返回值直接绑定到web response body 中直接 返回，也就是方法返回值当作数据载荷返回不用 返回视图
 */
@Controller
public class ResponseBodyController {
    /**
     * 参数绑定 ：基本数据类型
     * */
    /**
     * 如果 是 基本类型获取到http请求参数，那么就不能为null。
     * 所以 http://localhost:8080/springmvc-demo-01/packageType 方法这个接口方法必报错, 基本类型不能接受为null的http参数
     * 必须是 http://localhost:8080/springmvc-demo-01/packageType?id=99
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/packageType")
    @ResponseBody
    public String packageType(int id) {
        return "id:" + id;
    }

    /**
     * 通过包装类获取到http请求参数 可以为null
     * 所以 访问   http://localhost:8080/springmvc-demo-01/packageType 方法 ，不会报错，这个时候id = null
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/packageTypeI")
    @ResponseBody
    public String packageType(Integer id) {
        return "id:" + id;
    }

    /**
     * RequestParam 不是必要的，也可以获取到http请求参数
     */
    @RequestMapping(value = "/packageTypeIr")
    @ResponseBody
    public String packageType1(@RequestParam(value = "id", required = true, defaultValue = "1") Integer id) {
        return "id:" + id;
    }

    /**
    *
    * 参数绑定 ：数组
     * produces = {"application/json; charset=utf-8"} 标定返回 结果集 content-type header 防止ResponseBody中文乱码
    * */

    @RequestMapping(value = "/array",produces = {"text/plain; charset=utf-8"})
    @ResponseBody
    public String packageType1(@RequestParam(value = "name", required = true, defaultValue = "1") String[] name) {
        return "names:" + Arrays.asList(name);
    }

}
