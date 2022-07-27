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
                <th>姓名</th>
                <th>性别</th>
                <th>密码</th>
                <th>家乡</th>
                <th>备注</th>
                <th>操作</th>
            </tr>
            <c:forEach var="U" items="${users}">
                <form action="update" method="post">
                    <tr>
                        <td><input type="text" value="${U.id}" name="id" ></td>
                        <td><input type="text" value="${U.name}" name="name"></td>
                        <td><input type="text" value="${U.sex}" name="sex"></td>
                        <td><input type="text" value="${U.pwd}" name="pwd"></td>
                        <td><input type="text" value="${U.home}" name="home"></td>
                        <td><input type="text" value="${U.info}" name="info"></td>
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

