<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<ul class="list-group">
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/main">홈으로</a></li>
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/staffOne" class="active">정보 확인</a></li>
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/logout">로그아웃</a></li> 
	
	  <li class="list-group-item">
	  		::: 지점 관리 :::</li>		
	  <li class="list-group-item">
	  		<a href="">지점 리스트</a></li>		
	  <li class="list-group-item">
	  		<a href="">지점 추가</a></li>	
	  		
	  <li class="list-group-item">
	  		::: STAFF 관리 :::</li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/staffList">스텝 리스트</a></li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/addStaff">스텝 추가</a></li>		
	 
	  <li class="list-group-item">
	  		::: 영화 관리 :::</li>		
	  <li class="list-group-item">
	  		<a href="">영화 리스트</a></li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/addFilm">영화 추가</a></li>		
	 
	  <li class="list-group-item">
	  		::: 통계 :::
	  </li>	
	  
	  <li class="list-group-item">
	  		::: 고객 관리 :::</li>		
	  <li class="list-group-item">
	  		<a href="">고객 리스트</a></li>		
	  <li class="list-group-item">
	  		<a href="">고객 추가</a></li>		
	  
	  <li class="list-group-item">
	  		::: 배우 관리 :::</li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/actorList">배우 리스트</a></li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/addActor">배우 추가</a></li>		
</ul>