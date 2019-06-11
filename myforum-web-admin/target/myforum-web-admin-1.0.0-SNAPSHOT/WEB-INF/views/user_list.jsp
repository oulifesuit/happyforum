<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys"  %>

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

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>

                            <div class="row" style="padding-left: 15px ;padding-top:15px">
                                <a href="/user/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 新增</a>&nbsp&nbsp&nbsp
                                <button type="button" id="dele" class="btn btn-sm btn-default" onclick="deleMulti()"><i class="fa fa-trash-o" ></i> 删除</button>&nbsp&nbsp&nbsp
                                <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>&nbsp&nbsp&nbsp
                                <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>
                            </div>

                            <div class="row" style="padding-top: 20px">
                                <form:form cssClass="form-horizontal" action="/user/search" method="post" modelAttribute="tbUser">
                                    <div class="row">
                                        <div class="col-xs-5">
                                            <div class="form-group">
                                                <label for="username" class="col-sm-2 control-label">用户名</label>

                                                <div class="col-sm-8">
                                                    <form:input path="username" cssClass="form-control" placeholder="用户名" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-xs-5">
                                            <div class="form-group">
                                                <label for="email" class="col-sm-2 control-label">邮箱</label>

                                                <div class="col-sm-8">
                                                    <form:input path="email" cssClass="form-control" placeholder="邮箱" />
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
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body table-responsive no-padding" style="margin-top:20px ">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>序号</th>
                                    <th><input type="checkbox" class="minimal icheck_master" /></th>
                                    <th>ID</th>
                                    <th>用户名</th>
                                    <th>邮箱</th>
                                    <th>更新时间</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${tbUsers}" var="tbUser" varStatus="number">
                                    <tr>
                                        <td style="font-weight:bold">${number.count}</td>
                                        <td><input cid="${tbUser.uid}" type="checkbox" class="minimal checkBoxNode"/></td>
                                        <td>${tbUser.uid}</td>
                                        <td>${tbUser.username}</td>
                                        <td>${tbUser.email}</td>
                                        <td>${tbUser.timeEnd}</td>
                                        <td>
                                            <c:if test="${tbUser.role==1}">
                                                <h0 style="color:black" type="button" class="btn btn-sm btn-danger">无权限</h0>
                                            </c:if>
                                            <c:if test="${tbUser.role!=1}">
                                                <a href="/user/deleOne/${tbUser.uid}" type="button" class="btn btn-sm btn-danger "><i class="fa fa-trash-o"></i> 删除</a>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="../includes/copyright.jsp" />
</div>

<jsp:include page="../includes/footer.jsp" />
<!-- iCheck 1.0.1 -->


<script type="text/javascript">
    /**
     * 批量删除
     */
    //定义一个存放id的数组
    var idArray=new Array();
    function deleMulti() {


        var checkBoxs = $("input:checkbox:checked");


        $.each(checkBoxs, function(index, checkBox){

            idArray.push($(checkBox).attr("cid"));

        });
        console.log(idArray);
       /* if(idArray===0){
            $("#modal-default").modal("show");
        }*/
    }


    $(function () {
        $("#dele").bind("click",function () {
            del(idArray,"/user/dele")
        })
    })
    function del(idArray,url) {
        
    }

</script>

</body>
</html>