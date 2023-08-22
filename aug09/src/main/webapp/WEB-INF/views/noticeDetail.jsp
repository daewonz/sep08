<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> ❤ 글쓰기</title>
<link href="css/styles.css" rel="stylesheet" />
<script src="./js/jquery-3.7.0.min.js"></script>
<style type="text/css">
#main{
	margin: 0 auto;
	width:95%;
	margin-top: 60px;
	color: black;
}
#detail{
	background-color: white;
	margin: 0 auto;
	width: 90%;
	height: auto;
	margin-top: 15px;
	color: black;
	padding: 10px;
	box-sizing: border-box;
}
#detailH{
	height: 40px;
	line-height: 40px;
	font-size: x-large;
	border-bottom: 1px solid black;
	box-sizing: border-box;
	overflow: hidden;
}
#detailIdDate{
	height: 50px;
	line-height: 30px;
	background-color: #D3D3D3;
	border-bottom: 1px gray solid;
	padding:10px;
	box-sizing: border-box;
}
#detailID, #detailDate{
	width: 45%;
	float: left;
	text-align: left;
}
#detailDate{
	float: right;
	text-align: right;
}
#detailContent{
	padding:10px;
	min-height:300px;
	height: auto;
	border-bottom: 1px solid white;
	box-sizing: border-box;
	text-align: left;
}
</style>
</head>
<body>
	

		<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
            <div class="container">
                <a class="navbar-brand" href="./"><img src="assets/img/navbar-logo.svg" alt="..." /></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    Menu
                    <i class="fas fa-bars ms-1"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav text-uppercase ms-auto py-4 py-md-0">
                        <li class="nav-item"><a class="nav-link" href="./board">board</a></li>
                        <li class="nav-item"><a class="nav-link" href="./multiboard?board=1">multi board</a></li>
                        <li class="nav-item"><a class="nav-link" href="./notice">notice</a></li>
                        <li class="nav-item"><a class="nav-link" href="./about">about</a></li>
                        <li class="nav-item"><a class="nav-link" href="./login.sik">login</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <script>
        function logout(){
        	if(confirm("ooops! 로그아웃하시겠습니까?")){
        		location.href="./logout.sik";
        	}
        }
        </script>
	<!-- Masthead-->
	<header class="masthead">
		<div class="container">
		<div id="detail">
			<div id="detailH">${detail.ntitle}</div>
			<div id="detailN_no" style="height: 0px; visibility: hidden;">{detail.m_no}</div>
			<div id="detailIdDate">
				<div id="detailID">${detail.m_no}</div>
				<div id="detailDate">${detail.ndate}</div>
			</div>
			<div id="detailContent"><p>${detail.content}<br></p></div>
			실제 파일명 : norifile=board.png	/ 파일명 : ${detail.nrealfile }
			<c:set var="file">${ fn:length(detail.nrealfile)}</c:set>
			<c:set var="file" value="${ fn:length(detail.nrealfile)}"/>
			<br>
			${fn:substring(detail.nrealfile, file-3, file) }
			${fn:contains(detail.nrealfile, '.png') }
			<c:forTokens var="token" items="${detail.nrealfile}" delims="." varStatus="status">
				<c:if test="${status.last }">
					<c:choose>
						<c:when test="${token eq 'png' || token eq 'jpg' || token eq 'jpeg' || token eq 'gif' || token eq 'bmp'}">
							<img alt="" src="../upload/${detail.nrealfile }">
						</c:when>
						<c:otherwise>
						<br>
							<button onclick="location.href ='./download@${detail.nrealfile}'">다운로드</button>
						</c:otherwise>
					</c:choose>
			
				</c:if>
			</c:forTokens>
			<br>
			<img alt="" src ="../upload/${ detail.nrealfile }">
		<button class="btn btn-primary xi-view-list" onclick="location.href='./multiboard'">멀티보드로</button>
		</div>
		</div>
	</header>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="js/scripts.js"></script>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>