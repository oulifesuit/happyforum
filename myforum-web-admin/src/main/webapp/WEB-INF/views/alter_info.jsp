<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>Happy forum | 用户管理</title>
    <jsp:include page="../includes/header.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp" />

    <c:choose>
        <c:when test="${user.role==1}">
            <jsp:include page="../includes/admin_menu.jsp" />
        </c:when>
        <c:otherwise>
            <jsp:include page="../includes/user_menu.jsp" />
        </c:otherwise>
    </c:choose>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理
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
                <div class="col-xs-12">
                    <c:if test="${baseResult!=null}">
                        <div class="alert alert-${baseResult.status==200 ? "success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>

                    <div class="col-md-12">
                        <div class="box box-info">
                            <div class="box-header with-border">
                                <h3 class="box-title">修改用户</h3>
                            </div>
                            <!-- /.box-header -->
                            <!-- form start -->


                            <form:form id="inputForm" cssClass="form-horizontal" action="/user/update" method="post" modelAttribute="tbUser">
                                <div class="box-body">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">邮箱</label>

                                        <div class="col-sm-10">
                                            <p>${user.email}</p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <form:hidden path="uid" value="${user.uid}" />
                                        <label for="username" class="col-sm-2 control-label">用户名</label>

                                        <div class="col-sm-10">
                                            <form:input path="username" cssClass="form-control required " value="${user.username}"  placeholder="请输入用户名" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="password" class="col-sm-2 control-label">密码</label>

                                        <div class="col-sm-10">
                                            <form:password path="password" cssClass="form-control required" placeholder="请输入密码" />
                                        </div>
                                    </div>


                                </div>

                            </form:form>
                            <form class="form-horizontal" action="/user/save" method="post">
                                <!-- /.box-body -->
                                <div class="box-footer">
                                    <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                                    <button type="submit" class="btn btn-info pull-right">保存</button>
                                </div>
                                <!-- /.box-footer -->
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="../includes/copyright.jsp" />
</div>

<jsp:include page="../includes/footer.jsp" />
</body>
</html>