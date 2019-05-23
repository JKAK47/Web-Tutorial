package org.vincent.custbind;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author PengRong
 * @package org.vincent.custbind
 * @ClassName MyConverter.java
 * @date 2019/5/23 - 8:02
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class MyConverter implements Converter<String,Date> {

    @Override
    public Date convert(String source) {

        try {
            SimpleDateFormat simpleDateFormat =new SimpleDateFormat("MM-dd-yyyy");
            simpleDateFormat.setLenient(false);
            return  simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
