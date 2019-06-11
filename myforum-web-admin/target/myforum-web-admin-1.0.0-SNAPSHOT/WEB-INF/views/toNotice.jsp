<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>${post.title}</title>
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
                <a href="/goNotice">[通告版]</a><b>—></b>
                <h0>${notice.title}</h0>
            </div>
        </div>

        <div class="main w clearfix">
            <!-- 主体左部分 -->
            <div class="main-left">

                <!-- 帖子内容板块 -->
                <div class="post-content">
                    <div class="post-title">
                        <span class="glyphicon glyphicon-th"></span>&nbsp;${notice.title}
                    </div>
                    <div class="post-user clearfix">

                        <div class="user-info">
                            <div style="text-align: center">编辑于 ${notice.alterTime}</div>
                        </div>

                    </div>
                    <div class="post-desc">
                        ${notice.content}<br />
                    </div>
                </div>
            </div>
        </div>

</body>
</html>
