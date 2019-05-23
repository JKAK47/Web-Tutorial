package org.vincent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.vincent.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName ModelDataBindController.java
 * @date 2019/5/19 - 15:42
 * @ProjectName Web-Tutorial
 * @Description: 模型数据绑定到域对象中返回给view 中
 * 真实魔幻， 刚开始在jsp不能获取域对象，突然之间可以获取了，这是怎么了
 */
@Controller
@SessionAttributes(value="user",types = {User.class,String.class})/*将model 数据绑定到session 中 */
public class ModelDataBindController {

    /**
     * 这个方法失败 ，jsp 不能获取模型数据
     */
    @RequestMapping("/mapBindTest")
    public String mapTest(Map<String, Object> map) {
        User user = new User();
        user.setId(1);
        user.setName("张三 mapBindTest");
        map.put("user", user);
        return "ModelDisplay";
    }

    @RequestMapping("/modelTest")
    public String modelTest(Model model) {
        User user = new User();
        user.setId(1);
        user.setName("张三 modelTest");
        model.addAttribute("user", user);
        return "ModelDisplay";
    }



    /** model and view 使用案例
     * */
    @RequestMapping("/modelAndViewTest1")
    public ModelAndView modelAndViewTest1(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setId(1);
        user.setName("张三 modelAndViewTest1");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("ModelDisplay");
        return modelAndView;
    }

    @RequestMapping("/modelAndViewTest2")
    public ModelAndView modelAndViewTest2(){
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        user.setId(1);
        user.setName("张三 modelAndViewTest2");
        modelAndView.addObject("user", user);
        View view = new InternalResourceView("ModelDisplay.jsp");
        modelAndView.setView(view);
        return modelAndView;
    }

    @RequestMapping("/modelAndViewTest3")
    public ModelAndView modelAndViewTest3(){
        ModelAndView modelAndView = new ModelAndView("ModelDisplay");
        User user = new User();
        user.setId(1);
        user.setName("张三 modelAndViewTest3");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/modelAndViewTest4")
    public ModelAndView modelAndViewTest4(){
        View view = new InternalResourceView("ModelDisplay.jsp");
        ModelAndView modelAndView = new ModelAndView(view);
        User user = new User();
        user.setId(1);
        user.setName("张三 modelAndViewTest4" );
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping("/modelAndViewTest5")
    public ModelAndView modelAndViewTest5(){
        Map<String,Object> map = new HashMap<String,Object>();
        User user = new User();
        user.setId(1);
        user.setName("张三 modelAndViewTest5");
        map.put("user", user);
        ModelAndView modelAndView = new ModelAndView("ModelDisplay", map);
        return modelAndView;
    }

    @RequestMapping("/modelAndViewTest6")
    public ModelAndView modelAndViewTest6(){
        Map<String,Object> map = new HashMap<String,Object>();
        User user = new User();
        user.setId(1);
        user.setName("张三 modelAndViewTest6");
        map.put("user", user);
        View view = new InternalResourceView("ModelDisplay.jsp");
        ModelAndView modelAndView = new ModelAndView(view, map);
        return modelAndView;
    }

    @RequestMapping("/modelAndViewTest7")
    public ModelAndView modelAndViewTest7(){
        User user = new User();
        user.setId(1);
        user.setName("张三 modelAndViewTest7");
        ModelAndView modelAndView = new ModelAndView("ModelDisplay", "user", user);
        return modelAndView;
    }

    @RequestMapping("/modelAndViewTest8")
    public ModelAndView modelAndViewTest8(){
        User user = new User();
        user.setId(1);
        user.setName("张三 modelAndViewTest8");
        View view = new InternalResourceView("ModelDisplay.jsp");
        ModelAndView modelAndView = new ModelAndView(view, "user", user);
        return modelAndView;
    }


    @RequestMapping("requestTest")
    public String requestTest(HttpServletRequest request){
        User user = new User();
        user.setId(1);
        user.setName("张三 requestTest");
        request.setAttribute("user", user);
        return "ModelDisplay";
    }
    /**
     * 将一个方法返回值 绑定到 model 属性上 ，
     * 会在SpringMVC在调用任何一个业务方法之前被自动调用。
     * */
    @ModelAttribute
    public User getUser(){
        User user = new User();
        user.setId(1);
        user.setName("张三");
        return user;
    }

    /** 以上的方式全部是将模型数据绑定到 request 对象中  */
    /** 如果需要将模型数据绑定到session对象中，只需要在类定义处添加@SessionAttributes(value="user")注解即可。
     * */

}
