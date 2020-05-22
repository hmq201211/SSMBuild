<%--
  Created by IntelliJ IDEA.
  User: hmq
  Date: 2020/5/17
  Time: 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网上书店</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/user/login">
    <label>
        请输入用户名
        <input name="username" type="text">
    </label>
    <label>
        请输入密码
        <input name="password" type="password">
    </label>
    <input type="submit" value="提交">
</form>
</body>
</html>
