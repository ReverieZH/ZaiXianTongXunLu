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
       function MyCheck() {
           var name = document.getElementById("name").value;
           var number=document.getElementById("number").value;
           var phone=document.getElementById("phone").value;
           var workspace=document.getElementById("workspace").value;
           var role=document.getElementsByName("role");

           var rolevalue=false;
           for(var i=0;i<role.length;i++){
               if(role[i].checked){
                   rolevalue=true;
               }
           }
           name = trim(name);
           number = trim(number);
           phone = trim(phone);
           workspace = trim(workspace);

           if (!(name != ""||number!=""||phone != ""||workspace != ""||rolevalue)) {
               alert("请至少填写一个条件");
               return false;
           }
           return true;
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
            <h2>查询联系人</h2>
            <form  method="post" action="query.do" onsubmit="return MyCheck()">
                <table border="0" cellpadding="0" cellspacing="0" width="80%" style="margin-left: 30px;">
                    <tr>
                        <td width="25%" height="30" align="right" >姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
                        <td width="25%" height="30" align="left">
                            <input id="username" name="username" type="hidden" value="<%= username%>">
                            <input id="name" name="name" type="text" maxlength="40" class="input" >
                        </td>
                    </tr>
                    <tr>
                        <td width="25%" height="30" align="right">固定电话：</td>
                        <td width="25%" height="30" align="left">
                            <input id="number" name="number" type="text"  maxlength="13" class="input" OnKeyPress="if((event.keyCode>=48)&&(event.keyCode <=57) || event.keyCode==45) {event.returnValue=true;} else{event.returnValue=false;}" style="ime-mode:Disabled">
                        </td>
                    </tr>
                    <tr>
                        <td width="25%" height="30" align="right">手&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机：</td>
                        <td width="25%" height="30" align="left">
                            <input id="phone" name="phone" type="text"  maxlength="11" class="input" OnKeyPress="if((event.keyCode>=48)&&(event.keyCode <=57)) {event.returnValue=true;} else{event.returnValue=false;}" style="ime-mode:Disabled">
                        </td>
                    </tr>
                    <tr>
                        <td width="25%" height="30" align="right">工作单位：</td>
                        <td width="25%" height="30" align="left">
                            <input id="workspace" name="workspace" type="text"   maxlength="40" class="input">
                        </td>
                    </tr>
                    <tr>
                        <td width="25%" height="30" align="right">角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色：</td>
                        <td width="25%" height="30" align="left">
                            <div style="float: left;">
                                <div class="radio">
                                    <input id="role1" name="role" type="radio" value="个人" class="radio_type" /><label class="radio-label">个人&nbsp;</label>
                                </div>
                                <div class="radio">
                                    <input id="role2" name="role" type="radio" value="企业" class="radio_type" /><label class="radio-label">企业</label>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td width="100%" height="10" colspan="4"></td>
                    </tr>
                    <tr>
                        <td width="100%" height="30" colspan="4" align="center">
                            <div style="margin-left: 70px">
                            <input type="submit" value="查  询" class="button" >
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
