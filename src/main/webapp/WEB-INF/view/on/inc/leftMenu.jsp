<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<ul class="list-group">
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/main">홈으로</a></li>
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/staffOne">${loginStaff.username}님</a></li>
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/logout">로그아웃</a></li> 
	  
	  <li class="list-group-item">
	  		::: 지점 관리 :::</li>		
	  <li class="list-group-item">
	  		<a href="">지점 추가</a></li>		
	  <li class="list-group-item">
	  		<a href="">지점 추가</a></li>	
	  		
	  <li class="list-group-item">
	  		::: STAFF 관리 :::</li>		
	  <li class="list-group-item">
	  		<a href="">STAFF 추가</a></li>		
	  <li class="list-group-item">
	  		<a href="">STAFF 수정</a></li>		
	 
	  <li class="list-group-item">
	  		::: 고객 관리 :::</li>		
	  <li class="list-group-item">
	  		<a href="">고객 추가</a></li>		
	  <li class="list-group-item">
	  		<a href="">고객 수정</a></li>		
</ul>