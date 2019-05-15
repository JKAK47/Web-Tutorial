package org.vincent.controller.bind;

import org.vincent.pojo.User;

import java.util.Map;

/**
 * @author PengRong
 * @package org.vincent.controller.bind
 * @ClassName UserMap.java
 * @date 2019/5/16 - 0:33
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class UserMap {
    private Map<String,User> userMap;

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }
}
