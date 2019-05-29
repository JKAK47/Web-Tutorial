package org.vincent.controller;

import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.vincent.bind.demo.model.Employee;
import org.vincent.bind.demo.model.HelloDto;

import javax.validation.Valid;
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
public class BindController {

    @RequestMapping(path = "/new",method = RequestMethod.GET)
    public String newProfile(ModelMap model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee";
    }
    @RequestMapping(method = RequestMethod.POST,path = "submit")
    public String saveProfile(@Valid Employee employee,
                              BindingResult result, ModelMap model) {

        if (result.hasErrors()) {
            return "employee";
        }

        model.addAttribute("success", "Dear " + employee.getFirstName()
                + " , your profile completed successfully");
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
    public String valid(@RequestBody @Valid HelloDto helloDto){

        return  "ok";
    }
}
