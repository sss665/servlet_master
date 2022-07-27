# 基于Servlet的管理系统


### 介绍
基于Servlet框架的管理系统 _简洁版_ ；

实现 **登录** 、 **注册** 、 **增** 、 **删** 、 **改** 、 **查** ；

可继续完善增加前端、校验、其他功能等；

可作为 **Servlet项目** 开发练习基础模型；

 **课程设计** 、 **毕业设计** 开发基础；

任何复杂的框架都是简单的知识组合并延伸的，学好基础知识才是最重要的；

此项目简单，便于理解基本原理，为复杂的Servlet、SSH、SSM等复杂项目的开发打下基础。




### 环境准备
开发平台：Idea 2019

数据库：MySQL 5.0.22

服务器：Tomcat 9.0.37

注意：需要安装IDEA开发平台、MySQL数据库和Tomcat服务器，版本不一定完全一致，做好版本适应性配置即可。



### 项目结构

1.数据库及Java代码文件
![输入图片说明](https://images.gitee.com/uploads/images/2021/1109/180646_b797b016_9956838.png "project.png")



2.Jsp等前端代码
![输入图片说明](https://images.gitee.com/uploads/images/2021/1109/180629_278bb66c_9956838.png "project2.png")



3.Tomcat服务器配置与运行

![输入图片说明](https://images.gitee.com/uploads/images/2021/1109/180657_64f7c85c_9956838.png "Tomcat·.png")



4.MySQL数据库
![输入图片说明](https://images.gitee.com/uploads/images/2021/1109/180709_5451dfdf_9956838.png "mysql.png")



### 基本原理

####  **1. 相关概念** 

Servlet是一门用于开发动态web网页的技术，用于交互式地浏览和修改数据，生成动态Web内容。如今Java Web开发中已经很少单纯用到Servlet去开发Web应用，更多是整合框架开发。实际上，大多框架都是基于基础工具去封装起来的，像Struts就是对servlet与filter的封装，Hibernate对JDBC的封装等等。所以，无论学习什么框架，首先深入理解基础知识，从而对框架中出现的问题有一个理性的认识与解决。



####  **2. 基本原理** 

**2.1工作流程**

1. Web Client 向Servlet容器（Tomcat）发出Http请求

2. Servlet容器接收Web Client的请求

3. Servlet容器创建一个HttpRequest对象，将Web Client请求的信息封装到这个对象中。

4. Servlet容器创建一个HttpResponse对象

5. Servlet容器调用HttpServlet对象的service方法，把HttpRequest对象与HttpResponse对象作为参数传给 HttpServlet 对象。

6. HttpServlet调用HttpRequest对象的有关方法，获取Http请求信息。

7. HttpServlet调用HttpResponse对象的有关方法，生成响应数据。

8. Servlet容器把HttpServlet的响应结果传给Web Client。


![输入图片说明](https://images.gitee.com/uploads/images/2021/1109/180724_62e99e6e_9956838.jpeg "原理图.jpg")


![输入图片说明](https://images.gitee.com/uploads/images/2021/1109/180754_2c659175_9956838.jpeg "原理图2.jpg")




**2.2处理请求流程**

1. 用户点击一个链接，指向了一个servlet而不是一个静态页面。

2. 容器“看出”这个请求是一个Servlet，所以它创建了两个对象HttpServletRequest和HttpServletResponse。

3. 容器根据请求中的URL找到正确的Servlet，为这个请求创建或分配一个线程，并把请求和响应对象传递给这个Servlet线程。

4. 容器调用Servlet的service()方法。根据请求的不同类型，service()方法会调用doGet()或doPost()方法。这里假设调用doGet()方法。

5. doGet()方法生成动态页面，并把这个页面“塞到”响应对象里，需要注意的是，容器还有响应对象的一个引用！

6. 线程结束，容器把响应对象转换为一个HTTP响应，并把它发回给客户，然后删除请求和响应对象。



##### **2.3工作原理**

​	1. 首先简单解释一下Servlet接收和响应客户请求的过程，首先客户发送一个请求，Servlet是调用service()方法对请求进行响应的，通过源代码可见，service()方法中对请求的方式进行了匹配，选择调用doGet,doPost等这些方法，然后再进入对应的方法中调用逻辑层的方法，实现对客户的响应。在Servlet接口和GenericServlet中是没有doGet（）、doPost（）等等这些方法的，HttpServlet中定义了这些方法，但是都是返回error信息，所以，我们每次定义一个Servlet的时候，都必须实现doGet或doPost等这些方法。

​	2. 每一个自定义的Servlet都必须实现Servlet的接口，Servlet接口中定义了五个方法，其中比较重要的三个方法涉及到Servlet的生命周期，分别是上文提到的init(),service(),destroy()方法。GenericServlet是一个通用的，不特定于任何协议的Servlet,它实现了Servlet接口。而HttpServlet继承于GenericServlet，因此HttpServlet也实现了Servlet接口。所以我们定义Servlet的时候只需要继承HttpServlet即可。

​	3. Servlet接口和GenericServlet是不特定于任何协议的，而HttpServlet是特定于HTTP协议的类，所以HttpServlet中实现了service()方法，并将请求ServletRequest、ServletResponse 强转为HttpRequest 和 HttpResponse。



##### **2.4Servlet生命周期**

servlet程序是由web服务器调用，web服务器实现了对servlet生命周期的管理。当你的应用加载并使用一个Servlet时，从初始化到销毁这个Servlet期间会发生一系列的事件，这些事件叫做Servlet的生命周期事件（或方法）。

Servlet 生命周期可以归纳为：

###### 							**Servlet 加载--->实例化--->服务--->销毁**

Servlet生命周期定义了一个Servlet如何被加载、初始化，以及它怎样接收请求、响应请求，提供服务。

![输入图片说明](https://images.gitee.com/uploads/images/2021/1109/180811_758df082_9956838.jpeg "周期.jpg")



	1. 创建Servlet实例
	
	web容器负责加载Servlet，当web容器启动时或者是在第一次使用这个Servlet时，容器会负责创建Servlet实例，但是用户必须通过部署描述符（web.xml）指定Servlet的位置，也就是Servlet所在的类名称，成功加载后，web容器会通过反射的方式对Servlet进行实例化。
	
	2. WEB容器调用Servlet的init()方法，对Servlet进行初始化
	
	在Servlet实例化之后，Servlet容器会调用init()方法，来初始化该对象，主要是为了让Servlet对象在处理客户请求前可以完成一些初始化的工作，例如，建立数据库的连接，获取配置信息等。对于每一个Servlet实例，init()方法只能被调用一次。init()方法有一个类型为ServletConfig的参数，Servlet容器通过这个参数向Servlet传递配置信息。Servlet使用ServletConfig对象从Web应用程序的配置信息中获取以名-值对形式提供的初始化参数。另外，在Servlet中，还可以通过ServletConfig对象获取描述Servlet运行环境的ServletContext对象，使用该对象，Servlet可以和它的Servlet容器进行通信。无论有多少客户机访问Servlet，都不会重复执行init()。
	
	3. Servlet初始化之后，将一直存在于容器中，service()响应客户端请求
	
	① 如果客户端发送GET请求，容器调用Servlet的doGet方法处理并响应请求
	
	② 如果客户端发送POST请求，容器调用Servlet的doPost方法处理并响应请求
	
	③ 或者统一用service()方法处理来响应用户请求
	
	service()是Servlet的核心，负责响应客户的请求。每当一个客户请求一个HttpServlet对象，该对象的Service()方法就要调用，而且传递给这个方法一个“请求”（ServletRequest）对象和一个“响应”（ServletResponse）对象作为参数。在HttpServlet中已存在Service()方法。默认的服务功能是调用与HTTP请求的方法相应的do功能。要注意的是，在service()方法被容器调用之前，必须确保init()方法正确完成。容器会构造一个表示客户端请求信息的请求对象（类型为ServletRequest）和一个用于对客户端进行响应的响应对象（类型为ServletResponse）作为参数传递给service()方法。在service()方法中，Servlet对象通过ServletRequest对象得到客户端的相关信息和请求信息，在对请求进行处理后，调用ServletResponse对象的方法设置响应信息。
	
	4. WEB容器决定销毁Servlet时，先调用Servlet的destroy()方法，通常在关闭web应用之前销毁Servlet
	
	destroy()仅执行一次，在服务器端停止且卸载Servlet时执行该方法。当容器检测到一个Servlet对象应该从服务中被移除的时候，容器会调用该对象的destroy()方法，以便让Servlet对象可以释放它所使用的资源，保存数据到持久存储设备中，例如，将内存中的数据保存到数据库中，关闭数据库的连接等。当需要释放内存或者容器关闭时，容器就会调用Servlet对象的destroy()方法。在Servlet容器调用destroy()方法前，如果还有其他的线程正在service()方法中执行，容器会等待这些线程执行完毕或等待服务器设定的超时值到达。一旦Servlet对象的destroy()方法被调用，容器不会再把其他的请求发送给该对象。如果需要该Servlet再次为客户端服务，容器将会重新产生一个Servlet对象来处理客户端的请求。在destroy()方法调用之后，容器会释放这个Servlet对象，在随后的时间内，该对象会被Java的垃圾收集器所回收。
	
	注意
	
	①在正常情况下，Servlet只会初始化一次，而处理服务会调用多次，销毁也只会调用一次；但是如果一个Servlet长时间不使用的话，也会被容器自动销毁，而如果需要再次使用时会重新进行初始化的操作，即在特殊情况下初始化可能会进行多次，销毁也可能进行多次。
	
	②在servlet实例创建之后，在servlet能为客户请求提供服务之前，容器会在servlet实例上调用init()方法。如果你有初始化代码，就应该覆盖servlet类的init()方法，否则会调用GenericServlet的init()方法。而对应每个客户请求（无论是谁，无论是不是同一个人，只针对请求），容器都会创建一对新的请求和响应对象，创建一个新的线程/栈。任何servlet类都不会有多个实例，除非一种特殊情况（SingleThreadModel）。
	
	③ servlet生命周期的4个周期总结如下：
	a. 实例化以及加载servlet，new的过程
	
	b. 初始化init(ServletConfig)。
	
	c. 处理请求，调用servlet的service，doget，dopost方法将Request和Response，作为参数传递。
	
	d. 退出服务，调用destory方法释放资源。

### 页面展示

1.登录页面

![输入图片说明](https://images.gitee.com/uploads/images/2021/1109/180824_4549ccd8_9956838.png "login.png")



2.注册页面
![输入图片说明](https://images.gitee.com/uploads/images/2021/1109/180834_500964c3_9956838.png "register.png")



3.主页
![输入图片说明](https://images.gitee.com/uploads/images/2021/1109/180842_0372bc08_9956838.png "index.png")



4.展示页面

![输入图片说明](https://images.gitee.com/uploads/images/2021/1109/180859_f177b0cd_9956838.png "showall.png")



5.新增页面
![输入图片说明](https://images.gitee.com/uploads/images/2021/1109/180908_f71c5e6d_9956838.png "add.png")


6.删除页面
![输入图片说明](https://images.gitee.com/uploads/images/2021/1109/180919_06d8f243_9956838.png "delete.png")



7.修改页面
![输入图片说明](https://images.gitee.com/uploads/images/2021/1109/180928_b796bfbe_9956838.png "upatedata.png")




#### 注意

    1.MySQL 版本5.0以上与8.0以上配置有些许差异，需要调整
    
    # MySQL 5.Xjdbc.driver=com.mysql.jdbc.Driver
    # MySQL 8.Xjdbc.driver=com.mysql.cj.jdbc.Driver
    
    2.运行项目前提前配置好MySQL数据库、Tomcat服务器、IDEA maven依赖库
    
    3.本系统仅实现简单功能，仅为更好理解Servlet原理，需进一步完善更多功能及健壮性


### LICENSE

zjzhou


### About me

    一个爱学习、爱分享、爱交流的程序员；
    
    欢迎关注个人微信公众号【Java烂笔头】，一起交流、共同进步；

