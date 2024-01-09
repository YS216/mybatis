<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		margin: 0 auto;
		text-align:center;
	}
	.outer{
		width:700px;
		text-align:center;
	}
    #list-area {
    	width:100%;
        border: 1px solid;
        text-align: center;
        border-collapse: collapse;
    }
    #list-area>thead>th{
        border: 1px solid;
    }
    #list-area>tbody>td{
        border: 1px solid;
        border-collapse: collapse;
    }
    #search-area{text-align: center;}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	
    <div class="outer" align="center">
        <h1 align="center">게시판</h1>

        <div id="search-area">
            <form action="search.bo" method="get">
                <select name="keyField">
                    <option value="writer">작성자</option>
                    <option value="title">제목</option>
                    <option value="content">내용</option>
                </select>
                <input name="keyWord" value="${keyWord}">
                <button type="submit">검색</button>
                <input type="hidden" name="nowPage" value="1">
            </form>
        </div>
        <br>
        totalRecord : ${ pi.totalRecord }
        <table id="list-area" align="center">
            <thead>
                <th width="15%">글번호</th>
                <th width="35%">제목</th>
                <th width="15%">작성자</th>
                <th width="15%">조회수</th>
                <th width="20%">작성일</th>
            </thead>
            <tbody>
				<c:forEach var="b" items="${list}" varStatus="s">
					<tr>
						<%-- <td>${b.board_no}</td> --%>
						<td>${s.count}</td>
						<td>${b.board_title}</td>
						<td>${b.board_writer}</td>
						<td>${b.count}</td>
						<td>${b.create_date}</td>
					</tr>
				</c:forEach>
            </tbody>
        </table>
        <br>
        <div id="paging-area">
        	<!-- [이전] -->
			<c:if test="${pi.nowPage ne 1}">
				<c:choose>
					<c:when test="${empty keyWord}">
						<a href="list.bo?nowPage=${pi.nowPage-1}">[이전]</a>
					</c:when>
					<c:otherwise>
						<a href="">[이전]</a>
					</c:otherwise>
				</c:choose>
			</c:if>
			
			<!-- [1][2][3] -->
			<c:forEach var="p" begin="${pi.startPage}" end="${pi.endPage}">
				<c:choose>
					<c:when test="${empty keyWord}">
						<c:choose>
							<c:when test="${p eq pi.nowPage}">
								<a href="list.bo?nowPage=${p}" style="color:hotpink">[${p}]</a>
							</c:when>
							<c:otherwise>
								<a href="list.bo?nowPage=${p}">[${p}]</a>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<a href="">[${p}]</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<!-- [다음] -->
			<c:if test="${pi.nowPage ne pi.totalPage}">
				<c:choose>
					<c:when test="${empty keyWord}">
						<a href="list.bo?nowPage=${pi.nowPage+1}">[다음]</a>
					</c:when>
					<c:otherwise>
						<a href="">[다음]</a>
					</c:otherwise>
				</c:choose>
			</c:if>
        </div>
    </div>
</body>
</html>