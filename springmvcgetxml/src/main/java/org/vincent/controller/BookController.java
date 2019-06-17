package org.vincent.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.vincent.domain.Book;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

/**
 * @author PengRong
 * @package org.vincent.controller
 * @ClassName BookController.java
 * @date 2019/6/15 - 15:57
 * @ProjectName Web-Tutorial
 * @Description: 基于XML 数据和 JavaBean 自动收发
 */
@Slf4j
@Controller
public class BookController {

    /**
     * 将 前端提交的XML 数据字符串 提交并转换为JavaBean 对象
     * @param book
     */

    // @RequestBody Book book会将传递的xml数据自动绑定到Book对象
    @RequestMapping(value = "/sendxml", method = RequestMethod.POST,produces = MediaType.TEXT_PLAIN_VALUE+";charset=UTF-8")
    @ResponseBody
    public String sendxml(@RequestBody Book book) {
        log.info(book.toString());
        return "接收XML数据成功";
    }

    /**
     * 将输出对象以 XML 形式序列化 输出
     * @return
     * @throws Exception
     */
    // @ResponseBody 会将Book自动转成XML数据返回
    @RequestMapping(value = "/readxml", method = RequestMethod.POST,produces = MediaType.APPLICATION_XHTML_XML_VALUE)
    @ResponseBody
    public Book readXml() throws Exception {
        // 通过JAXBContext的newInstance方法，传递一个class就可以获得一个上下文
        JAXBContext context = JAXBContext.newInstance(Book.class);
        // 创建一个Unmarshall对象
        Unmarshaller unmar = context.createUnmarshaller();
        InputStream is = this.getClass().getResourceAsStream("/book.xml");
        // Unmarshall对象的unmarshal方法可以进行xml到Java对象的转换
        Book book = (Book) unmar.unmarshal(is);
        log.info(book.toString());
        return book;
    }
}
