<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
	<!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
    <script src="./js/jquery-3.7.0.min.js"></script>
	<style type="text/css">
		
	</style>
	<script type="text/javascript">
	$(function(){
		
	});
	</script>
</head>
<body>
<%@ include file="menu.jsp" %>
 <!-- Masthead-->
        <header class="masthead">
            <div class="container">
          			<table class="table table-dark table-hover table-striped">
               		<thead>
               		<tr class="row">
               			<th class="col-1">번호</th>
               			<th class="col-5">제목</th>
               			<th class="col-2">글쓴이</th>
               			<th class="col-2">날짜</th>

               		</tr>
               		</thead>
               		
               		<c:forEach items="${list }" var="list">
               		
               			
               			<tr class="row detail">
               			<td class="col-1">${list.nno}</td>
               			<td class="col-5 title">${list.ntitle}</td>
               			<td class="col-2">${list.m_no}</td>
               			<td class="col-2">${list.ndate}</td>
               		
               		</tr>
          
               			<tbody>
               		
               		
               	
               		</c:forEach>
               		</tbody>
               </table>
               
            </div>
        </header>

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>