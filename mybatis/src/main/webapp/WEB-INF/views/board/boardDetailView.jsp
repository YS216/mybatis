<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<title>Insert title here</title>
<style>
	#detail{width:100%; margin-top: 50px;}
	#detail td{height:25px;}
	.c1 {background-color:#AEC184;}
	.c2 {background-color:#E4F7BA;}
	a {text-decoration:none; color:black; cursor:pointer;}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	
	<div class="outer">
		<table align="center" id="detail">
			<tr>
				<th colspan="4" bgcolor="#66793C" height="30"><font color="#fff">글 읽 기</font></th>
			</tr>
			<tr>
				<td width="15%" class="c1" align="center">성명</td>
				<td width="35%" class="c2">${b.board_writer}</td>
				<td width="15%" class="c1" align="center">등록날짜</td>
				<td class="c2">${b.create_date}</td>
			</tr>
			<tr>
				<td class="c1" align="center">제목</td>
				<td colspan="3" class="c2">${b.board_title}</td>
			</tr>
			<tr>
				<td colspan="4">
					<br><b>본문내용 :</b>
					<br><pre>${b.board_content}</pre><br></td>
			</tr>
			<tr>
				<td colspan="4" align="right">조회수 : ${b.count}</td>
			</tr>	
		</table>
		
		<br>
		
		<table align="center" style="width:100%;">
			<tr>
				<th width="15%">댓글작성</th>
				<th width="70%"><textarea cols="70" rows="3" id="replyContent"></textarea></th>
				<th width="15%"><button onclick="insertReply();">등록</button></th>
			</tr>
			<tr>
				<td colspan="3"  style="text-align: right;">댓글의 총 갯수 : ${list.size()}</td>
			</tr>
			
			<c:forEach var="r" items="${list}">
				<tr>
					<td>${r.reply_writer}</td>
					<td>${r.reply_content}</td>
					<td>${r.create_date}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<script>
		function insertReply() {
			$.ajax({
				url: "rinsert.bo",	// ReplyInsertController   /rinsert.bo
				data: {
					bnum:${b.board_no},
					userId:"${loginUser.user_id}",
					content:$("#replyContent").val()
				},
				type: "post",
				success:function(result) {
					location.reload();
				},
				error:function(){
					console.log("댓글 등록 ajax통신 실패");
				}
			})
		}
	</script>
</body>
</html>