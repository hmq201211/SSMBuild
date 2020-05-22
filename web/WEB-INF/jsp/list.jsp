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
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        $(function () {
                $("#search").click(function () {
                    let keywords = $("#keywords").val();
                    console.log(keywords);
                    $.post(
                        "${pageContext.request.contextPath}/book/getLikeBooks",
                        {"keywords": keywords},
                        function (data, status) {
                            if (status === "success") {
                                let html = "";
                                for (let item of data) {
                                    html += ("<p>" + item.bookId + "," + item.bookName + "," + item.bookCounts + "," + item.detail + "</p>")
                                }
                                $("#content").html(html);
                            }
                        })
                })
            }
        )
    </script>
    <title>列表页</title>
</head>
<body>
<h1>书籍列表</h1>
<div id="content">
    <c:forEach var="item" items="${list}">
        <p>${item.bookId},${item.bookName},${item.bookCounts},${item.detail}</p>
        <a href="${pageContext.request.contextPath}/book/delete?id=${item.bookId}">删除</a>
        <a href="${pageContext.request.contextPath}/book/toUpdatePage?id=${item.bookId}">更新</a>
    </c:forEach>
</div>
<a href="${pageContext.request.contextPath}/book/toAddPage">添加书籍</a>

<label>
    模糊查询条件
    <input name="keywords" id="keywords"/>
</label>
<button id="search">提交</button>

</body>
</html>
