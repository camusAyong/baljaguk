<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
	<!-- 상단 메뉴바 -->
<c:import url="./view/topmenu.jsp"/>
	<!-- 내용시작 -->
	

<div class="text-center" >
 		<form action="./friendsAddOverlay">
 			<input type="text"  name="friends_email" required/>
 			<button class="btn btn-primary">친구 추가</button>
 		</form>
</div>

 		<table class="table" style="width: 500px; margin-left: auto; margin-right: auto;">
 		<thead class="table-dark" style="text-align: center">
 			<tr>
 				<th style="text-align: center">친구</th>
 				<th style="text-align: center">친구 삭제</th>
 				<th style="text-align: center">친구 차단</th>	
 			</tr>
 			</thead>
 			<c:if test="${empty map.friendsList}">
 				<tr><td colspan="3">친구가 없어요ㅠㅠ</td></tr>
 			</c:if>
 			<c:forEach items="${map.friendsList}" var="friend">
 				<tr>
 					<td style="text-align: center">${friend.friends_email}</td>
 					<td style="text-align: center"><input type="button" onclick="location.href='./friendsDel?friends_email=${friend.friends_email}'" value="삭제"/></td>
 					<td style="text-align: center"><input type="button" onclick="location.href='./friendsBlock?friends_email=${friend.friends_email}'" value="차단"/></td>
 				</tr>
 			</c:forEach>
 		</table>
 
 <nav>
			<ul class="pagination justify-content-center" style="margin-left: auto; margin-right: auto;">
				<c:if test="${map.startPage ne 1}">
				<li class="page-item"><a class="page-link" href="./friendsList?page=${map.startPage-1}"
					aria-label="Previous"> <span aria-hidden="true">&laquo;</span>		
				</a></li>
				</c:if>
				<c:forEach var="i" begin="${map.startPage}" end="${map.endPage}">
				<c:if test="${i ne map.currPage}">
				<li class="page-item"><a class="page-link" href="./friendsList?page=${i}">${i}</a></li>
				</c:if>
				<c:if test="${i eq map.currPage}">
				<li class="page-item active"><a class="page-link" href="./friendsList?page=${i}">${i}</a></li>
				</c:if>
				</c:forEach>
				<c:if test="${map.totalPage ne map.endPage}">
				<li class="page-item"><a class="page-link" href="./friendsList?page=${map.endPage+1}"
					aria-label="Next"> <span aria-hidden="true">&raquo;</span>
				</a></li>
				</c:if>
			</ul>
</nav>
 		 
 		<br/>
 		
 		<table class="table" style="width: 500px; margin-left: auto; margin-right: auto;">
 		 <thead class="table-dark">
 			<tr>
 				<th style="text-align: center">추천 친구</th>
 				<th></th>
 			</tr>
 		 </thead>
 			<c:if test="${empty recomendList}">
 				<tr><td>여행스타일을 등록해주세요!(또는 새로운 추천친구가 존재하지 않습니다!)</td></tr>
 			</c:if>
 			<c:forEach items="${recomendList}" var="friend">
 				<tr>
 					<td style="text-align: center">${friend.email}</td>
 					<td style="text-align: center"><input type="button" onclick="location.href='./friendsAdd?friends_email=${friend.email}'" value="친구추가"/></td>
 				</tr>
 			</c:forEach>
 		</table>
 		
 		<br/>
 		<br/>
 		
 		<div class="text-center" >
 		<form action="./friendsBlockList">
 			<button class="btn btn-primary">차단 리스트 보기</button>
 		</form>
 		</div>
 		
 		</br>
</body>
<script>
var msgMsg = "${msgMsg}";
if(msgMsg != ""){
	alert(msgMsg);
}
</script>
</html>