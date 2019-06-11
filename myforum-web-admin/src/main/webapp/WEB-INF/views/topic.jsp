<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发表帖子</title>
    <jsp:include page="../includes/header.jsp" />
</head>
<body>
<!-- Main content -->
<div class="container">
    <div class="row">
        <jsp:include page="../includes/person_info.jsp" />

        <div class="row">
            <div class="col-xs-12">
                <a href="/main">HappyForum论坛</a><b>—></b>
                <a href="#" name="topic_tname">${topic.tname}</a>
            </div>
        </div>

        <!-- Default box -->
        <div class="box">
            <div class="box-header with-border col-sm-8">
            </div>

            <%--//实现分页
            <div class="row">
                <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
--%>


            <c:choose>
                <c:when test="${user!=null}">
                    <div class="post_style">
                        <a href="/post/${topic.tname}" type="button" class="btn btn-sm btn-default"> 发帖</a>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="post_style">
                        <a href="/login" type="button" class="btn btn-sm btn-default"> 发帖</a>
                    </div>
                </c:otherwise>
            </c:choose>


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
        <!-- /.box -->
    </div>
</div>
<!-- /.content -->


</body>
</html>
