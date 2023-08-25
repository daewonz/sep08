<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin || 멀티보드</title>
<link rel="stylesheet" href="../css/admin.css">
<link rel="stylesheet" href="../css/multiboard.css">
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>

	<%@ include file="menu.jsp"%>
	<div class="container">
		<div class="main">
			<div class="article">
				<div class="divTable minimalistBlack">
					<div class="divTableHeading">
						<div class="divTableRow">
							<div class="divTableHead">번호</div>
							<div class="divTableHead">카테고리</div>
							<div class="divTableHead">이름</div>
							<div class="divTableHead">url</div>
							<div class="divTableHead">참고</div>
						</div>
					</div>
					<div class="divTableBody">
						<c:forEach items="${setupBoardList }" var="row">
							<div class="divTableRow">
								<div class="divTableCell">${row.b_no }</div>
								<div class="divTableCell">${row.mb_cate }</div>
								<div class="divTableCell">${row.b_catename }</div>
								<div class="divTableCell">${row.b_url }</div>
								<div class="divTableCell">${row.b_comment }</div>
							</div>
						</c:forEach>
					</div>
					<!--  새로 입력하는 form 입니다. -->
					<div class="divTableFoot tableFootStyle">
						<div class="divTableRow"></div>
					</div>
				</div>
					<div class="dd">
					<form action="./multiboard" method="post">
					
						<input type="text" name="mb_cate" required="required" placeholder="카테고리 번호 입력">
						<input type="text" name="catename" required="required" placeholder="게시판 이름 입력">
						<input type="text" name="comment" required="required" placeholder="참고를 남겨주세요">
						<button type="submit">저장</button>
					</form>
					</div>
			</div>
		</div>
	</div>
</body>
</html>