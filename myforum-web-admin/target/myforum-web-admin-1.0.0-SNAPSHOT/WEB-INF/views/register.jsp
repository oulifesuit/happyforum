<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="icon" href="../static/assets/img/forum.png" type="img/x-ico" />
	<link rel="stylesheet" type="text/css" href="../../static/assets/css/login_style.css">
	<title>Welcome to happy forum!!!</title>

</head>
<body >
 <div id="content">

    <form action="/register" method="post">
      <h0 style="color:red">${error_msg}</h0>
        <div class="login-input-box">
            <span class="icon icon-user"></span>
        	<input type="text" name="username" placeholder="用户名"/>
        </div>
         <div class="login-input-box">
            <span class="icon icon-email"></span>
            <input type="text" name="email" placeholder="邮箱"/>
        </div>
        <div class="login-input-box">
            <span class="icon icon-password"></span>
            <input type="password" name="password" placeholder="密码"/>
        </div>
     	<div class="login-input-box">
            <span class="icon icon-password"></span>
            <input type="password" name="en_password" placeholder="确认密码"/>
        </div>
    <div class="login-button-box">
        <button type="submit" name="submit" ><font id="font_button">注册</font></button>
    </div>
    <div class="login-box">
        <a class="acolor" href="">忘记密码</a>
        <a href="login" class="text-center">登录</a>
    </div>
    </form>
</div>

</body>
</html>