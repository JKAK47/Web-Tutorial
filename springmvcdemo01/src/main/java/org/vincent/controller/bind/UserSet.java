package org.vincent.controller.bind;

import org.vincent.pojo.User;

import java.util.HashSet;
import java.util.Set;

/**
 * @Package org.vincent
 * @ClassName UserSet.java
 * @date 2019/5/15 - 13:07
 * @description :
 * Created by PengRong .
 */
public class UserSet {
    private Set<User> users = new HashSet<User>();

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public UserSet(){
        /** 这里需要定义表单有多少个 User，然后初始化多少个User，不能缺一个都不行
         * 这不是坑嘛
         * */
        users.add(new User());
        users.add(new User());
        users.add(new User());
    }
}
