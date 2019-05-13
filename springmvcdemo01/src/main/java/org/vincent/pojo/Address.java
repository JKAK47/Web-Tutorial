package org.vincent.pojo;

import java.io.Serializable;

/**
 * @author PengRong
 * @package org.vincent.pojo
 * @ClassName Address.java
 * @date 2019/5/13 - 23:35
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class Address implements Serializable{
    private int id;
    private String name;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Address [id=" + id + ", name=" + name + "]";
    }
}
