<%@ page import="cn.com.bean.Contracts" %>
<%@ page import="cn.com.ui.Common" %><%--
  Created by IntelliJ IDEA.
  User: rzh
  Date: 2020/1/16
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<html>
<head>
    <title>添加联系人</title>
    <link rel="stylesheet" href="./css/MainCss.css" />
    <link rel="stylesheet" href="./css/addContracts.css" />
    <script type="text/javascript" src="./js/Login.js" ></script>
    <script type="text/javascript" src="./js/Main.js"></script>
    <script>
        //验证密码
        function checkPwd(){
            //获取用户的密码信息
            var newpassword=document.getElementById("newpassword").value;
            //创建校验规则
            var reg=/^[a-zA-z0-9]{4,8}$/;
            //获取span对象
            var span=document.getElementById("pwdSpan");
            //开始校验
            if(newpassword=="" ||newpassword==null){
                //输出校验结果
                span.innerHTML="密码不能为空";
                span.style.color="red";
                return false;
            }else if(reg.test(newpassword)){
                //输出校验结果
                span.innerHTML="密码ok";
                span.style.color="green";
                return true;
            }else{
                //输出校验结果
                span.innerHTML="密码格式错误";
                return false;
            }
            checkPwd2();
        }
        //校验确认密码
        function checkPwd2(){
            //获取第一次密码
            var newpassword=document.getElementById("newpassword").value;
            //获取确认密码
            var Confrimpassword=document.getElementById("Confrimpassword").value;
            var span=document.getElementById("ConfrimpwdSpan");
            //比较两次密码是否相同
            if(Confrimpassword==""||Confrimpassword==null){
                span.innerHTML="请确认密码";
                span.style.color="red";
                return false;
            }else if(newpassword==Confrimpassword){
                span.innerHTML='\2716';
                span.style.color="green";
                return true;
            }else{
                span.innerHTML="两次密码不一致";
                span.style.color="red";
                return false;
            }
        }
        
        function MyCheck() {
            checkPwd();
            checkPwd2();
            return checkPwd()&&checkPwd2();
        }
    </script>

</head>
<body>
<%
    String username= String.valueOf(request.getSession().getAttribute("username"));
%>

<div class="all">
    <%@include file="top.jsp"%>
    <div  class="main">
        <div class="left">
            <%@include file="menu.jsp"%>
        </div>
        <div class="right">
            <h2>修改密码</h2>
            <form  method="post" action="changepassword.do" onsubmit="return MyCheck()">
                <table border="0" cellpadding="0" cellspacing="0" width="80%" style="margin-left: 30px;">
                    <tr>
                        <td width="25%" height="30" align="right" >原密码：</td>
                        <td width="25%" height="30" align="left">
                            <input id="username" name="username" type="hidden" value="<%= username%>">
                            <input id="oldpassword" name="oldpassword" type="text" maxlength="40" class="input"  OnKeyPress="if((event.keyCode>=48)&&(event.keyCode <=57) ||(event.keyCode>=97)&&(event.keyCode <=122)||(event.keyCode>=65)&&(event.keyCode <=90)) {event.returnValue=true;} else{event.returnValue=false;}" >
                        </td>
                    </tr>
                    <tr>
                        <td width="25%" height="30" align="right">新密码：</td>
                        <td width="25%" height="30" align="left">
                            <input id="newpassword" name="newpassword" type="text"  maxlength="13" class="input" OnKeyPress="if((event.keyCode>=48)&&(event.keyCode <=57) ||(event.keyCode>=97)&&(event.keyCode <=122)||(event.keyCode>=65)&&(event.keyCode <=90)) {event.returnValue=true;} else{event.returnValue=false;}" style="ime-mode:Disabled">
                            <span id="pwdSpan"></span>
                        </td>
                    </tr>
                    <tr>
                        <td width="25%" height="30" align="right">确认密码：</td>
                        <td width="25%" height="30" align="left">
                            <input id="Confrimpassword" name="Confrimpassword" type="text"  maxlength="11" class="input" OnKeyPress="if((event.keyCode>=48)&&(event.keyCode <=57) ||(event.keyCode>=97)&&(event.keyCode <=122)||(event.keyCode>=65)&&(event.keyCode <=90)) {event.returnValue=true;} else{event.returnValue=false;}" style="ime-mode:Disabled">
                            <span id="ConfrimpwdSpan"></span>
                        </td>
                    </tr>
                    <tr>
                        <td width="100%" height="30" colspan="4" align="center">
                            <div style="margin-left: 70px">
                                <input type="submit" value="修  改" class="button" >
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="reset" value="重  置" class="button">
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <%@include file="bottom.jsp"%>
</div>

<%!
    String getNotNullString(Object str){
        if(str==null){
            return "";
        }else{
            return String.valueOf(str);
        }
    }
%>
</body>
</html>
