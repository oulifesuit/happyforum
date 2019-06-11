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
                <a href="/topic?topic_tid=${topic.tid}">${topic_name}</a><b>—></b>
                <h0>发表帖子</h0>
            </div>
        </div>
        <c:if test="${baseResult!=null}">
            <div class="alert alert-${baseResult.status==200 ? "success":"danger"} alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                    ${baseResult.message}
            </div>
        </c:if>


        <form:form action="/postTie/${user.uid}/${topic_name}" method="post" modelAttribute="post">
            <!-- Default box -->
            <div class="box">
                <div class="box-header with-border col-sm-8">
                        <%-- <h3 class="box-title">Title</h3>--%>
                    <form:input path="title" cssClass="form-control "  placeholder="请输入标题"/>
                </div>
                <!-- /.box-footer-->
            </div>
            <!-- /.box -->
            <div class="col-sm-10">
                <form:hidden path="content" placehoder="请输入内容" />
                <div id="editor">

                </div>
                <div class="box-footer">
                    <button type="button" class="btn btn-default" onclick="history.go(-1)">返回</button>
                    <button type="submit" id="btnSubmit" class="btn btn-info pull-right">发表帖子</button>
                </div>
            </div>


        </form:form>



    </div>
</div>
<!-- /.content -->

<script src="/static/assets/js/jquery-3.2.1.js"></script>
<!-- 注意， 只需要引用 JS，无需引用任何 CSS ！！！-->
<script type="text/javascript" src="/static/assets/plugins/wangEditor/wangEditor.min.js"></script>


<script type="text/javascript">

    var E = window.wangEditor;
    var editor = new E('#editor');
    editor.create();

    $("#btnSubmit").bind("click",function () {
        var contentHtml=editor.txt.html();
        $("#content").val(contentHtml);
    });
</script>

</body>
</html>
