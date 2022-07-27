<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
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
    <div>
        <form action="login" method="post" style="margin: 0 auto;">
            账号：<input type="text" name="name"><br><br>
            密码：<input type="password" name="pwd"><br><br>
            <input type="submit"value="登录"name="">
            <input type="reset"value="重置"><br>
        </form>
        <br>
        <br>
        <a href="register.jsp">新用户注册</a>
    </div>

</div>

</body>
</html>

