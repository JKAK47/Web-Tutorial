# 基于元素 JSP文件实现web 应用 - 00

基于JSP 的web 应用中，jsp 就是主要写html 标签的sevlet类，jsp 页面在浏览器第一次访问时候，将被servlet容器编译成：`同名_jsp.java `类文件,名称构成是：`jsp文件名称_jsp.java` 
放置于 `tomcat安装目录\work\Catalina\localhost` 目录。

jsp 文件 在基于java web 应用就是前端页面范畴，他里面可以跳转到其他的jsp 页面。可以通过连接形式跳转到webapp下其他目录下的页面，但是`webapp/WEB-INF`目录除外。

这样实现页面jsp页面里面调转其他页面： `<button><a href="font/indextest.jsp">第一个jsp 页面 indextest.jsp</a></button>`

该案例只使用如下技术：
- Jsp 技术，定义页面显示块；定义超链接
- 并搭配 css 技术实现样式定义，美化页面，定义页面布局效果，
-  JavaScript技术，定义页面按钮行为

启动后访问`http://localhost:8088/nativejsp/font/indextest.jsp` 地址就能看到轮播图，样式定义，图片切换等效果

我并不是学习Jsp ，只是通过这个例子阐述在大前端，大后端情况下，jsp 这个历史特定时期下的产物的优缺点：

优点：
在以前写前端页面还是在servlet里面通过java 代码  `out.write("xx");` 写入html 标签文本时候，jsp 堪称一次生产力解放，

我们知道在当前情况下，没几个人会去学习jsp 的 标签，指令，在jsp 里面写前端代码，HTML js, css等代码，在当前情况下这成为了历史。现在更多的情况是 基于Vue，React，angular 等专用的前端框架
专业制作前端工程，这对我们开发者有什么好处呢？那就是在大前端情况下，前端工程化后，我们学习的前端技能是可迁移的，不用换了平台就不行了，技能需要重新学。

如果你用jsp 或者structs2，springmvc 等MVC框架提供的前端标签，你当然可以完成任务，但是你的技能是不能迁移的，你不能转型做 专业的前端开发。


# 所以我非常赞成专业的事情用专业的技术去完成，不应该让java 做前端的活，还在用jsp写前端并servlet容器去把这个jsp文件转成servlet 后 在java 代码里面 去组装生成前端html 流。

java 专业提供数据，高并发，高可用

前端页面用专业的前端工程来制作，

- HTML 标签定义页面骨架，页面布局
- CSS 定义页面显示样式，美化页面
- JavaScript 定义页面和用户交互逻辑，页面和后台交互的逻辑

整个前端只是做交互，渲染，数据可视化的工作。


在这个jsp 项目中遇到如下几个问题：


## `page-header.jsp` 页面中 超链接 访问servlet 时候遇到了问题, 调不到对应的servlet，后来发现是相对路径写错了。
正确是这样写：
```xml
 <li>
    <a href="../newsA?id=10&name=20">新闻</a>
</li>
```
为什么要这样写？ 
正常访问newsA这个servlet 的URL 是通过`http://localhost:8088/nativejsp/newsA?id=10&name=30`访问的，
而这个 jsp页面在 `webapp/font/page-header.jsp` 下，`http://localhost:8088/nativejsp/`代表 webapp 目录，即使项目根目录，所以在font目录下jsp的a标签，你要访问项目根目录下的servlet。
相对路径要不要上一级呢？

总结servlet 被调用方式：
- 最重要的一种，也是根本的一种就是在地址栏访问 比如定义了一个 映射到 `/newsA` 的servlet，你需要访问这个servlet ，
只能通过`http://localhost:8088/nativejsp/newsA?id=10&name=30`访问了，后面的url 参数可以加也可以不加，也可以再加参数。其中参数是传给servlet 的参数

- Jsp 里面调用，[分两种](https://blog.csdn.net/judyge/article/details/49701649)
    - JSP 表单提交，通过form提交，通过action 属性设置提交到那个servlet，但是也需要注意相对webapp的目录层级
    - Jsp [超链接提交](https://bbs.csdn.net/topics/390531027),如上面案例一样，但是需要注意jsp文档相对于webapp目录的相对目录层级。

- 通过 ajax 异步提交

## Servlet 已经可以调到，但是返回报错： [java.lang.IllegalStateException: Cannot forward after response has been committed](https://blog.csdn.net/ljheee/article/details/51049773)
这个错误的原因是 response多次提交或者是由于有页面显示后仍然含请求转向产生的，就是说程序在return之前就已经执行了跳转或者执行过 response。
我的问题是因为在doGet方法执行第一行 执行了 super.doGet(req, resp); 造成了调用父类的doGet方法。相当于在执行我写的代码前已经执行了forward一次。造成执行了两次


## Jsp 往servlet 提交数据
其实 jsp调用servlet 就可以提交参数给servlet

## Servlet 怎么传数据给Jsp 呢？

- 重定向 Redirect ，url 会改变，就是servlet接受一个jsp的请求，处理完后有重定向到另外一个jsp 去。浏览器里面显示的是重定向后的jsp 路径。
重定向通过`resp.sendRedirect("font/newsFrontList.jsp");`重定向，重定向只能获取servlet设置 session 级别的值才能再重定向到 jsp 里面拿到，request级别的值拿不到，
Servlet中设置session 级别值: NewsServlet.java
```java
req.getSession().setAttribute("news", news);
/** 重定向 浏览器有变化，但是接受不到servlet传递给他的数据 */
resp.sendRedirect("font/newsFrontList.jsp");
```
jsp页面取值：
```java
 List<News> totalNew = (List<News>) session.getAttribute("news");
```
- 转发 浏览器根据处理结果，然后转发到一个新的jsp里面去，在浏览器看来，它不知道服务器进行了转发；浏览器url 没有变化,但是页面内容用新的jsp替代了。
    但是转发操作，返回的jsp里面可以 获取 servlet设置 的request，session级别 的值。`req.getRequestDispatcher("font/newsFrontList.jsp").forward(req, resp);`
Servlet中设置 request 级别值: RegisterServlet.java
```java
req.setAttribute("USERLIST", userBean);
req.getRequestDispatcher("font/userlist.jsp").forward(req, resp);
```
jsp页面取值：
```java
 UserBean user = (UserBean) request.getAttribute("USERLIST");
``` 
   
[JSP和Servlet传递数据的几种方式](https://blog.csdn.net/qq_38006520/article/details/81567379)

[Servlet--转发和重定向](http://www.cnblogs.com/LinkinPark/p/5233006.html)

[jsp获取servlet中数据](https://blog.csdn.net/zyzn1425077119/article/details/50365134)

[jsp与servlet的页面跳转和数据的转发汇总](https://www.imooc.com/article/13179)

## [JSP通过Servlet提交表单数据并显示](https://blog.csdn.net/xie_xiansheng/article/details/50769426)

