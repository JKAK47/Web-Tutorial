package org.vincent.common;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author PengRong
 * @package org.vincent.common
 * @ClassName CommonUtils.java
 * @date 2019/6/15 - 13:58
 * @ProjectName Web-Tutorial
 * @Description: TODO
 */
public class CommonUtils {
    /**
     * 根据一个文件全路径获取到该文件的ContentType
     *
     * @param fileName 文件全路径
     * @return
     */
    public static String getContentType(String fileName) throws IOException {
        String contentType = Files.probeContentType(Paths.get(fileName));
        return contentType;
    }


    /*public static void main(String[] args) throws IOException {
        String contentType = getContentType("D:\\Dev\\WorkStation\\HBuilder\\JavaScript-in-Action\\index.html");
        System.out.println(contentType);
    }*/
}
