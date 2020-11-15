<%--
  Created by IntelliJ IDEA.
  User: zhangzheyu
  Date: 2017/7/22
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<head>
    <title>Title</title>
</head>
<form name = "main" action="main.yue" method="post">
    <button type="button" name= "signUpButton" onclick="submit()">主页</button>
</form>
<form name = "center" action="center.yue" method="post">
    <button type="button" name= "signUpButton" onclick="submit()">个人中心</button>
</form>
<form name = "friends" action="friends.yue" method="post">
    <button type="button" name= "signUpButton" onclick="submit()">好友</button>
</form>
<form name = "logout" action="logout.yue" method="post">
    <button type="button" name= "signUpButton" onclick="submit()">退出</button>
</form>
<label>用户名： </label> <label>${userInfo.getAcc_username()}</label>
<br/>
<label>邮箱： </label> <label>${userInfo.getAcc_email()}</label>
<br/>
<label>积分： </label> <label>${userInfo.getAcc_credit()}</label>
<br/>
<label>等级： </label> <label>${userInfo.getAcc_rank()}</label>
<form  name="SendMessage" action="SendMessage.yue" method="post">
    <input type="text" name = "details"/>
    <button type="submit" name = "sendbutton">发送</button>
</form>
</body>
</html>
