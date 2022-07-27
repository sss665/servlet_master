<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--注意：--%>
<%--1.jstl表达式需要导入核心配置文件core--%>
<%--2.${users}获取名为users的对象--%>
<%--3.使用c标签的foreach遍历对象users,遍历后的别名为U--%>
<%--4.通过a标签href属性访问servlet并使用?id传递参数--%>

<html>
<head>
    <title>主页</title>
</head>
<body>
<div style="text-align: center">
    <div>
        <h1>基于Servlet的管理系统</h1>
        <br>
        <br>
        <br>
        <br>
        <%--使用el表达式获取request域里的属性--%>
        <p>在线用户： ${msg}</p>
        <br>
        <br>
        <br>
        <%--href后面可以跟要跳转的jsp文件，也可以跟要访问的servlet路径，这里访问了servlet则web.xml里必须有这个路径--%>

        <a href="searchAll">开始用户管理</a>
    </div>

</div>

</body>
</html>

