<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<title>HappyForum | 控制面板</title>
	<jsp:include page="../includes/header.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
	<jsp:include page="../includes/nav.jsp" />
	<c:if test="${user.role==1}">
		<jsp:include page="../includes/admin_menu.jsp" />
	</c:if>
	<c:if test="${user.role==null}">
		<jsp:include page="../includes/user_menu.jsp" />
	</c:if>

	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
				控制面板
				<small></small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="/user/main"><i class="fa fa-dashboard"></i> 首页</a></li>
				<li class="active">控制面板</li>
			</ol>
		</section>

		<!-- Main content -->
		<section class="content">

		</section>
	</div>

	<jsp:include page="../includes/copyright.jsp" />
</div>

<jsp:include page="../includes/footer.jsp" />
</body>
</html>