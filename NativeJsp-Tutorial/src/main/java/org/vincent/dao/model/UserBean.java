package org.vincent.dao.model;

import java.util.Arrays;

/**
 * @author PengRong
 * @package org.vincent.dao.model
 * @date 2019/1/21 - 7:55
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class UserBean {
    private String account;

    private String name;

    private String gender;

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setInterest(String[] interest) {
        this.interest = interest;
    }
    private String[] interest;

    public String getInterest() {
        return Arrays.toString(interest);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    private  String msg;

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", interest=" + Arrays.toString(interest) +
                ", msg='" + msg + '\'' +
                '}';
    }
}
