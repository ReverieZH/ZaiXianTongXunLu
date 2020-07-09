<%--
  Created by IntelliJ IDEA.
  User: rzh
  Date: 2020/1/14
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>用户登录</title>
    <link rel="stylesheet" href="./css/font-awesome.css" />
    <link rel="stylesheet" href="./css/font-awesome.min.css" />
    <link rel="stylesheet" href="./css/sweetalert.css" />
    <link rel="stylesheet" href="./css/LoginCss.css" />
    <script type="text/javascript" src="./js/sweetalert-dev.js" ></script>
    <script type="text/javascript" src="./js/Login.js" ></script>
</head>
<body>

<div id="Login_box">
    <h1>Login</h1>
    <div class="form">
        <form name="MyForm" method="post" action= "login.do" onsubmit="return MyCheck()">
            <div class="item">
                <i class="fa fa-user-circle" aria-hidden="true"></i>
                <input id="login_username" name="username" type="text" placeholder="Username"/>
            </div>
            <div class="item">
                <i class="fa fa-unlock-alt" aria-hidden="true"></i>
                <input id="login_password" name="password" type="password" placeholder="Password"/>
            </div>
            <input type="submit" class="login_button" value="Login" style="border: none;
			color: #FFFFFF;
			font-size: 20px;
			margin-top: 15px;
			width: 180px;
			height: 30px;
			border-radius: 15px;
			transform: translateX(10px);
			background-image: linear-gradient(120deg, #e0c3fc 0%, #8ec5fc 100%); outline: none" />
        </form>
    </div>
</div>
</body>
</html>
