<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
		<body>
			로그인 성공!<br>
			현재 로그인 ID: ${current}<br>
			<form action="/update">
				Id : <input type="text" name="id" value="${current}" required><br>
				Password : <input type="password" name="password" required>
				주소 : <input type="text" name="addr" value="${addr}" required>
				<input type="submit" value="수정하기">
			</form>
			<form action="/logout">
				<input type="submit" value="로그아웃">
			</form>
			<form action="/delete">
				<input name="userid" type="hidden" value="${current}">
				<input type="submit" value="탈퇴">
			</form>
			<input type="submit" value="책정보 입력" onClick="javascript:location.replace('addbook.html')">
			<input type="submit" value="책 리스트 보기" onClick="javascript:location.replace('/list')">
		</body>
	</html>