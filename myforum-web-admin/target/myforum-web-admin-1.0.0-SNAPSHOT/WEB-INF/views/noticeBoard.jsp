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
                <a href="#" name="topic_tname">[通告版]</a>
            </div>
        </div>



            <!-- /.box-footer-->
            <div class="box-body table-responsive no-padding" style="margin-top:20px ">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>序号</th>
                        <th>ID</th>
                        <th>版块</th>
                        <th>标题</th>
                        <th>更新时间</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${notices}" var="notice" varStatus="number">
                        <tr>
                            <td style="font-weight:bold">${number.count}</td>
                            <td>${notice.nid}</td>
                            <td>[通告版]</td>
                            <td><a href="/toNotice?nid=${notice.nid}">${notice.title}</a></td>
                            <td>${notice.alterTime}</td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>

        <!-- /.box -->
    </div>
</div>
<!-- /.content -->


</body>
</html>
