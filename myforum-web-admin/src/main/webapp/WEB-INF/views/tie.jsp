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
                <a href="/topic?topic_tid=${post.topic.tid}">${post.topic.tname}</a><b>—></b>
                <h0>${post.title}</h0>
            </div>
        </div>

         <div class="main w clearfix">
            <!-- 主体左部分 -->
             <div class="main-left">

                <!-- 帖子内容板块 -->
                <div class="post-content">
                    <div class="post-title">
                        <span class="glyphicon glyphicon-th"></span>&nbsp;${post.title}
                    </div>
                    <div class="post-user clearfix">
                        <div>
                            <a href="toProfile.do?uid=${post.tbUser.uid}"><img class="user-info-avatar" src="/static/assets/img/avatar.jpg"></a>
                        </div>
                        <div class="user-info">
                            <div class="user-name">${post.tbUser.username}</div>
                            <div style="text-align: center">编辑于 ${post.postTime}</div>
                        </div>

                        <div class="other-count">
                            <span class="reply-count"><h0>回复 ${post.replyCount}</h0></span>&nbsp;

                            <c:choose>
                                <c:when test="${goodPid==null}">
                                    <span class="up-count"><a href="/postGood/${user.uid}/${post.pid}">赞 ${post.likeCount}</a></span>&nbsp;
                                </c:when>
                                <c:when test="${user==null}">
                                    <span class="up-count"><h0>赞 ${post.likeCount}</h0></span>&nbsp;
                                </c:when>
                                <c:otherwise>
                                    <span class="up-count"><h0 style="color:#2e6da4;">赞 ${post.likeCount}</h0></span>&nbsp;
                                </c:otherwise>
                            </c:choose>

                        </div>

                    </div>
                    <div class="post-desc">
                        ${post.content}<br />
                    </div>
                </div>


                 <!-- 帖子回复内容板块 -->
                 <div class="post-reply">
                     <!-- 回复区标题 -->
                     <div class="post-reply-title">
                         <h2 class="reply-count"><span class="glyphicon glyphicon-th"></span>&nbsp;${post.replyCount}条回帖</h2>
                         <a href="#reply-area">回复</a>
                     </div>
                     <!-- 回复区内容 -->
                     <div class="post-reply-content">
                         <!-- 回复条目 -->
                         <c:forEach items="${replyLists}" var="reply" varStatus="status">
                             <div class="post-reply-item clearfix">
                                 <div class="item-image"><a href="toProfile.do?uid=${reply.tbUser.uid}"><img src="/static/assets/img/avatar.jpg"></a></div>
                                 <div class="item-info">
                                     <div class="item-user-name"><a href="#">${reply.tbUser.username}</a></div>
                                     <div class="item-content">${reply.content}</div>
                                     <div class="item-date">发表于 ${reply.replyTime}</div>

                                     <%--<!-- 楼中楼，即嵌套的回复内容 -->
                                     <div class="item-more">
                                         <c:forEach items="${reply.commentList}" var="comment">
                                             &lt;%&ndash;一个wrap开始&ndash;%&gt;
                                             <div class="item-wrap">
                                                 <div class="item-more-1">
                                                     <a href="toProfile.do?uid=${comment.user.uid}" class="item-more-user">${comment.user.username}</a>
                                                     <span>：</span>
                                                     <span class="item-more-content">${comment.content}</span>
                                                 </div>

                                                 <div class="item-more-date">${comment.commentTime}</div>
                                                 <div class="item-more-other">
                                                     <a href="#s${status.count}" class="item-more-reply">回复</a>&nbsp;
                                                 </div>
                                             </div><!-- 一个wrap结束-->
                                         </c:forEach>

                                         <!-- 楼中楼的回复框 -->
                                         <div class="reply-input">
                                             <form action="comment.do" method="post">
                                                 <input type="hidden" name="pid" value="${post.pid}"/>
                                                 <input type="hidden" name="rid" value="${reply.rid}"/>
                                                 <textarea id="s${status.count}" name="content"></textarea>
                                                 <button type="submit">回复</button>
                                             </form>
                                         </div>
                                     </div><!-- 楼中楼结束 -->--%>

                                 </div>
                                 <div class="item-other">
                                     <a href="#s${status.count}" class="item-reply">回复</a>&nbsp;
                                 </div>

                             </div>
                         </c:forEach><!-- 回复条目结束 -->

                     </div>
                 </div>

                 <!-- 回复区，富文本编辑器板块 -->
                 <div id="reply-area" class="post-reply-textarea">
                     <div style="margin: 10px 20px">
                         <form:form action="/reply" method="post" modelAttribute="replyCon">
                             <form:hidden path="content" />
                             <form:hidden path="pid" value="${post.pid}" />
                             <form:hidden path="uid" value="${user.uid}" />
                             <div id="editor" ></div>

                             <c:choose>
                                 <c:when test="${user!=null}">
                                     <button type="submit" class="reply-button" id="btnS">回帖</button>
                                 </c:when>
                                 <c:otherwise>
                                     <a href="/login" type="submit" class="reply-button" id="btnS">回帖</a>
                                 </c:otherwise>
                             </c:choose>


                         </form:form>
                     </div>
                 </div>

            </div>
         </div>



<script src="/static/assets/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/static/assets/plugins/wangEditor/wangEditor.min.js"></script>
<script type="text/javascript">

    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.create();
    //配置处理图片上传的路径，最好用相对路径
    editor.config.uploadImgUrl = 'upload.do';
    //配置图片上传到后台的参数名称
    editor.config.uploadImgFileName = 'myFileName';



    $("#btnS").bind("click",function () {
        var contentHtml=editor.txt.html();
        $("#content").val(contentHtml);
    });
</script>
</body>
</html>
