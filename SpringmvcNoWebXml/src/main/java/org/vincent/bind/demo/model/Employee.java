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

    @Size(min=3, max=25)
    private String firstName;

    @Size(min=3, max=25)
    private String lastName;

    @NotEmpty
    private String sex;

    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Past
    @NotNull
    private Date birthDay;

    @Email
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
