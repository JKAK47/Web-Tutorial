package org.vincent.pojo;

import java.io.Serializable;

/**
 * @author PengRong
 * @package org.vincent.pojo
 * @ClassName Book.java
 * @date 2019/5/22 - 8:07
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class Book implements Serializable {
    private long id;
    private String isbn;
    private String title;
    private String author;
    private Category category;
    public Book(){

    }
    public Book(long id, String isbn, String title,
                Category category, String author) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.category = category;
        this.author = author;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category=" + category +
                '}';
    }
}
