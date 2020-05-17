<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hmq
  Date: 2020/5/17
  Time: 1:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>列表页</title>
</head>
<body>
<h1>书籍列表</h1>
<c:forEach var="item" items="${list}">
    <p>${item.bookId},${item.bookName},${item.bookCounts},${item.detail}</p>
    <a href="${pageContext.request.contextPath}/book/delete?id=${item.bookId}">删除</a>
    <a href="${pageContext.request.contextPath}/book/toUpdatePage?id=${item.bookId}">更新</a>
</c:forEach>
<a href="${pageContext.request.contextPath}/book/toAddPage">添加书籍</a>
</body>
</html>
