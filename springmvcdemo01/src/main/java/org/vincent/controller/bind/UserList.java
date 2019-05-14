package org.vincent.controller.bind;

import org.vincent.pojo.User;

import java.util.List;

/**
 * @author PengRong
 * @package org.vincent.controller.bind
 * @ClassName UserList.java
 * @date 2019/5/15 - 0:14
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class UserList {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
