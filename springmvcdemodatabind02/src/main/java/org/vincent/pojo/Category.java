package org.vincent.pojo;

import java.io.Serializable;

/**
 * @author PengRong
 * @package org.vincent.pojo
 * @ClassName Category.java
 * @date 2019/5/22 - 8:09
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class Category implements Serializable{
    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category() {

    }

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
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
