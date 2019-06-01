package org.vincent.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vincent.bind.demo.model.Employee;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName BindController.java
 * @date 2019/5/27 - 0:06
 * @ProjectName Web-Tutorial
 * @Description: 表单校验 案例
 */
@Controller
@RequestMapping(path = "/bind")
@Validated
public class BindController {

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String newProfile(ModelMap model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee";
    }

    /**
     * 不需要 BindingResult result, 收集错误信息，前端不需要关系这个错误，只需要报错即可
     *
     * @param employee 接受表单数据  ，不是以Json 上传的数据，然后 通过@Valid 注解 判定是否满足情况
     * @param model
     * @return 加上 @Valid 注解
     */
    @RequestMapping(method = RequestMethod.POST, path = "submit")
    public String saveProfile(@Valid Employee employee,
                              ModelMap model) {

       /* if (result.hasErrors()) {
            return "employee";
        }*/

        model.addAttribute("success", "Dear " + employee.getFirstName()
                + " , your profile completed successfully");
        return "success";
    }

    @RequestMapping(method = RequestMethod.POST,
            path = "/submitjson",
            //consumes = {"application/json;charset=UTF-8"},/** 客户端提交的数据类型 */
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}/** 返回值类型 */
    )
    public String saveProfile1(@RequestParam String name,@RequestBody @Valid Employee employee) {
        /*@RequestBody Employee employee*/
       /* if (result.hasErrors()) {
            return "employee";
        }*/

        System.out.println(name+ employee);
        return "success";
    }

    /*
     * 用于给 Model 设置域对象
     * Method used to populate the country list in view.
     */
    @ModelAttribute("countries")
    public List<String> initializeCountries() {

        List<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("France");
        countries.add("Indonesia");
        countries.add("Australia");
        countries.add("Other");
        return countries;
    }

    @RequestMapping(path = "vaild")
    @ResponseBody
    public String valid(@RequestParam @Valid @Min(10) @Max(20) int helloDto) {
        System.out.println(helloDto);
        return "ok";
    }
}
