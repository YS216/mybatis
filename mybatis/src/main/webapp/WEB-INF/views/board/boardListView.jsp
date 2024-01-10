<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    #list-area {
    	width:100%;
        border: 1px solid;
        text-align: center;
    	border-collapse: collapse;
    }
    #list-area th, #list-area td{
        border: 1px solid;
        height: 30px;
    }
    
    #ellip {
    	overflow: hidden;  		
		text-overflow: ellipsis;  	
		white-space: nowrap;
    }
    
    #search-area{text-align: center;}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	
    <div class="outer">
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
        <div align="left">총 게시글의 수 : ${ pi.totalRecord }</div>
        <br>
        <table id="list-area" align="center">
            <thead>
                <th width="10%">글번호</th>
                <th width="47%">제목</th>
                <th width="15%">작성자</th>
                <th width="10%">조회수</th>
                <th width="18%">작성일</th>
            </thead>
            <tbody>
				<c:forEach var="b" items="${list}" varStatus="s">
					<tr>
						<%-- <td>${b.board_no}</td> --%>
						<td>${(pi.totalRecord - (pi.nowPage-1)*pi.numPerPage)-s.index}</td>
						<td id="ellip"><a href="detail.bo?bno=${b.board_no}">${b.board_title}</a></td>
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
						<a href="search.bo?nowPage=${pi.nowPage-1}&keyField=${keyField}&keyWord=${keyWord}">[이전]</a>
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
						<c:choose>
							<c:when test="${p eq pi.nowPage}">
								<a href="search.bo?nowPage=${p}&keyField=${keyField}&keyWord=${keyWord}" style="color:hotpink">[${p}]</a>
							</c:when>
							<c:otherwise>
								<a href="search.bo?nowPage=${p}&keyField=${keyField}&keyWord=${keyWord}">[${p}]</a>
							</c:otherwise>
						</c:choose>
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
						<a href="search.bo?nowPage=${pi.nowPage+1}&keyField=${keyField}&keyWord=${keyWord}">[다음]</a>
					</c:otherwise>
				</c:choose>
			</c:if>
        </div>
    </div>
</body>
</html>