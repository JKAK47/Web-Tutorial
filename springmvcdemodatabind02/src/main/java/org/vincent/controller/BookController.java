package org.vincent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.vincent.pojo.Book;
import org.vincent.pojo.Category;
import org.vincent.service.BookService;

import java.util.List;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName BookController.java
 * @date 2019/5/22 - 8:10
 * @ProjectName Web-Tutorial
 * @Description: 创建新书目，更新书目信息，列出所有书目信息，
 * 这个类主要的绑定类型是 将模型数据绑定到域对象中
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping(value = "/book_input")
    public String inputBook(Model model) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("book", new Book());
        return "BookAddForm";
    }
    @RequestMapping(value = "/book_edit/{id}")
    public String editBook(Model model, @PathVariable long id) {
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        Book book = bookService.get(id);
        model.addAttribute("book", book);
        return "BookEditForm";
    }

    @RequestMapping(value = "/book_save")
    public String saveBook(@RequestBody Book book) {
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.save(book);
        return "redirect:/book_list";
    }

    @RequestMapping(value = "/book_update")
    public String updateBook(@RequestBody Book book) {
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);
        bookService.update(book);
        return "redirect:/book_list";
    }

    @RequestMapping(value = "/book_list")
    public String listBooks(Model model) {
        System.out.println("book_list");
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "BookList";
    }

}
