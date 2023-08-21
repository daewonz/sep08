<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>admin || main</title>
<link rel="stylesheet" href="../css/admin.css">
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
</head>
<body>
	<div class="container">
	<%@ include file="menu.jsp" %>
	
		<div class="main">
			<div class="article">
				<h1>메인영역</h1>
				<div class="box" onclick="url('mulitBoard')">
					게시판 관리
					<div id="comment">게시판을 관리합니다</div>
				</div>
				<div class="box" onclick="url('post')">
					게시글 관리
					<div id="comment">게시글을 관리합니다</div>
				</div>
				<div class="box" style="background-color: green;"  onclick="url('notice')">
					공지사항
					<div id="comment">공지사항을 쓰고 관리합니다</div>
				</div>
				<div class="box" style="background-color: skyblue;" onclick="url('comment')">
					댓글 관리
					<div id="comment">댓글을 관리합니다</div>
					<!-- 대원아 너 글씨 엄청 크게 보는구나..? -->
				</div>
				<div class="box" onclick="url('message')">
					메세지 관리
					<div id="comment">메세지를 관리합니다</div>
				</div>
				<div class="box"onclick="url('mail')">
					 메일 관리
					<div id="comment">메일을 관리합니다</div>
				</div>
				<div class="box"onclick="url('logout')">
					로그아웃
					<div id="comment">로그아웃합니다.</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>