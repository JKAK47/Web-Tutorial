package org.vincent.servlet.tutorial.session;

import org.vincent.servlet.tutorial.session.bean.Book;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author PengRong
 * @package org.vincent.servlet.tutorial.session
 * @date 2019/3/7 - 0:44
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class DB {
    private static Map<String, Book> map = new LinkedHashMap<String, Book>();

    static {
        map.put("1", new Book("1", "javaweb开发"));
        map.put("2", new Book("2", "spring开发"));
        map.put("3", new Book("3", "hibernate开发"));
        map.put("4", new Book("4", "struts开发"));
        map.put("5", new Book("5", "ajax开发"));
    }

    public static Map<String, Book> getAll() {
        return map;
    }
}
