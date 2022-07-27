<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--注意：--%>
<%--1.jstl表达式需要导入核心配置文件core--%>
<%--2.${users}获取名为users的对象--%>
<%--3.使用c标签的foreach遍历对象users,遍历后的别名为U--%>
<%--4.通过a标签href属性访问servlet并使用?id传递参数--%>

<html>
<head>
    <title>管理界面</title>
</head>
<body>
<div style="text-align: center">
    <div>
        <h1>基于Servlet的管理系统</h1>
        <br>
        <br>
        <br>
        <br>

    </div>
    <div style="text-align: center;position: center ;margin: auto">
        <a href="add.jsp">新增用户</a>
        <br>
        <br>
        <table  width="600" border="1" cellpadding="0" align="center" >
            <tr>
                <th>ID</th>
                <th>power</th>
                <th>tempture</th>
                <th>softpower</th>
                <th>connected</th>
                <th>操作</th>
            </tr>
            <c:forEach var="U" items="${stas}">
                <form action="update" method="post">
                    <tr>
                        <td><input type="text" value="${U.id}" name="id" ></td>
                        <td><input type="text" value="${U.power}" name="power"></td>
                        <td><input type="text" value="${U.temperature}" name="temperature"></td>
                        <td><input type="text" value="${U.softpower}" name="softpower"></td>
                        <td><input type="text" value="${U.connected}" name="connected"></td>
                        <td><a href="delete?id=${U.id}">删除</a>  <input type="submit" value="更新"/></td>
                    </tr>
                </form>
            </c:forEach>
        </table>
        <br>
        <br>

    </div>

</div>

</body>
</html>

