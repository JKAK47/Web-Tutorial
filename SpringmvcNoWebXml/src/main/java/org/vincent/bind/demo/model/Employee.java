package org.vincent.bind.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author PengRong
 * @package org.vincent.bind.demo.model
 * @ClassName Employee.java
 * @date 2019/5/27 - 0:02
 * @ProjectName Web-Tutorial
 * @Description: 表单数据校验 Bean
 */
public class Employee implements Serializable{

    @Size(min=3, max=25,message = "字符串长度超过了区间【3,25】")
    private String firstName;

    @Size(min=4, max=25,message = "字符串长度超过了区间[ 4,25]")
    private String lastName;

    @NotEmpty
    private String sex;

    @DateTimeFormat(pattern="yyyy-MM-dd") /** 设置传进来的时间字符串 格式 */
    @Past(message = "时间必须是以前的一个日期 ")
    @NotNull(message = "不能为空")
    private Date birthDay;

    @Email(message = "不是一个合法的电子邮件 pr ")
    @NotEmpty
    private String email;

    @NotEmpty
    private String country;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
