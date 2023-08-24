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
					<div class="divTableFoot tableFootStyle">
						<div class="divTableRow"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>