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
			<h1>고객 리스트</h1>
			<table class="table">
				<tr>
					<td>customerId</td>
					<td>storeId</td>
					<td>firstName</td>
					<td>lastName</td>
					<td>email</td>
					<td>addressId</td>
					<td>active</td>
					<td>createDate</td>
					<td>updateDate</td>
				</tr>
				<c:forEach var="c" items="${customerList}">
					<tr>
						<td>
							<!-- 고객 상세 정보(주소 X 렌탈 X 지불...조인 발생...) -->
							<a href="">
								${c.customerId}
							</a>
						</td>
						<td>${c.storeId}</td>
						<td>${c.firstName}</td>
						<td>${c.lastName}</td>
						<td>${c.email}</td>
						<td>${c.addressId}</td>
						<td>${c.active}</td>
						<td>${c.createDate}</td>
						<td>${c.lastUpdate}</td>
					</tr>
				</c:forEach>
			</table>
			
			<div>
				<!-- 페이징 -->
				<!-- 이전 11 12 13 14 15 16 17 18 19 20 다음 -->
				<c:if test="${currentPage > 10}">
					<a href="${pageContext.request.contextPath}/on/customerList?currentPage=${currentPage-10}">
						[이전] <!-- if분기 필요 -->
					</a>
				</c:if>
				
				<c:forEach var="num" begin="${startPagingNum}" end="${endPagingNum}">
					<c:if test = "${num == currentPage}">
						${num}&nbsp;
					</c:if>
					<c:if test = "${num != currentPage}">
						<a href="${pageContext.request.contextPath}/on/customerList?currentPage=${num}">
							${num}
						</a>
						&nbsp;
					</c:if>
				</c:forEach>
				<c:if test="${currentPage < endPagingNum}">
					<a href="${pageContext.request.contextPath}/on/customerList?currentPage=${currentPage+10}">
						[다음] <!-- if분기 필요 -->
					</a>
				</c:if>
			</div>
			
			<div>
				<form>
					<input type="text">
					<button type="button">이름검색</buttton>
				</form>
			</div>
	  </div>
    </div>
  </div>
</body>
</html>