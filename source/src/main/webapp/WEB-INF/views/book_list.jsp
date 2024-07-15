<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 정보가 리스트 형태로 넘어왔기 때문에 c 써야함 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List Page</title>
</head>
<body>
	<h1>도서 목록 보기</h1>
	<table>
		<tr>
			<td>검색</td>
			<td>
				<form action="/searchBook">
					<input type="text" name="searchText">
					<input type="submit" value="검색">
				</form>
			</td>
		</tr>
		<c:forEach items="${bookList}" var="item">
			<tr>
				<td>도서명</td>
				<td>${item.name}</td>
			</tr>
			<tr>
				<td>저자</td>
				<td>${item.author}</td>
			</tr>
			<tr>
				<td>책 정보</td>
				<td>${item.info}</td>
			</tr>
			<tr>
				<td>ISBN</td>
				<td>${item.isbn}</td>
			</tr>
			<tr>
				<td>출판일자</td>
				<td>${item.publishDate}</td>
			</tr>
			<tr>
				<td>도서 삭제하기</td>
				<td>
					<form action="/deleteBook">
					<input type="hidden" name="id" value="${item.id}">
					<input type="submit" value="삭제">
					</form>
				</td>
			</tr>
			<tr>
				<td bgcolor="black" height="2px" colspan=2></td>
			</tr>
		</c:forEach>
	</table>
	<form action="/MyPage">
		<input type="submit" value="마이페이지">
	</form>
</body>
</html>