# 验证 url-pattern 匹配规则案例

- 精确匹配
- 路径匹配 (`/*` 结尾的)
- 扩展名匹配(以`*.`开始的)
- 默认匹配(`/`)

tomcat 启动时候会读取web.xml文件创建 一个匹配规则链，按照匹配顺序是：

精确匹配 -> 路劲匹配 -> 扩展名匹配(`*.jsp,*.jspx`)  -> 默认匹配`/`

`/*`的优先级比`*.jsp`高, `*.jsp`的优先级比`/`高。
 
只有匹配成功一个就不在匹配后面的了。

例子很简单直接看源码即可。


发现一个问题是：关于路劲匹配死循环的问题
```xml
 <servlet>
        <servlet-name>ExactServlet</servlet-name>
        <servlet-class>org.vincent.servlet.ExactServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>ExactServlet</servlet-name>
        <url-pattern>/vincent/exact.do</url-pattern>
    </servlet-mapping>
  <!-- 路径匹配
     /vincent/* 陷入死循环
     /vincent/ab/* 也会陷入死循环
     -->
   <!-- <servlet>
        <servlet-name>wildcardServlet</servlet-name>
        <servlet-class>org.vincent.servlet.TestAllServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>wildcardServlet</servlet-name>
        <url-pattern>/vincent/ab/*</url-pattern>
    </servlet-mapping>-->
```

`<url-pattern>/vincent/*</url-pattern>` 对于这个的规则造成循环调用org.vincent.servlet.TestAllServlet 类，
但是我开始以为是和配置的精确匹配ExactServlet冲突了 ，然后我在加了路径前缀 `  <url-pattern>/vincent/ab/*</url-pattern>` 触发TestAllServlet访问还是
一直死循环。不知道什么问题。