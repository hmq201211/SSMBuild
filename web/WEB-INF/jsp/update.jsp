<%--
  Created by IntelliJ IDEA.
  User: hmq
  Date: 2020/5/17
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/book/update">
    <label hidden="hidden">书籍id</label><input hidden="hidden" name="bookId" value="${book.bookId}">
    <label>书籍名称</label><input name="bookName" value="${book.bookName}">
    <label>书籍数量</label><input name="bookCounts" value="${book.bookCounts}"/>
    <label>书籍详情</label><input name="detail" value="${book.detail}"/>
    <label>书籍名称</label><input type="submit"/>
</form>
</body>
</html>
