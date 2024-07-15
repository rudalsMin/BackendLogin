<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
	<form action="/deleteMember">
		비밀번호를 입력하세요.
		<input type="text" name="password">
		
		<input type="submit" value="탈퇴하기">
		
		<input type="hidden" name="userid" value="${current}">
	</form>
	</body>
</html>