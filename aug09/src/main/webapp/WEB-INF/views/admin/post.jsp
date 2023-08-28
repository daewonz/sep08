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
<script src="../js/jquery-3.7.0.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".detail").hide();
		$(".title").click(function(){
			let mbno = $(this).siblings(".mbno").html();
			//alert(mbno);
			
			if(mbno != null || mbno != ""){
				$.ajax({
					url : "./postDetail",
					type : "get",
					data : {mbno : mbno},
					dataType : "json",
					success:function(data){
						//alert(data.detail.m_name);
						$(".detail").append("<div class='divTable minimalistBlack'>");
							$(".detail").append("<div class='divTableHeading'>");
							$(".detail").append("<div class='divTableRow'>");
								$(".detail").append("<div class='divTableHead'>게시글 번호</div>");
								$(".detail").append("<div class='divTableHead'>이름</div>");
								$(".detail").append("<div class='divTableHead'>시간</div>");
								$(".detail").append("<div class='divTableHead'>내용</div>");
							$(".detail").append("</div>");
							$(".detail").append("</div>");
							$(".detail").append("<div class='divTableBody'>");
							$(".detail").append("<div class='divTableRow'>");
								$(".detail").append("<div class='divTableCell'>"+data.detail.mb_no+"</div>");
								$(".detail").append("<div class='divTableCell'>"+data.detail.m_name+"</div>");
								$(".detail").append("<div class='divTableCell'>"+data.detail.mb_date+"</div>");
								$(".detail").append("<div class='divTableCell'>"+data.detail.mb_content+"</div>");
							$(".detail").append("</div>");
							$(".detail").append("</div>");
						$(".detail").append("</div>");
						$(".detail").show('slow');
						
						
					},
					error:function(error){
						alert("ㅠㅠ");
					}
					
					
					
				});//ajax 끝
				
				
			}
			
		});
		
	
	
});
</script>
</head>

<body>

	<%@ include file="menu.jsp"%>
	<div class="container">
		<div class="main">
			<div class="article">
				<div>현재 멀티보드에 ${list[0].count }개의 글이 있습니다.</div>

				<div class="boardList">
					<button onclick="location.href='./post?cate=0'">전체 게시판</button>
					<c:forEach items="${boardList }" var="row">
						<button onclick="location.href='./post?cate=${row.mb_cate}'">${row.b_catename }</button>
					</c:forEach>
					<form action="./post" method="get">
						<select name="searchN">
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="nick">글쓴이</option>
							<option value="id">ID</option>
						</select> <input type="text" name="searchV" required="required"> <input
							type="hidden" name="cate" value="${param.cate }">
						<button type="submit">검색</button>
					</form>
				</div>

				<div class="divTable minimalistBlack">
					<div class="divTableHeading">
						<div class="divTableRow">
							<div class="divTableHead">번호</div>
							<div class="divTableHead">카테고리</div>
							<div class="divTableHead">제목</div>
							<div class="divTableHead">글쓴이</div>
							<div class="divTableHead">날짜</div>
							<div class="divTableHead">읽음수</div>
							<div class="divTableHead">삭제</div>
						</div>
					</div>
					<div class="divTableBody">
						<c:forEach items="${list }" var="row">
							<div class="divTableRow">
								<div class="divTableCell mbno">${row.mb_no }</div>
								<div class="divTableCell">${row.b_catename }</div>
								<div class="divTableCell title">${row.mb_title }</div>
								<div class="divTableCell">${row.m_name }(${row.m_id })</div>
								<div class="divTableCell">${row.mb_date }</div>
								<div class="divTableCell">${row.mb_read }</div>
								<div class="divTableCell">${row.mb_del }</div>

							</div>
						</c:forEach>
							<div class="detail">
							</div>
					</div>
					<!--  새로 입력하는 form 입니다. -->
					<div class="divTableFoot tableFootStyle">
						<div class="divTableRow"></div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>