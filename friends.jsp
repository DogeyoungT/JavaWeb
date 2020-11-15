<%--
  Created by IntelliJ IDEA.
  User: Iray
  Date: 2017/7/13
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Model.MapUnit" %>
<%@page import="Model.FriendRequest" %>
<%@page import="java.util.*" %>
<html>
<head>
    <title>friends Page</title>
</head>
<body>
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
<br/>
<br/>
<label>用户名： </label> <label>${userInfo.getAcc_username()}</label>
<br/>
<label>邮箱： </label> <label>${userInfo.getAcc_email()}</label>
<br/>
<label>积分： </label> <label>${userInfo.getAcc_credit()}</label>
<br/>
<label>等级： </label> <label>${userInfo.getAcc_rank()}</label>

<form name = "AddFriend" action=" AddFriend.yue" method="post">
    <input type="text" name  = "friendname"/>
    <input type="text" name  = "introduction"/>
    <button name = "AddFriend"onclick="submit()"> AddFriend</button>
</form>
<label>已下是您的好友列表</label>
<%
    String s = String.valueOf(request.getAttribute("coco"));
    if (s!=null && MapUnit.findCurrUser(s).getMy_friend_list() != null) {
        ArrayList<String> arrayList = new ArrayList(MapUnit.findCurrUser(s).getMy_friend_list());
        for (String string:arrayList) {
%>
    <label>名称：</label><label><%=string%></label><br>
<form name = "deletefriend" action = "deletefriend.yue"method="post">
    <input type = "hidden" name="friendname" value="<%=string%>"/>
    <button type="submit" name = "deletefriendbutton">删除Ta</button><br>
</form>
<form name  = "sendmessage" action="tosendmessage.yue"method="post" >
    <button type="submit" name = "sendmessagebutton">发送消息</button><br>
</form>
<%}
}%>
<br>
<br>
<br>
<br>
<label>以下是好友申请：</label>
<%
if (s!=null && MapUnit.findCurrUser(s).getMy_friend_require_list()!= null) {
ArrayList<FriendRequest> arrayList = new ArrayList(MapUnit.findCurrUser(s).getMy_friend_require_list());
    for (FriendRequest friendRequest:arrayList) {
    %>
    <form action = "ConfirmFriend.yue" method="post">
        <label>申请人：</label><label><%=friendRequest.getFriend_request_send()%></label><br>
        <label>验证消息：</label><label><%=friendRequest.getIntroduction()%>></label>
        <input type = "hidden" name="friendname" value="<%=friendRequest.getFriend_request_send()%>"/>
        <button type="submit" name = "addfriendbutton" >确认添加Ta</button><br>
    </form>
        <%}
}%>
</body>

</html>
