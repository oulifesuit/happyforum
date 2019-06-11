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

        <div class="five_new">

            <ul class="nav nav-tabs">
                <li role="presentation" class="active">
                    <a href="#topic-tab" data-toggle="tab" aria-controls="topic-tab">新主题</a>
                </li>
                <li role="presentation">
                    <a href="#response-tab" data-toggle="tab" aria-controls="response-tab">新回复</a>
                </li>
                <li role="presentation">
                    <a href="#news-tab" data-toggle="tab" aria-controls="news-tab">通告版</a>
                </li>
            </ul>
            <div class="tab-content">
                <div id="topic-tab" class="tab-pane active">
                    <c:forEach items="${posts}" var="post">
                        <p>&nbsp&nbsp
                            <a href="/topic?topic_tid=${post.topic.tid}">[${post.topic.tname}]</a>&nbsp
                            <a href="/toPost?pid=${post.pid}">${post.title}</a>
                            &nbsp&nbsp<h0>${post.tbUser.username}</h0></p>
                    </c:forEach>
                </div>
                <div id="response-tab" class="tab-pane">
                    <c:forEach items="${posts1}" var="post1">
                        <p>&nbsp&nbsp
                            <a href="/topic?topic_tid=${post1.topic.tid}">[${post1.topic.tname}]</a>&nbsp
                            <a href="/toPost?pid=${post1.pid}">${post1.title}</a>
                            &nbsp&nbsp<h0>${post1.tbUser.username}</h0></p>
                    </c:forEach>
                </div>
                <div id="news-tab" class="tab-pane">
                    <c:forEach items="${notices}" var="notice">
                            <p>&nbsp&nbsp<a href="/goNotice">[公告版]</a>&nbsp<a href="/toNotice?nid=${notice.nid}">${notice.title}</a></p>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="plate-wrap">


            <c:forEach items="${topics}" var="topic">
                <div class="col-md-6 plate clearfix">

                    <div class="col-md-6">
                        <h4 class="plate-small-title"><a href="/topic?topic_tid=${topic.tid}" name="topic_name">${topic.tname}</a></h4>
                        <p name="topic_content">${topic.content}</p>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>
</body>

</html>
<script src="../../static/assets/js/jquery-3.2.1.js"></script>
<script src="../../static/assets/js/bootstrap.js"></script>