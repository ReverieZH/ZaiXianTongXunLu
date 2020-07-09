<%--
  Created by IntelliJ IDEA.
  User: rzh
  Date: 2020/1/12
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>用户登录</title>
  <link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />
</head>
<body class="login_back" background="img/login_background.jpg">
<script language="javascript">
  //去掉字串左边的空格
  function lTrim(str) {
    if (str.charAt(0) == " " || str.charAt(0) == "　") {
      str = str.slice(1);
      str = lTrim(str);
    }
    return str;
  }

  //去掉字串右边的空格
  function rTrim(str) {
    var iLength;
    iLength = str.length;
    if (str.charAt(iLength - 1) == " " || str.charAt(iLength - 1) == "　") {
      str = str.slice(0, iLength - 1);
      str = rTrim(str);
    }
    return str;
  }

  //去掉字串两边的空格
  function trim(str) {
    return lTrim(rTrim(str));
  }

  //验证表单域
  function MyCheck() {
    var StrYhm = document.getElementById("login_username").value;
    StrYhm = trim(StrYhm);
    if (StrYhm == "") {
      alert("请输入用户名!");
      return false;
    }

    var StrMm = document.getElementById("login_password").value;
    StrMm = trim(StrMm);
    if (StrMm == "") {
      alert("请输入密码!");
      return false;
    }

    return true;
  }
</script>

<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tr>
    <td height="500" align="center">
      <form name="MyForm" method="get" action= "login.do" onsubmit="return MyCheck()">
        <table border="0" cellpadding="0" cellspacing="0" width="500">
          <tr>
            <td width="260" height="30" align="right" style="color: white; font-size: 30px;">用户名：</td>
            <td width="240" height="30" align="left">
              <input id="login_username" name="username" type="text" maxlength="10" class="login_input">
            </td>
          </tr>
          <tr>
            <td width="500" height="10" align="right" colspan="2"></td>
          </tr>
          <tr>
            <td width="260" height="30" align="right" style="color: white; font-size: 30px;">密&nbsp;&nbsp;&nbsp;码：</td>
            <td width="240" height="30" align="left">
              <input id="login_password" name="password" type="password" maxlength="10" class="login_input">
            </td>
          </tr>
          <tr>
            <td width="500" height="10" align="right" colspan="2"></td>
          </tr>
          <tr>
            <td width="500" height="30" align="center" colspan="2">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="submit" value="提   交" class="login_button">
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <input type="reset" value="重  置" class="login_button">
            </td>
          </tr>
        </table>
      </form>
    </td>
  </tr>
</table>
</body>
</html>

