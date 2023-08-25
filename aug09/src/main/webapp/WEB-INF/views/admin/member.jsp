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
	
	<style type="text/css">
	.white{
	background-color: white;
	}
	.yellow{
	background-color: yellow;
	}
	</style>
	<script type="text/javascript">
	function gradeCh(mno, name, value){
		//alert(mno + name + "님을 변경하나연 ");
		//let select = document.getElementById("grade");
		//let selectName = select.options[select.selectedIndex].text;
		//let selectValue = select.options[select.selectedIndex].value;
		//alert(selectName + " : " + selectValue);
		//alert(value);
		if(confirm(name+" 님의 등급을 변경하시겠습니까?")){
			location.href="./gradeChange?mno="+mno+"&grade="+value;
			
		}
	}
	</script>
	
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
							<div class="divTableHead">아이디</div>
							<div class="divTableHead">이름</div>
							<div class="divTableHead">가입날짜</div>
							<div class="divTableHead">주소</div>
							<div class="divTableHead">생일</div>
							<div class="divTableHead">mbti</div>
							<div class="divTableHead">성별</div>
							<div class="divTableHead">등급</div>
						</div>
					</div>
					<div class="divTableBody">
						<c:forEach items="${list }" var="row">
							<div class="divTableRow <c:if test="${row.m_grade gt 4}"> white</c:if> <c:if test="${row.m_grade gt 5}"> yellow</c:if>">
								<div class="divTableCell">${row.m_no }</div>
								<div class="divTableCell">${row.m_id }</div>
								<div class="divTableCell">${row.m_name  }</div>
								<div class="divTableCell">${row.m_joindate }</div>
								<div class="divTableCell">${row.m_addr  }</div>
								<div class="divTableCell">${row.m_birth  }</div>
								<div class="divTableCell">${row.m_mbti }</div>
								<c:choose>
								<c:when test="${row.m_gender eq 0}">
								<div class="divTableCell"><i class="xi-man"></i>♂</div>
								</c:when>
								<c:otherwise>
								<div class="divTableCell"><i class="xi-woman"></i>♀</div>
								</c:otherwise>
								</c:choose>
								<div class="divTableCell">${row.m_grade }
									<select id="grade" onchange="gradeCh(${row.m_no },'${row.m_name  }', this.value )">
										<optgroup label="로그인불가">
											<option value="0" <c:if test="${row.m_grade eq 0 }"> selected="selected"</c:if>>강퇴</option>
											<option value="1" <c:if test="${row.m_grade eq 1 }"> selected="selected"</c:if>>탈퇴</option>
											<option value="2" <c:if test="${row.m_grade eq 2 }"> selected="selected"</c:if>>징계</option>
											<option value="3" <c:if test="${row.m_grade eq 3 }"> selected="selected"</c:if>>유배</option>
											<option value="4" <c:if test="${row.m_grade eq 4 }"> selected="selected"</c:if>>징역</option>
										</optgroup>
										<optgroup label="로그인가능">
										<option value="5"<c:if test='${row.m_grade eq 5 }'> selected="selected"</c:if>>평민</option>
											<option value="6" <c:if test='${row.m_grade eq 6 }'> selected="selected"</c:if>>일반관리자</option>
											<option value="7" <c:if test='${row.m_grade eq 7 }'> selected="selected"</c:if>>게시판관리자</option>
											<option value="8" <c:if test='${row.m_grade eq 8 }'> selected="selected"</c:if>>가입관리자</option>
											<option value="9" <c:if test='${row.m_grade eq 9 }'> selected="selected"</c:if>>최고관리자</option>
										</optgroup>
									</select>
								</div>
								
							</div>
						</c:forEach>
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