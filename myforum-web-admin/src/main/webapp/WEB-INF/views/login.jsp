<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="icon" href="../../static/assets/img/forum.png" type="img/x-ico" />
	<link rel="stylesheet" type="text/css" href="../../static/assets/css/login_style.css">
	<title>Welcome to happy forum!!!</title>

</head>
<body>
<div id="content">
<!--     <div class="login-header">
        <img src="assets/img/bg_login.png">
    </div> -->

    <form action="/login" method="post">
         <p style="color:red">${error_msg}</p>
        <div class="login-input-box">
            <span class="icon icon-user"></span>
   
        	<input type="text" name="username" placeholder="用户名" value="${username}" />
        </div>
        <div class="login-input-box">
            <span class="icon icon-password"></span>
            <input type="password" name="password" placeholder="密码" value="${password}" />
        </div>
    
    <div class="remember-box">
        <label>
            <input name="isRemember" type="checkbox" ${isRemember==true?"checked":""}>&nbsp;记住我
        </label>
    </div>
    <div class="login-button-box">
        <button type="submit" name="submit" ><font id="font_button">登录</font></button>
    </div>
    <div class="login-box">
        <a href="">忘记密码</a>
        <a href="register" class="text-center">注册</a>
    </div>
    </form>
</div>

</body>
</html>