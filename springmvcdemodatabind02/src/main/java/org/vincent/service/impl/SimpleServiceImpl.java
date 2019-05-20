package org.vincent.service.impl;

import org.springframework.stereotype.Service;
import org.vincent.service.SimpleService;

/**
 * @author PengRong
 * @package org.vincent.service.impl
 * @ClassName SimpleServiceImpl.java
 * @date 2019/5/21 - 0:08
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
@Service
public class SimpleServiceImpl implements SimpleService {
    @Override
    public String simpleMethod(String firstName, int age) {
        System.out.println(firstName + age);
        return "success";
    }
}
