package org.vincent;

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
        users.add(new User());
        users.add(new User());
        users.add(new User());
    }
}
