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
	        }
	        /* 배우 목록 카드 스타일 */
	        .actor-card {
	            background-color: #ffffff;
	            border-radius: 10px;
	            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	            margin-bottom: 20px;
	            padding: 20px;
	            text-align: center;
	            transition: transform 0.3s ease-in-out;
	        }
	        .actor-card:hover {
	            transform: translateY(-10px);
	            box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
	        }
	        .actor-card img {
	            border-radius: 50%;
	            width: 120px;
	            height: 120px;
	            object-fit: cover;
	            margin-bottom: 15px;
	        }
	        .actor-name {
	            font-size: 1.1rem;
	            font-weight: bold;
	            color: #333;
	        }
	        .actor-role {
	            color: #777;
	            font-size: 0.9rem;
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
	   			
	    <div class="col-sm-6">
	    
	    	<!-- 제목 추가 -->
	        <h2 class="text-center mb-4">영화 정보</h2>
	        <table class = "table table-striped">
	        	<tr>
	        		<td class = "bold-center" >filmId</td>
	        		<td>${film.filmId}</td>
	        	</tr>
	        	<tr>
	        		<td class="bold-center" >title</td>
	        		<td>${film.title}</td>
	        	</tr>
	        	<tr>
	        		<td class = "bold-center" >description</td>
	        		<td>${film.description}</td>
	        	</tr>
	        	<tr>
	        		<td class = "bold-center" >releaseYear</td>
	        		<td>${film.releaseYear}</td>
	        	</tr>
	        	<tr>
	        		<td class = "bold-center" >rentalDuration</td>
	        		<td>${film.rentalDuration}</td>
	        	</tr>
	        	<tr>
	        		<td class = "bold-center" >rentalRate</td>
	        		<td>${film.rentalRate}</td>
	        	</tr>
	        	<tr>
	        		<td class = "bold-center" >length</td>
	        		<td>${film.length}</td>
	        	</tr>
	        	<tr>
	        		<td class = "bold-center" >replacementCost</td>
	        		<td>${film.replacementCost}</td>
	        	</tr>
	        	<tr>
	        		<td class = "bold-center" >lastUpdate</td>
	        		<td>${film.lastUpdate}</td>
	        	</tr>
	        	<tr>
	        		<td class = "bold-center" >originalLanguageId</td>
	        		<td>${film.originalLanguageId}</td>
	        	</tr>
	        	<tr>
	        		<td class = "bold-center" >language</td>
	        		<td>${film. language}</td>
	        	</tr>
	  	    </table>
	        
	        <br>
	        
	        <div>
	        	<h2 class="text-center mb-4" >출연배우</h2>
	        	<div class="row">
	        		<c:forEach var="a" items="${actorList}">
	        			<div class="col-md-4 mb-3">
	        				<div class="actor-card">
	        					<!-- 배우 이미지 (예시로 기본 이미지 URL 사용) -->
	        					<img src="https://via.placeholder.com/120" alt="${a.firstName} ${a.lastName}">
	        					<a href="${pageContext.request.contextPath}/on/actorOne?actorId=${a.actorId}">
	        						<div class="actor-name">${a.firstName} ${a.lastName}</div>
	        					</a>
	        					<!-- 배우의 역할 또는 기타 정보 추가 가능 -->
	        					<div class="actor-role">배우의 역할/기타 정보</div>
	        				</div>
	        			</div>
	        		</c:forEach>
	        	</div>
	        </div>
	        
	  </div>
    </div>
  </div>
</body>
</html>