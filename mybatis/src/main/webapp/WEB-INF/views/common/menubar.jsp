<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis</title>
<style>
	a {
		text-decoration: none;
		color: black;
	}
	.nav-area {
		width:100%;
		background-color: black;
		text-align: center;
		color: white;
		height: 42px;
	}
	.nav-area td {
		width: 25%;
		height: 40px;
		vertical-align: middle;
		font-size: 16px;
		font-weight: bold;
	}
	.nav-area td:hover {
		background-color: gray;
		cursor: pointer;
	}
</style>
</head>
<body>
	<h1 align="center">Welcome to AddInEdu Mybatis</h1>
	<br>
	<div class="login-area" align="right">
		<c:choose>
			<c:when test="${ empty loginUser }">
				<form action="login.me" method="post">
					<table>
						<tr>
							<td>아이디</td>
							<td><input name="userId" required></td>
							<td rowspan="2"><button style="height: 50px;">로그인</button></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="userPwd" required></td>
						</tr>
						<tr>
							<td colspan="3" align="center">
								<a href="enrollForm.me">회원가입</a>
								<a href="">아이디/비번찾기</a>
							</td>
						</tr>
					</table>
				</form>
			</c:when>
			<c:otherwise>
				<!-- 로그인 후 -->
				<div>
					<table>
						<tr>
							<td colspan="2">
								<h3>${ loginUser.user_name }님 환영합니다</h3>
							</td>
						</tr>
						<tr>
							<td><a href="">마이페이지</a> /</td>
							<td><a href="logout.me">로그아웃</a></td>
						</tr>
					</table>
				</div>
		 	</c:otherwise>
		 </c:choose>
	</div>

	<br>

	<table class="nav-area" align="center">
		<tr>
			<td>HOME</td>
			<td>공지사항</td>
			<td onclick="location.href='list.bo?nowPage=1'">게시판</td>
			<td>ETC</td>
		</tr> 
	</table>
</body>
</html>