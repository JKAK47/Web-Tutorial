package org.vincent.pojo;

import java.io.Serializable;

/**
 * @author PengRong
 * @package org.vincent.pojo
 * @ClassName User.java
 * @date 2019/5/13 - 23:36
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class User implements Serializable{
    private int id;
    private String name;
    private Address address;

    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
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
        return "User [id=" + id + ", name=" + name + ", address=" + address
                + "]";
    }
}
