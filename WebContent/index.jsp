<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="./js/hantei.js"></script>
<title>一番目のファイル</title>
</head>
<body>
<br/>
こんにちは、下民。<br>
株式会社TMAF代表取締役兼社長の吉田拓海です。<br>
入社を希望するものは以下に氏名、パスワードを入力し、送信ボタンを押下しろ。<br>
よろ。<br>
<br>
<form action="first" method="post">
氏名：<br>
<input type="text" name="simei" id="name"/><br>
パスワード：<br>
<input type="text" name="pass" id="pass" autocomplete="off"/><br>
パスワード(確認)：<br>
<input type="password" name="cnfpass" id="cnfpass" autocomplete="off"/><br>
好きなチーム：<br>
<input type="text" name="jteam" id="j"/><br>
<br><br>

<input id="submit" type="submit" value="送信">

</form>


</body>
</html>