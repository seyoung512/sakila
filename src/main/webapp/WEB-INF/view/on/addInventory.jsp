<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- jQueryGoogleCDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	        body {
	            background-color: #f0f0f0; /* 배경색 */
	            padding: 20px; /* 페이지 여백 */
	        }
	        table {
	            margin: auto; /* 테이블 가운데 정렬 */
	            width: 80%; /* 테이블 너비 */
	            border-collapse: collapse; /* 테이블 경계 겹치기 */
	        }
	        th, td {
	            padding: 12px; /* 셀 여백 */
	            text-align: left; /* 텍스트 기본 왼쪽 정렬 */
	        }
	        .bold-center {
	            text-align: center; /* 가운데 정렬 */
	            font-weight: bold; /* 굵게 */
	        }
	        tr:nth-child(even) {
	            background-color: #f2f2f2; /* 짝수 행 배경색 */
	        }
	        tr:hover {
	            background-color: #ffcccc; /* 마우스 오버 시 색상 변경 */
	        }
			.left-menu-list a {
			    color: #000; /* 기본 텍스트 색상 */
			    text-decoration: none; /* 링크 아래줄 제거 */
			}
			
			.left-menu-list a.active {
			    background-color: #d3d3d3; /* 강조 색상 */
			    color: #000; /* 강조된 텍스트 색상 */
			    font-weight: bold; /* 텍스트 굵게 */
			}
	</style>
</head>
<body>
	<div class="container-fluid">
	       <div class="row">
	           <div class="col-sm-2">
	               <!-- leftMenu.jsp include -->
	        		<c:import url="/WEB-INF/view/on/inc/leftMenu.jsp"></c:import>
	   		   </div>
	   			
	    <div class="col-sm-10">
	        <!-- main content -->
			<h1>인벤토리 추가</h1>
			
			<div>
				<form id="formSearchTitle" 
					method="get" action="${pageContext.request.contextPath}/on/addInventory">
					<input type="hidden" name="storeId" value="${storeId}">
					<input type="text" name="searchTitle" id="searchTitle" value="${searchTitle}">
					<button type="button" id="btnSearchTitle">영화제목검색</button>
				</form>
			</div>
			
			<div>
				<form id="formAddInventory"
					method="post"
					action="${pageContext.request.contextPath}/on/addInventory">
					<table class="table">
						<tr>
							<td>storeId</td>
							<td>
								<input type="text" name="storeId" value="${storeId}" readonly>
							</td>
						</tr>
						<tr>
							<td>filmId</td>
							<td>
								<select size="5" name="filmId" id="filmId">
									<c:forEach var="f" items="${filmList}">
										<option value="${f.filmId}">${f.title}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
					</table>
					<button id="btnAddInventory" type="button">addInventory</button>
				</form>
			</div>
	  </div>
    </div>
  </div>
</body>
<script>
	$('#btnAddInventory').click(function(){
		// console.log($('#filmId').val());
		
		if($('#filmId').val() == null) {
			alert('검색할 영화 제목을 선택하세요');
		} else {
			// console.log($('#filmId').val());
			$('#formAddInventory').submit();
		}
	});


	$('#btnSearchTitle').click(function(){
		if($('#searchTitle').val() == '') {
			alert('검색할 영화 제목을 입력하세요');
		} else {
			$('#formSearchTitle').submit();
		}
	});
</script>
</html>