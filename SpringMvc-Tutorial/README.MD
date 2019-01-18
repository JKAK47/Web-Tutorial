# 基于SpringMc + Spring+ Mybatis 实现的 web 项目 
## tomcat apache-tomcat-8.0.53
- Mybatis 3.4.4
- tomcat 8.x 版本 servlet 3.1 JSP 2.3, EL 3.0
- Spring 5.1.3.RELEASE
## 基于SpringMvc 最小配置
包括Servlet 3.1 相关API jar包，Spring 家族basic jar包，Spring web 相关的jar 包，mybatis mysql 相关的jar 包 
### 第一步： pom.xml 声明需要使用的jar 
在该pom 中所有需要的 jar 包的版本，以及插件的版本 都在父Pom里面管理，这里只需要声明需要使用那些构件即可。

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

    <artifactId>SpringMvc-Tutorial</artifactId>
    <packaging>war</packaging>

    <name>基于SpringMvc 实现的web项目</name>
    <!-- FIXME change it to the project's website -->
    <url>http://www.example.com</url>
    <developers>
        <developer>
            <id>dsaff</id>
            <name>PengRong</name>
            <email>1557862201@qq.com</email>
        </developer>
    </developers>

    <properties>
      <tomcat.basedir>D:\Dev\tomcat\apache-tomcat-8.0.53</tomcat.basedir>
    </properties>

    <dependencies>
        <!-- unit test begin-->
        <!-- junit begin -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
        </dependency>
        <dependency>
            <groupId>org.hamcrest</groupId>
            <artifactId>hamcrest-core</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
        </dependency>
        <!-- junit stop  -->
        <!-- unit test stop -->

        <!-- Servlet3.1 begin tomcat8.0.x -->
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

        <!-- SpringMVC Begin -->
        <!-- SpringMVC  -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
        </dependency>
        <!-- spring-web -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
        </dependency>
        <!-- SpringMVC stop -->

        <!-- Spring basic lib begin -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jcl</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-expression</artifactId>
        </dependency>
        <!-- Spring basic lib end -->
        <!-- common lib begin-->
        <dependency>
            <groupId>commons-logging</groupId>
            <artifactId>commons-logging</artifactId>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
        <dependency>
            <groupId>org.apache.commons</groupId>
            <artifactId>commons-lang3</artifactId>
        </dependency>
    </dependencies>

    <build>
        <finalName>springmvc-tutorial</finalName>
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
            <!--自动部署 -->
            <plugin>
                <groupId>org.codehaus.cargo</groupId>
                <artifactId>cargo-maven2-plugin</artifactId>
                <configuration>
                    <container>
                        <!-- 指明使用的tomcat服务器版本 -->
                        <containerId>tomcat8x</containerId>
                        <!--指明tomcat服务器的安装目录 -->
                        <home>${tomcat.basedir}</home>
                    </container>
                    <configuration>
                        <type>existing</type>
                        <!--指明tomcat服务器的安装目录 -->
                        <home>${tomcat.basedir}</home>
                    </configuration>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

```
### web.xml web项目部署描述文件
在 `src/main/webapp/WEB-INF/web.xml`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!-- 该web  项目基于   servlet 3.1 JSP 2.3, EL 3.0，jstl 1.2
    web.xml中配置的执行顺序：
    listener>filter>servlet，而同一种配置片段则按照从上到下的顺序执行。
 -->

<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1" xmlns="http://xmlns.jcp.org/xml/ns/javaee">
    <display-name>Archetype Created Web Application</display-name>
    <welcome-file-list>
        <!-- 定义默认url 访问 的首页。安装文件名在webapp目录下 一个一个寻找直到找到同名的文件。  -->
        <welcome-file>index.html</welcome-file>
        <welcome-file>index.htm</welcome-file>
        <welcome-file>index.jsp</welcome-file>
        <welcome-file>default.html</welcome-file>
        <welcome-file>default.htm</welcome-file>
        <welcome-file>default.jsp</welcome-file>
    </welcome-file-list>

    <description>SpringMVC XXX</description>
    <!-- Spring MVC 前端控制器  Begin -->
    <servlet>
        <!-- Servlet 的名称 -->
        <servlet-name>springmvc</servlet-name>
        <!--Servlet 对应的实现类，当前使用SpringMVC 框架提供的前端控制器  -->
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <!--   当前Servlet参数设置，参数值为SpringMVC配置文件路径，
        如果这一步注释掉，则默认前端控制器的Spring-mvc 在WEB-INF目录下寻找映射文件，寻找路径为：/WEB-INF/[servlet-name]-servlet.xml ；
        或者在 main/resources/springmvc-servlet.xml: 写成 classpath:springmvc-servlet.xml
         -->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/springmvc-servlet.xml</param-value>
        </init-param>
        <!-- web 应用启动时候立即加载 Servlet -->
        <load-on-startup>1</load-on-startup>
    </servlet>

    <!-- Servlet 映射声明 -->
    <servlet-mapping>
        <!-- 这里的名字要和上面的servlet-name 一致.
         让SpringMVC 的前端控制器拦截所有请求。
        -->
        <!-- 请求对应的Servlet 名称 -->
        <servlet-name>springmvc</servlet-name>
        <!-- / 表示将当前所有的 URL映射到这个Servlet。 -->
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    <!-- Spring MVC 前端控制器  stop -->

    <!-- SpringMVC 统一编码过滤器配置 开始 -->

    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <!--要使用的字符集，一般我们使用UTF-8()-->
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
        <init-param>
            <!--是否强制设置request的编码为encoding，默认false，不建议更改-->
            <param-name>forceRequestEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
        <init-param>
            <!--是否强制设置response的编码为encoding，建议设置为true，下面有关于这个参数的解释-->
            <param-name>forceResponseEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <!-- url-pattern配置为/*表示拦截客户端浏览器所有的请求；
    其中在web容器启动的时候会调用CharacterEncodingFilter来实现将init-param中配置的参数记载进来
    -->
    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    <!-- SpringMVC 统一编码配置 结束 -->
</web-app>

```
[Maven(4)-利用intellij idea创建maven 多模块项目](http://www.cnblogs.com/Brake/p/create_maven_multi_module_project_via_intellij_idea.html)