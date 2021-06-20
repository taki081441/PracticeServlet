<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String err_mesg = (String) request.getAttribute("err_messages");
String err_mesg_red = null;
if (err_mesg == null) {
	err_mesg_red = "";
} else {
	err_mesg_red = "※" + err_mesg;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>一番目のファイル</title>
<link rel="stylesheet" href="css/errmessage.css">
</head>
<body>
	<header class="header1-background" role="banner">
		<%@ include file="/WEB-INF/jsp/TMAFheader.jsp" %>
	</header>
	<br /> こんにちは、下民。
	<br> 株式会社TMAF代表取締役兼社長の吉田拓海です。
	<br> 入社を希望するものは以下に氏名、パスワードを入力し、送信ボタンを押下しろ。
	<br> よろ。
	<br>
	<br>
	<form action="first" method="post" id="submit1">
		<p class="simeistyle">
			氏名：<br> <input type="text" name="simei" id="simei" /><br>
		</p>
		パスワード：<br> <input type="text" name="pass" id="pass"
			autocomplete="off" /><br> パスワード(確認)：<br> <input
			type="password" name="cnfpass" id="cnfpass" autocomplete="off" /><br>
		<p class="redstring"><%=err_mesg_red%></p>
		<br> 好きなチーム：<br> <input type="text" name="jteam" id="j" /><br>

		<select name="aaa">
			<option value="null"></option>
			<option value="a">a</option>
			<option value="b">b</option>
			<option value="c">c</option>
		</select> <br> <br> <input id="submit" type="submit" value="送信">
	</form>

	<%@ include file="/WEB-INF/jsp/TMAFfotter.jsp"%>
</body>
<script type="text/javascript" src="js/hantei.js"></script>
</html>