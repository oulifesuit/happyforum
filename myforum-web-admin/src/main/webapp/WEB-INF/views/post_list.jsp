<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Happy forum | 用户管理</title>
    <jsp:include page="../includes/header.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp" />
    <jsp:include page="../includes/admin_menu.jsp" />

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                内容管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/user/main"><i class="fa fa-dashboard"></i>首页</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                        <div class="box-header">
                            <h3 class="box-title">帖子列表</h3>


                        <%--    <div class="row" style="padding-top: 20px">
                                <form:form cssClass="form-horizontal" action="/postsearch" method="post" modelAttribute="post">
                                    <div class="row">
                                        <div class="col-xs-5">
                                            <div class="form-group">
                                                <label for="title" class="col-sm-2 control-label">标题</label>

                                                <div class="col-sm-8">
                                                    <form:input path="title" cssClass="form-control" placeholder="标题" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-5">
                                            <div class="form-group">
                                                <label for="content" class="col-sm-2 control-label">内容</label>

                                                <div class="col-sm-8">
                                                    <form:input path="content" cssClass="form-control" placeholder="内容" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-xs-12" style="padding-right: 75px">
                                                <button type="submit" class="btn btn-info pull-right">搜索</button>
                                            </div>
                                        </div>
                                    </div>

                                </form:form>
                            </div>--%>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding" style="margin-top:20px ">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>版块</th>
                                    <th>标题</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${posts}" var="post" varStatus="number">
                                    <tr>
                                        <td style="font-weight:bold">${number.count}</td>
                                        <td>${post.pid}</td>
                                        <td>${post.tbUser.username}</td>
                                        <td>${post.topic.tname}</td>
                                        <td><a href="/toPost?pid=${post.pid}">${post.title}</a></td>
                                        <td>${post.alterTime}</td>
                                        <td>
                                            <a href="/toPost?pid=${post.pid}" type="button" class="btn btn-sm btn-default"><i class="fa fa-search"></i> 查看</a>
                                            <a href="postdele/${post.pid}" type="button" class="btn btn-sm btn-danger "><i class="fa fa-trash-o"></i> 删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
        </section>
    </div>

    <jsp:include page="../includes/copyright.jsp" />
</div>

<jsp:include page="../includes/footer.jsp" />
<!-- iCheck 1.0.1 -->

</body>
</html>