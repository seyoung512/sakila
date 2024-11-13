<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<ul class="list-group">
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/main" class="btn">홈으로</a></li>
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/staffOne" class="active">정보 확인</a></li>
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/logout" class="btn">로그아웃</a></li> 
	
	  <li class="list-group-item">
	  		::: 지점 관리 :::</li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/storeList" class="btn">지점 리스트</a></li>		
	  		<!-- 
	  			StoreMapper.selectStoreList() : List<Map> - store x staff x address
	  			StoreService.getStorList() : List<Map>
	  			GET - /on/storeList - StoreController.storeList() - storeList.jsp  		
	  		-->
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/addStore" class="btn">지점 추가</a></li>	
	  		<!-- 
	  			GET - /on/addStore 
	  				- StoreController.addStore() : staffList 모델추가, search주소검색결과 모델추가 - addStore.jsp
	  		 	
	  		 	StoreMapper.insertStore() : Integer
	  		 	StoreService.addStore() : Integer
	  		 	POST - /on/addStore - StroeController.addStore(Store)
	  		 	
	  		 -->
	  <li class="list-group-item bg-light">
			<a href="${pageContext.request.contextPath}/on/addInventory" class="btn">인벤토리 추가</a></li>
	
	  <!-- ------------------------------------------------------------------------ -->		
	  
	  <li class="list-group-item">
	  		::: STAFF 관리 :::</li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/staffList" class="btn">스텝 리스트</a></li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/addStaff" class="btn">스텝 추가</a></li>		
	 
	  
	  <!-- 영화관리 부분 -->
	  <li class="list-group-item">
	  		::: 영화 관리 :::</li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/categoryList" class="btn">카테고리 리스트</a></li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/addCategory" class="btn">카테고리 추가</a></li>			
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/languageList" class="btn">언어 리스트</a></li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/addLanguage" class="btn">언어 추가</a></li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/filmList" class="btn">영화 리스트</a></li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/addFilm" class="btn">영화 추가</a></li>			
	  
	  
	  <li class="list-group-item">
	  		::: 고객 관리 :::</li>		
	  <li class="list-group-item">
	  		<a href="" class="btn">고객 리스트</a></li>		
	  <li class="list-group-item">
	  		<a href="">고객 추가</a></li>		
	  
	  <li class="list-group-item">
	  		::: 배우 관리 :::</li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/actorList" class="btn">배우 리스트</a></li>		
	  <li class="list-group-item">
	  		<a href="${pageContext.request.contextPath}/on/addActor" class="btn">배우 추가</a></li>		
</ul>