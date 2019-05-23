package org.vincent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vincent.pojo.Employee;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName DataConverterController.java
 * @date 2019/5/19 - 16:28
 * @ProjectName Web-Tutorial
 * @Description: 自定义数据转换器  实现 将http 所有string类型参数转成指定javaBean指定类型参数
 */
@Controller
public class DataConverterController {

    @RequestMapping(value="employee_input")
    public String inputEmployee( ) {
        return "EmployeeForm";
    }
    @RequestMapping(value="employee_save",method = RequestMethod.POST)
    @ResponseBody
    public String saveEmployee(@RequestBody Employee employee ) {
        System.out.println(employee);

        // save employee here

        return "EmployeeDetails";
    }
}
