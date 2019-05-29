package org.vincent.bind.demo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author PengRong
 * @package org.vincent.bind.demo.model
 * @ClassName HelloDto.java
 * @date 2019/5/28 - 22:08
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */

public class HelloDto implements Serializable{
    @NotEmpty(message = "name 不能为null")
    private String name;
    @Max(22)
    @Min(18)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
