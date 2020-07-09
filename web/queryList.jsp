<%@ page import="cn.com.bean.Page" %>
<%@ page import="cn.com.bean.Contracts" %>
<%@ page import="cn.com.ui.Common" %><%--
  Created by IntelliJ IDEA.
  User: rzh
  Date: 2020/1/15
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>在线通讯录</title>
    <link rel="stylesheet" href="./css/MainCss.css" />
    <script type="text/javascript" src="./js/Main.js"></script>
    <script type="text/javascript">
        function selPage_onchange(){
            var selPage=document.getElementById("selPage");
            var pageNum=selPage.options[selPage.selectedIndex].value;
            location.href="queryList.do?page="+pageNum;
        }
    </script>
</head>

<body>

<div class="all">
    <%@include file="top.jsp"%>
    <div  class="main">
        <div class="left">
            <%@include file="menu.jsp"%>
        </div>
        <div class="right">
            <div style="text-align: center;">
                <h2 >查询列表</h2>
                <table class="table_context">
                    <tr>
                        <th width="7%" height="25" align="center">姓名</th>
                        <th width="5%" height="25" align="center">性别</th>
                        <th width="7%" height="25" align="center">年龄</th>
                        <th width="12%" height="25" align="center">生日</th>
                        <th width="9%" height="25" align="center">QQ</th>
                        <th width="9%" height="25" align="center">固定电话</th>
                        <th width="8%" height="25" align="center">手机</th>
                        <th width="8%" height="25" align="center">邮箱</th>
                        <th width="16%" height="25" align="center">工作单位</th>
                        <th width="12%" height="25" align="center">通信地址</th>
                        <th width="7%" height="25" align="center">邮政编码</th>
                        <th width="8%" height="25" align="center">类别</th>
                    </tr>
                    <%
                        Page<Contracts> pageBean= (Page<Contracts>) request.getAttribute("pageBean");
                        int pageSize=0,startIndex=0,pageNum=0,totalPage=0,totalRecord=0;
                        if(pageBean!=null){
                            pageSize=pageBean.getPageSize();
                            startIndex=pageBean.getStartIndex();
                            pageNum=pageBean.getPageNum();
                            totalPage=pageBean.getTotalPage();
                            totalRecord=pageBean.getTotalRecord();
                            int k=0,i=startIndex;
                            while (k<pageSize&&i<totalRecord){
                    %>
                    <tr>
                        <td width="7%" height="25" align="center"><%=pageBean.getList().get(i).getName() %></td>
                        <td width="5%" height="25" align="center"><%=pageBean.getList().get(i).getSex() %></td>
                        <td width="7%" height="25" align="center"><%=getNotNullString(pageBean.getList().get(i).getAge() )%></td>
                        <td width="12%" height="25" align="center"><%=pageBean.getList().get(i).getBirth()%></td>
                        <td width="9%" height="25" align="center"><%=Common.getNotNullString(pageBean.getList().get(i).getQq()) %></td>
                        <td width="9%" height="25" align="center"><%=displayNumber(pageBean.getList().get(i).getNumber()) %></td>
                        <td width="8%" height="25" align="center"><%=Common.getNotNullString(pageBean.getList().get(i).getPhone()) %></td>
                        <td width="8%" height="25" align="center"><%=displayEmail(pageBean.getList().get(i).getEmail()) %></td>
                        <td width="16%" height="25" align="center"><%=displayWorkspace(pageBean.getList().get(i).getWorkspace()) %></td>
                        <td width="12%" height="25" align="center"><%=displayAddress(pageBean.getList().get(i).getAddress()) %></td>
                        <td width="7%" height="25" align="center"><%=Common.getNotNullString(pageBean.getList().get(i).getPostcode()) %></td>
                        <td width="8%" height="25" align="center"><%=pageBean.getList().get(i).getRole() %></td>
                    </tr>
                    <%
                                k++;i++;
                            }
                        }
                    %>
                </table>
                <div class="selectDiv">
                    <%if(pageBean!=null){%>
                    <div class="check_All">

                    </div>
                    <div class="selectPage">
                        <%if(pageNum>1){%>
                        <a href="queryList.do?page=1">第一页</a>&nbsp;&nbsp;
                        <a href="queryList.do?page=<%=pageNum-1%>">上一页</a>&nbsp;&nbsp;
                        <%}else{%>
                        第一页&nbsp;&nbsp;上一页&nbsp;&nbsp;
                        <%} %>
                        <%if(pageNum<totalPage){%>
                        <a href="queryList.do?page=<%=pageNum+1%>">下一页</a>&nbsp;&nbsp;
                        <a href="queryList.do?page=<%=totalPage%>">最后一页</a>&nbsp;&nbsp;
                        <%}else{%>
                        下一页&nbsp;&nbsp;最后一页&nbsp;&nbsp;
                        <%} %>
                        转到第
                    </div>
                    <div class="selectstyle">
                        <select id="selPage" name="selPage" onchange="selPage_onchange()" class="select">
                            <%for(int m=0;m<totalPage;m++){%>
                            <%if(m+1==pageNum){ %>
                            <option value="<%=m+1%>" selected><%=m+1%></option>
                            <%}else{ %>
                            <option value="<%=m+1%>"><%=m+1%></option>
                            <%}
                            } %>
                        </select>
                    </div>
                    <div class="selectPage">
                        页
                    </div>
                    <%} %>
                </div>
            </div>
        </div>
    </div>
    <%@include file="bottom.jsp"%>
</div>
<%!
    String displayNumber(String number){
        if(number!=null)
            return "<a title='" + number + "'>" + Common.getFixedLengthString(number, 7) + "</a>";
        else
            return "&nbsp;";
    }



    String displayWorkspace(String workspace){
        if(workspace!=null)
            return "<a title='" + workspace + "'>" + Common.getFixedLengthString(workspace, 8) + "</a>";
        else
            return "&nbsp;";
    }

    String displayAddress(String address){
        if(address!=null)
            return "<a title='" + address + "'>" + Common.getFixedLengthString(address, 5) + "</a>";
        else
            return "&nbsp;";
    }
    String displayEmail(String email){
        if(email!=null)
            return "<a title='" + email + "'>" + Common.getFixedLengthString(email, 6) + "</a>";
        else
            return "&nbsp;";
    }
    String getNotNullString(Integer age){
        if(age==null){
            return "";
        }else{
            return String.valueOf(age);
        }
    }
%>

</body>
</html>
