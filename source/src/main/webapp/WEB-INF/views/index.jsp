<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<script>
		var loginok = '<%=(String)session.getAttribute("loginok")%>';
		if(loginok != "" && loginok != "null"){
			alert(loginok);
			location.replace("/loginok");
		}
	</script>
	<body>
		<form name="calc" method="GET" action="/login">
			<input type="text" name="id"><br>
			<input type="password" name="password">
			<input type="submit" value="로그인">
		</form>
		<input type="button" value="회원가입" onclick="javascript:location.replace('join.html')">
	</body>
</html>