<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2021/3/27
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示全部图书</title>
    <%--Bootstrap--%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>修改书籍</small>
                    </h1>
                </div>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">

        <%--
            修改失败：
                1.事务问题
                2.传递隐藏域
        --%>
        <input type="hidden" name="bookID" value="${book.bookID}">
        <div class="form-group">
            <label for="bkname">书籍名称:</label>
            <input type="text" name="bookName" class="form-control" id="bkname" value="${book.bookName}">
        </div>
        <div class="form-group">
            <label for="bkcounts">书籍数量:</label>
            <input type="text" name="bookCounts" class="form-control" id="bkcounts" value="${book.bookCounts}">
        </div>
        <div class="form-group">
            <label for="bkdetail">书籍详情:</label>
            <input type="text" name="detail" class="form-control" id="bkdetail" value="${book.detail}">
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="添加">
        </div>
    </form>

</body>
</html>
