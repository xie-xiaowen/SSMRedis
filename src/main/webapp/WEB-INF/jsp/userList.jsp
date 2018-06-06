<%--
  Created by IntelliJ IDEA.
  User: Xiaowen
  Date: 2018-5-25
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/static/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Title</title>

    <style>
        #main{ width: 80%; margin: auto; }
        form{ margin: 2% 0; }
        table{ width: 100%; background-color: #000; color: #fff; }
        input[type='text']{ padding: 4px 6px;}
        input[type='submit']{ padding: 3px 6px; position: relative; left: -5px; top: 1px;}
    </style>

</head>
<body>
    <div id="main">
        <form action="/user/getUserList" method="post">
            <label>请输入用户ID：</label>
            <input type="text" name="id" placeholder="请输入用户ID" />
            <input type="submit" value="搜索" />
        </form>
        <table border="1">
            <tr>
                <td width="10%">用户ID</td>
                <td width="10%">用户名</td>
                <td width="10%">年龄</td>
                <td width="10%">性别</td>
                <td width="20%">地址</td>
                <td width="20%">电话</td>
                <td width="10%">操作</td>
            </tr>
            <c:forEach items="listUser" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.gender}</td>
                    <td>${user.address}</td>
                    <td>${user.phone}</td>
                    <td>
                        <a href="#">修改</a>
                        <a href="#">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>