package org.vincent.config.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author PengRong
 * @package org.vincent.config.web
 * @ClassName CustomDateConverter.java
 * @date 2019/6/8 - 14:19
 * @ProjectName Web-Tutorial
 * @Description: 用于web接受HTTP 日期字符串转成 Date 类型数据转换器
 */
@Slf4j
public class CustomDateConverter implements Formatter<Date> {
    /**
     * 传递过来的日期字符串格式
     */
    private String datePattern;

    public void setDateParttern(String datePattern) {
        this.datePattern = datePattern;
    }

    /**
     * 转换日期格式字符串数据 text 为Date 类型数据
     *
     * @param text
     * @return
     */
    @Override
    public Date parse(String text, Locale locale) throws ParseException {
        log.info("begin convert  source str = " + text);
        SimpleDateFormat dateFormat = new SimpleDateFormat(this.datePattern);
        try {
            Date date = dateFormat.parse(text);
            return date;
        } catch (ParseException e) {
            log.error("convertError", e);
        }
        return null;
    }

    @Override
    public String print(Date object, Locale locale) {
      log.info(object.toString());
      log.info(locale.toString());
      return null;
    }
}
