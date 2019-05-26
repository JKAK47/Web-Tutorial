[toc]

# 基于Servlet 3.1 实现 无 web.xml 文件，基于注解 部署javaWeb 项目
自从servlet3.0之后给我们提供了注解@WebServlet和@WebInitParam，@WebServlet是用来配置servlet的属性的，@WebInitParam是用来配置一些初始化属性的。
```
@WebServlet(name = "asdf",urlPatterns = {"/sdf","/sdf"}, loadOnStartup = 0,
        initParams = {
        @WebInitParam(name = "key1",value = "asdfasd"),
        @WebInitParam(name = "key2",value = "sdfas")})
public class RegisterServlet extends HttpServlet {
```
# 案例
## Pom文件
```xml
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>Web-Tutorial</artifactId>
        <groupId>org.vincent</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>Nativeweb-NoWebxml</artifactId>
    <packaging>war</packaging>

    <name>基于Servlet 3.1 实现无 web.xml 文件javaweb 项目构建</name>
    <!-- FIXME change it to the project's website -->
    <url>http://www.example.com</url>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <dependencies>
        <!-- Servlet3.1 begin tomcat8.0.x
        servlet 3.1 JSP 2.3, EL 3.0
        -->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>javax.servlet.jsp-api</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.el</groupId>
            <artifactId>javax.el-api</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
        </dependency>
        <!-- Servlet3.1 end -->
    </dependencies>

    <build>
        <finalName>Nativeweb-NoWebxml</finalName>

        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-clean-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-resources-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
            </plugin>
            <!--  使用 maven-war-plugin 插件 申明如果确实web.xml 文件也不要构建失败，因为这个案例实现没有web.xml 部署构建文件的 javaweb 案例
                该插件如果不配置将报错
              -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.2.2</version>
                <configuration>
                    <!-- <warSourceDirectory>/src/main/webapp</warSourceDirectory>-->
                    <failOnMissingWebXml>false</failOnMissingWebXml> <!-- 申明不要 web.xml 文件， 也可以不配置，默认值是false  -->
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

```
## 注解 WebServlet

```
package org.vincent.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Objects;

/**
 * @author PengRong
 * @package org.vincent.servlet
 * @ClassName JsonDataServletDo.java
 * @date 2019/5/25 - 11:47
 * @ProjectName Web-Tutorial
 * @Description: 基于 注解，工程没有web.xml 文件 的java web 项目
 * 返回 json 数据
 */
@WebServlet(
        name = "jsonDataServlet",
        displayName = "JsonDataServlet",
        urlPatterns = "/jsondemo",
        initParams = {
                @WebInitParam(name = "key1", value = "asdfsd"),
                @WebInitParam(name = "key2", value = "wwwwww")},
        loadOnStartup = 1
)
public class JsonDataServletDo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置content-type消息头，告诉浏览器， 服务器返回的数据类型。

        //我这里是返回 json 类型
        resp.setContentType("application/json;charset=utf-8");

        //通过response对象获得输出流。
        PrintWriter out = resp.getWriter();

        /* 组装json 数据*/
        String json = "{\"firstName\": \"Json\",a: \"Hello\", b: \"World\"}";
        out.println(json);
        /** 获取servlet 注解注入的初始化参数 */
        json ="{\"InitParam key1\": \""+this.getServletConfig().getInitParameter("key1")+"\",InitParam key2: \""+this.getServletConfig().getInitParameter("key2");
        out.println(json);
        Enumeration<String> keys = req.getParameterNames();
        if (Objects.nonNull(keys)){
            while (keys.hasMoreElements()){
                String key =keys.nextElement();
                String value =req.getParameter(key);
                StringBuilder builder = new StringBuilder();
                builder.append("{\"");
                builder.append(key);
                builder.append("\": \"");
                builder.append(value);
                builder.append("\"}");
                out.println(builder.toString());
            }
        }
        /* 将json数据刷新到客户端浏览器 并关闭流*/
        out.flush();
        /** //如果没有调用out.close，则容器会自动 关闭out */
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

```


[servlet 3.0](https://www.cnblogs.com/stAr-1/p/7424270.html)
