package org.vincent.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author PengRong
 * @package org.vincent.pojo
 * @ClassName Employee.java
 * @date 2019/5/23 - 8:06
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class Employee implements Serializable{
    private static final long serialVersionUID = -908L;

    private long id;
    private String name;
    private Date birthDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

}
