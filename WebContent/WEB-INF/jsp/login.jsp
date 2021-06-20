<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>なんでやねん</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<% String aaa = (String)request.getAttribute("userName"); %>
<% String pass = (String)request.getAttribute("password"); %>
とりあえずパスワード晒すわ<br>
<% String favaritoJClub = (String)request.getAttribute("jteam"); %>
<%= aaa %>
<%= pass %>

<p>登録情報</p>

<p>名前 : <%= aaa %></p>
<p>パスワード : <%= pass %></p>
<%-- <% String checkpass = (String)request.getAttribute("err_messages"); %> --%>
<%-- <%= checkpass %> --%>
<p>好きなチーム : <%= favaritoJClub %></p>




GitHub試し

</body>
</html>