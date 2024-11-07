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
			    table-layout: fixed; /* 테이블 레이아웃을 고정 */
			}
			
			th, td {
			    padding: 12px; /* 셀 여백 */
			    text-align: left; /* 텍스트 기본 왼쪽 정렬 */
			    border: 1px solid rgba(0, 0, 0, 0.2); /* 연한 회색 셀 경계 */
			}
			
			td:first-child, th:first-child {
			    width: 20%; /* 첫 번째 열의 너비 설정 */
			}
	        .bold-center {
	            text-align: center; /* 가운데 정렬 */
	            font-weight: bold; /* 굵게 */
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
			.table {
    			border: 1px solid rgba(0, 0, 0, 0.2); /* 연한 회색 외곽선 */
			}
			.table th, .table td {
    			border: 1px solid rgba(0, 0, 0, 0.2); /* 연한 회색 셀 경계 */
			}
		    .btn-custom {
	        background-color: #d3d3d3; /* 연한 그레이 색상 */
	        color: #000; /* 텍스트 색상 */
	        font-size: 0.85rem; /* 글자 크기 줄이기 */
	        padding: 8px 12px; /* 패딩 조정 */
	        border: none; /* 테두리 제거 */
	        border-radius: 4px; /* 모서리 둥글게 */
	  	    }
	   	    .btn-custom:hover {
	        background-color: #b0b0b0; /* 호버 시 더 어두운 그레이색 */
	</style>
</head>
<body>
	<div class="container-fluid">
	       <div class="row">
	           <div class="col-sm-2">
	               <!-- leftMenu.jsp include -->
	        		<c:import url="/WEB-INF/view/on/inc/leftMenu.jsp"></c:import>
	   		   </div>
	   			
	    <div class="col-sm-6">
	        <h2 class="text-center mb-4">영화 추가</h2> <!-- 제목 추가 -->
	        
	        <form method="post" action="${pageContext.request.contextPath}/on/addFilm">
	        	
	        	<table class="table table-striped">
	        		<tr>
	        			<td colspan="2" class="fw-bold">필수 항목</td>
	        		</tr>
	        		<tr>
	        			<td>title</td>
	        			<td>
	        				<input type="text" id="title" name="title">
	        			</td>
	        		</tr>

	        		<tr>
	        			<td>languageId</td>
	        			<td>
	        				<select id="languageId" name="languageId">
	       						<option value="">언어선택</option>	
	        					<c:forEach var="la" items="${languageList}">
	        						<option value="${la.languageId}">${la.name}</option>	
	        					</c:forEach>
	        				</select>
	        			</td>
	        		</tr>
	        		
	        		<tr>
	        			<td>rentalDuration</td>
	        			<td>
	        				<!-- DB기본값 : 3 -->
	        				<input type="number" id="rentalDuration" name="rentalDuration" value="3">
	        			</td>
	        		</tr>
	        		
	        		<tr>
	        			<td>rentalRate</td>
	        			<td>
	        				<!-- DB기본값 : 4.99 -->
	        				<input type="number" id="rentalRate" name="rentalRate" value="4.99">
	        			</td>
	        		</tr>
	        		
	        		<tr>
	        			<td>replacementCost</td>
	        			<td>
	        				<!-- DB기본값 : 19.99 -->
	        				<input type="number" id="replacementCost" name="replacementCost" value="19.99">
	        			</td>
	        		</tr>
	        		
	        		<tr>
	        			<td>rating</td>
	        			<td>
	        				<!-- radio, enum(G, PG, PG-13, $, NC-17), DB기본값 : 'G' -->
							<input type="radio" name="rating" class="rating" value="G">G<br>	        				
							<input type="radio" name="rating" class="rating" value="PG">"PG"<br>	        				
							<input type="radio" name="rating" class="rating" value="PG-13">PG-13<br>	        				
							<input type="radio" name="rating" class="rating" value="R">R<br>	        				
							<input type="radio" name="rating" class="rating" value="NC-17">NC-17	        				
	        			</td>
	        		</tr>
	        		</table>
	        		
	        		<!-- 선택적 항목 -->
	        		<table class="table table-striped">
		        		<tr>
		        			<td colspan="2" class="fw-bold">선택적 항목</td>
		        		</tr>
		        		<tr>
		        			<td>length</td>
		        			<td>
		        				<input type="number" id="length" name="length">분
		        			</td>
		        		</tr>
		        		
		        		<tr>
		        			<td>originalLanguageId</td>
		        			<td>
		        				<select id="originalLanguageId" name="originalLanguageId">
		        						<option value="">오리지널언어선택</option>	
		        					<c:forEach var="la" items="${languageList}">
		        						<option value="${la.languageId}">${la.name}</option>	
		        					</c:forEach>
		        				</select>
		        			</td>
		        		</tr>
		        		
		        		<tr>
		        			<td>releaseYear</td>
		        			<td>
		        				<input type="number" id="releaseYear" name="releaseYear">
		        			</td>
		        		</tr>
		        		
		        		<tr>
		        			<td>specialFeatures</td>
		        			<td>
		        				<!-- checkbox
		        					, set('Trailers',-->
		        				<input type="checkbox" name="specialFeatures" class="specialFeatures"
		        						value="Trailers">Trailers<br>
		        				<input type="checkbox" name="specialFeatures" class="specialFeatures"
		        						value="Commentaries">Commentaries<br>
		        				<input type="checkbox" name="specialFeatures" class="specialFeatures"
		        						value="Deleted Scenes">Deleted Scenes<br>
		        				<input type="checkbox" name="specialFeatures" class="specialFeatures"
		        						value="Behind the Scenes">Behind the Scenes<br>
		        			</td>
		        		</tr>
		        		
		        		<tr>
		        			<td>description</td>
		        			<td>
		        				<textarea rows="3" cols="50" id="description" name="description"></textarea>
		        			</td>
		        		</tr>
	  
	        		</table>
	        	
	        	<button id="btnAddFilm" type="button">addFilm</button>
	        </form>
	  </div>
    </div>
  </div>
</body>
<script>
	$('#btnAddFilm').click(function() {
		// 폼 유효성 검사(제외 description, releaseYear, originalLanguageId, length, specialFeatures)
		if($('#title').val() == '') {
			alert('title을 입력하세요');
		} else if($('#languageId').val() == '') {
			alert('languageId을 입력하세요');			
		} else if($.isNumeric($('#rentalDuration').val()) == false) {
			alert('rentalDuration 숫자를 입력하세요');						
		} else if($.isNumeric($('#rentalRate').val()) == false) {
			alert('rentalRate 숫자를 입력하세요');									
		} else if($.isNumeric($('#replacementCost').val()) == false) {
			alert('replacementCost 숫자를 입력하세요'); 
		} else if($('.rating:checked').length == 0) {
			alert('rating을 선택하세요'); 
		} else {
			$('form').submit();
		}
	});
</script>
</html>