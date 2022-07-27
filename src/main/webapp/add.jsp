<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增</title>
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
        <%--action后面跟的就是要访问的servlet路径--%>
        <form action="add" method="post" style="padding-top:-700px;">
            账号:<input name="name" type="text"><br><br>
            密码:<input name="pwd" type="password"><br><br>
            选择性别:<input type="radio"name="sex"value="男"checked>男
            <input type="radio"name="sex"value="女">女<br><br>
            选择家乡:
            <select name="home">
                <option value="上海">上海</option>
                <option value="北京" selected>北京</option>
                <option value="纽约">纽约</option>
            </select>
            <br>
            <br>
            个人信息:
            <br>
            <br>
            <textarea name="info" row="5"cols="20"></textarea><br>
            <br>
            <input type="reset"value="重置"><input type="submit"value="添加">
        </form>
        <a href="index.jsp">返回主页</a>
    </div>

</div>

</body>
</html>

