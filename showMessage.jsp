<%--
  Created by IntelliJ IDEA.
  User: zhangzheyu
  Date: 2017/7/17
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="Model.MapUnit" %>
<%@page import="Model.Message" %>
<%@page import="java.util.*" %>
<html>
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
<form name = "ShowMessage" action = "ShowMessage.yue" method="post">
    <button name = "Messagetype" value="systemmessage" onclick="submit()" > 系统消息</button>
    <button name = "Messagetype" value="friendmessage" onclick="submit()" >朋友消息</button>
</form>
<label>下面是系统消息: </label><br>
<%String s = String.valueOf(request.getAttribute("coco"));
    if (s!=null && MapUnit.findCurrUser(s).getMy_system_message_list() != null) {
        ArrayList<Message> arrayList1 = new ArrayList<>(MapUnit.findCurrUser(s).getMy_system_message_list());
%>
<%for (Message message:arrayList1) { %>


    <label>任务：</label><label><%=message.getTask_title()%></label>
    <label>已被 </label><label><%=message.getMessage_sender()%></label>
    <label>于 </label><label><%=message.getMessage_date()%></label>
    <label><%= message.getMessage_details()%></label>
    <%if (message.getIsread().equals("unread")){%>

    <form action="readMessage.yue" method="post">
        <input type="hidden" name = "taskid" value="<%=message.getTask_id()%>"/>
        <input type="hidden" name = "sender" value="<%=message.getMessage_sender()%>"/>
        <input type="hidden" name = "receiver" value="<%=message.getMessage_receiver()%>"/>
        <input type="hidden" name = "details" value="<%=message.getMessage_details()%>"/>
        <input type="hidden" name = "date" value="<%=message.getMessage_date()%>"/>
        <button type="submit" name ="read" >已读</button>
    </form>
    <%}
   }
}%>
    <label>下面是好友消息: </label><br>
        <%
    if (s!=null && MapUnit.findCurrUser(s).getMy_friend_message_list() != null) {
        ArrayList<Message> arrayList1 = new ArrayList<>(MapUnit.findCurrUser(s).getMy_friend_message_list());
%>
        <%for (Message message:arrayList1) { %>



        <label>来自你的好友：</label><label><%=message.getMessage_sender()%></label>
        <label> </label><label><%=message.getMessage_details()%></label>
        <label><%=message.getMessage_date()%></label>
        <%if (message.getIsread().equals("unread")){%>

        <form name = "SendMessage" action="SendMessage.yue" method="post">
            <input type="hidden" name = "sender" value="<%=message.getMessage_sender()%>"/>
            <input type="hidden" name = "receiver" value="<%=message.getMessage_receiver()%>"/>
            <input type="hidden" name = "details" value="<%=message.getMessage_details()%>"/>
            <input type="hidden" name = "date" value="<%=message.getMessage_date()%>"/>
            <button type = "submit" name ="answer">回复</button>
        </form>
        <%}
   }
}%>
</body>
</html>
