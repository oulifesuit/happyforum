<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Happy forum</title>
    <jsp:include page="../includes/goheader.jsp" />
</head>

<body>

<div class="container">
    <div class="row">

        <jsp:include page="../includes/person_info.jsp" />
    </div>

    <!-- /.box-footer-->
    <div class="box-body table-responsive no-padding" style="margin-top:20px ">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>序号</th>
                <th>ID</th>
                <th>版块</th>
                <th>用户名</th>
                <th>标题</th>
                <th>更新时间</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${posts}" var="post" varStatus="number">
                <tr>
                    <td style="font-weight:bold">${number.count}</td>
                    <td>${post.pid}</td>
                    <td>${post.topic.tname}</td>
                    <td>${post.tbUser.username}</td>
                    <td><a href="/toPost?pid=${post.pid}">${post.title}</a></td>
                    <td>${post.alterTime}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>


</div>
</body>

</html>
<script src="../../static/assets/js/jquery-3.2.1.js"></script>
<script src="../../static/assets/js/bootstrap.js"></script>