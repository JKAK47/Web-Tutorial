# 父POM.XML 所有jar包管理以及插件管理声明但不使用
具体工程构建在每个子项目下的README.md 文件有详细说明
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.vincent</groupId>
    <artifactId>Web-Tutorial</artifactId>
    <packaging>pom</packaging>
    <version>${project.build.version}</version>
    <name>web 所有经典的项目类型案例</name>
    <!-- 共用的属性  -->
    <properties>
        <project.build.version>1.0-SNAPSHOT</project.build.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
        <spring.version>5.1.3.RELEASE</spring.version>
        <mybatis.version>3.4.4</mybatis.version>
        <mybatis.spring.version>1.3.0</mybatis.spring.version>
        <mysql.driver.version>6.0.4</mysql.driver.version>
        <druid.version>1.1.10</druid.version>
    </properties>
    <!-- 父级pom里面管理所有组件依赖，其他module 按需 声明使用即可 -->
    <dependencyManagement>
        <dependencies>
            <!-- test unit begin -->
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>4.12</version>
                <scope>test</scope>
                <exclusions>
                    <exclusion>
                        <groupId>org.hamcrest</groupId>
                        <artifactId>hamcrest-core</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
            <dependency>
                <groupId>org.hamcrest</groupId>
                <artifactId>hamcrest-core</artifactId>
                <version>1.3</version>
                <scope>test</scope>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-test</artifactId>
                <scope>test</scope>
                <version>${spring.version}</version>
            </dependency>
            <!-- test unit end -->

            <!-- spring basic lib begin  no web -->
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-jcl</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-beans</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-core</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-context</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-context-support</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-aop</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-aspects</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-expression</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-instrument</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-jms</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-messaging</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-orm</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <!-- Spring Object <> XML 之间映射-->
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-oxm</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <!-- JDBC + tx 事务 -->
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-jdbc</artifactId>
                <version>${spring.version}</version>
                <exclusions>
                    <exclusion>
                        <groupId>org.springframework</groupId>
                        <artifactId>spring-tx</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-tx</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <!-- spring basic lib stop -->

            <!-- mybatis + mysql lib begin-->
            <!-- MyBatis Dependency & mybatis integer spring Begin -->
            <dependency>
                <groupId>org.mybatis</groupId>
                <artifactId>mybatis</artifactId>
                <version>${mybatis.version}</version>
            </dependency>
            <dependency>
                <groupId>org.mybatis</groupId>
                <artifactId>mybatis-spring</artifactId>
                <version>${mybatis.spring.version}</version>
            </dependency>
            <!-- https://mvnrepository.com/artifact/com.alibaba/druid  数据库连接池 -->
            <dependency>
                <groupId>com.alibaba</groupId>
                <artifactId>druid</artifactId>
                <version>${druid.version}</version>
            </dependency>
            <!-- MyBatis Dependency End -->
            <!-- 导入Mysql数据库链接jar包
                mysql 6+ 以上版本classDriver ：com.mysql.cj.jdbc.Driver
                原来是：com.mysql.jdbc.Driver
             -->
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>${mysql.driver.version}</version>
                <!-- runntime表示被依赖项目无需参与项目的编译，不过后期的测试和运行周期需要其参与，比如各个数据库驱动，不需要参与编译，只要执行时候注入进去即可 -->
                <scope>runtime</scope>
            </dependency>
            <!-- 导入Mysql数据库链接jar包 End -->
            <!-- mybatis  + mysql lib stop -->




            <!-- SpringMVC Begin -->
            <!-- SpringMVC  -->
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-webmvc</artifactId>
                <version>${spring.version}</version>
                <exclusions>
                    <exclusion>
                        <groupId>org.springframework</groupId>
                        <artifactId>spring-core</artifactId>
                    </exclusion>
                    <exclusion>
                        <groupId>org.springframework</groupId>
                        <artifactId>spring-beans</artifactId>
                    </exclusion>
                    <exclusion>
                        <groupId>org.springframework</groupId>
                        <artifactId>spring-aop</artifactId>
                    </exclusion>
                    <exclusion>
                        <groupId>org.springframework</groupId>
                        <artifactId>spring-web</artifactId>
                    </exclusion>
                    <exclusion>
                        <groupId>org.springframework</groupId>
                        <artifactId>spring-context</artifactId>
                    </exclusion>
                    <exclusion>
                        <groupId>org.springframework</groupId>
                        <artifactId>spring-expression</artifactId>
                    </exclusion>
                </exclusions>
            </dependency>
            <!-- spring-web -->
            <dependency>
                <groupId>org.springframework</groupId>
                <artifactId>spring-web</artifactId>
                <version>${spring.version}</version>
            </dependency>
            <!-- SpringMVC stop -->

            <!-- Servlet3.0 begin ,servlet3.0
           使用 tomcat 7.x/Java EE 6  版本 === >> Servlet 3.0 , JSP 2.2, EL 2.2 , WebSocket 1.1 Spec.
             对应的web.xml 文件头scheme 不一致。
          runtime  -->
            <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>javax.servlet-api</artifactId>
                <version>3.0.1</version>
                <!--provided意味着打包的时候可以不用包进去, JDK或者运行时候容器提供了该包  -->
                <scope>provided</scope>
            </dependency>
            <dependency>
                <groupId>javax.servlet.jsp</groupId>
                <artifactId>jsp-api</artifactId>
                <version>2.2</version>
                <scope>provided</scope>
            </dependency>
            <dependency>
                <groupId>javax.el</groupId>
                <artifactId>el-api</artifactId>
                <version>2.2</version>
                <scope>provided</scope>
            </dependency>
            <!-- JSTL begin -->
            <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>jstl</artifactId>
                <version>1.2</version>
            </dependency>
            <!-- JSTL stop -->
            <!-- 导入java ee jar 包
                这个包是什么功能的? 不用引用也是可以的，web 应用还是可以起来的。
                如果你添加进来必须引用 7.0 版本
             -->
            <!-- <dependency>
                 <groupId>javax</groupId>
                 <artifactId>javaee-api</artifactId>
                 <version>7.0</version>
             </dependency>-->
            <!-- 导入java ee jar 包 -->
            <dependency>
                <groupId>taglibs</groupId>
                <artifactId>standard</artifactId>
                <version>1.1.2</version>
            </dependency>
            <!-- Servlet3 end -->

            <!-- Servlet3.1 begin
                tomcat 8.x 版本 servlet 3.1 JSP 2.3, EL 3.0,
                对应的web.xml 文件头scheme 不一致。
            -->
            <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>javax.servlet-api</artifactId>
                <version>3.1.0</version>
                <scope>provided</scope>
            </dependency>
            <dependency>
                <groupId>javax.servlet.jsp</groupId>
                <artifactId>javax.servlet.jsp-api</artifactId>
                <version>2.3.0</version>
                <scope>provided</scope>
            </dependency>
            <dependency>
                <groupId>javax.el</groupId>
                <artifactId>javax.el-api</artifactId>
                <version>3.0.0</version>
                <scope>provided</scope>
            </dependency>
            <dependency>
                <groupId>javax.servlet</groupId>
                <artifactId>jstl</artifactId>
                <version>1.2</version>
            </dependency>

            <!-- Servlet3.1 end -->

            <!-- json lib -->

            <!-- common lib begin-->
            <dependency>
                <groupId>commons-logging</groupId>
                <artifactId>commons-logging</artifactId>
                <version>1.2</version>
            </dependency>
            <!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
            <dependency>
                <groupId>org.apache.commons</groupId>
                <artifactId>commons-lang3</artifactId>
                <version>3.8.1</version>
            </dependency>

            <!-- common lib stop -->
        </dependencies>
    </dependencyManagement>

    <build>
        <finalName>web-tutorial</finalName>
        <pluginManagement>
            <plugins>
                <!-- 项目范围级别 compiler 全局配置
                               compiler:compile 目标将去编译java代码以及main/resources目录下的资源文件
                           -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.7.0</version>
                    <configuration>
                        <encoding>UTF-8</encoding>
                        <!-- 声明代码使用什么JDK 版本进行编译 -->
                        <source>${maven.compiler.source}</source>
                        <!-- 声明编译后的代码将运行在哪个JDK版本 -->
                        <target>${maven.compiler.target}</target>
                        <!-- 设置编译插件在编译期间使用的JDK版本 -->
                        <fork>true</fork> <!-- fork = true 让compilerVersion 属性生效。
                        compilerVersion 属性设置编译器使用的jdk版本 executable 设置使用的jdk路径
                    -->
                        <compilerVersion>${maven.compiler.source}</compilerVersion>
                        <!--<executable>${JAVA8_HOME}/bin/javac</executable>-->
                        <!-- 从 3.0后的编译插件，maven默认使用的编译器 是 javax.tools.JavaCompiler
                            如果你想强制让这个插件使用javac 设置属性 forceJavacCompilerUse =true 即可。
                         -->
                        <forceJavacCompilerUse>true</forceJavacCompilerUse>
                    </configuration>
                </plugin>
                <!--
                            maven 项目构建生成 eclipse java web 项目相关的工程配置文件
                            Eclipse project
                              那个组件需要生产eclipse相关的web 工程配置文件即可使用这个插件
                             -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-eclipse-plugin</artifactId>
                    <version>2.9</version>
                    <configuration>
                        <!-- Always download and attach dependencies source code -->
                        <downloadSources>true</downloadSources>
                        <downloadJavadocs>false</downloadJavadocs>
                        <!-- Avoid type mvn eclipse:eclipse -Dwtpversion=2.0 为了避免设置参数   Dwtpversion -->
                        <wtpversion>2.0</wtpversion>
                    </configuration>
                </plugin>
                <!-- 配置一个产生源码 jar 包的 插件，绑定到verify 阶段执行这个目标 -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-source-plugin</artifactId>
                    <version>3.0.1</version>
                    <!-- 这里是插件全局配置 -->
                    <configuration>
                        <attach>true</attach>
                        <!-- 配置是否将配置文件去除（true）,false 不去除 -->
                        <excludeResources>false</excludeResources>
                    </configuration>
                    <executions>
                        <execution>
                            <id>attach-source</id>
                            <phase>verify</phase>
                            <goals>
                                <goal>jar-no-fork</goal>
                            </goals>
                            <!-- 插件任务配置 -->
                            <configuration>
                            </configuration>
                        </execution>
                    </executions>
                </plugin>
                <!-- 配置打包过程中跳过测试插件， -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>2.19.1</version>
                    <configuration>
                        <skip>true</skip>
                    </configuration>
                </plugin>
                <!-- 声明使用UTF-8编码去处理资源文件 -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-resources-plugin</artifactId>
                    <version>3.1.0</version>
                    <configuration>
                        <encoding>UTF-8</encoding>
                    </configuration>
                </plugin>
                <!-- clean 清理周期插件
                        并将清理命令绑定到 打包周期的initialize阶段
                        mvn package和 mvn clean package就是等价的
                  -->
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-clean-plugin</artifactId>
                    <version>3.0.0</version>
                    <!-- 配置 clean 失败后是否还能继续执行其他命令
                        failOnError = false  忽略错误继续执行
                        failOnError = true  报错不继续执行
                      -->
                    <configuration>
                        <failOnError>true</failOnError>
                    </configuration>
                    <!--绑定clean 到打包周期的 initialize 阶段 -->
                    <executions>
                        <execution>
                            <id>auto-clean</id>
                            <phase>initialize</phase>
                            <goals>
                                <goal>clean</goal>
                            </goals>
                        </execution>
                    </executions>
                </plugin>
                <!--
               第二种方法
               cargo-maven2-plugin 插件可以使用本地安装的tomcat版本也可以进行 tomcat启动
           -->
                <plugin>
                    <groupId>org.codehaus.cargo</groupId>
                    <artifactId>cargo-maven2-plugin</artifactId>
                    <version>1.2.3</version>
                   <!-- <configuration>
                        <container>
                            &lt;!&ndash; 指明使用的tomcat服务器版本 &ndash;&gt;
                            <containerId>tomcat7x</containerId>
                            &lt;!&ndash;指明tomcat服务器的安装目录 &ndash;&gt;
                            <home>${tomcat.basedir}</home>
                        </container>
                        <configuration>
                            <type>existing</type>
                            &lt;!&ndash;指明tomcat服务器的安装目录 &ndash;&gt;
                            <home>${tomcat.basedir}</home>
                        </configuration>
                    </configuration>-->
                    <executions>
                        <execution>
                            <id>cargo-run</id>
                            <phase>install</phase>
                            <goals>
                                <goal>run</goal>
                            </goals>
                        </execution>
                    </executions>
                </plugin>

            </plugins>
        </pluginManagement>
    </build>

    <modules>
        <module>SpringMvc-Tutorial</module>
        <module>Struts2-Tutorial</module>
        <module>NativeJsp-Tutorial</module>
    </modules>


</project>
```