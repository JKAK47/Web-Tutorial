package org.vincent.servlet.tutorial.session.bean;

/**
 * @author PengRong
 * @package org.vincent.servlet.tutorial.session.bean
 * @date 2019/3/7 - 0:42
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class Book {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Book(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
