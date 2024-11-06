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
	            text-align: center; /* 모든 셀 내용 가운데 정렬 */
	        }
	        th, td {
	            padding: 12px; /* 셀 여백 */
	            text-align: center; /* 텍스트 가운데 정렬 */
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
	</style>
</head>
<body>
	<div class="container-fluid">
	       <div class="row">
	           <div class="col-sm-2">
	               <!-- leftMenu.jsp include -->
	        		<c:import url="/WEB-INF/view/on/inc/leftMenu.jsp"></c:import>
	   		   </div>
	   			
	    <div class="col-sm-5">
	        <h2 class="text-center mb-4">배우 목록</h2> <!-- 제목 추가 -->
	        <table class="table table-striped">
	        	<tr>
	        		<td class="">actorId</td>
	        		<td>Name</td>
	        	</tr>
	        	<c:forEach var="a" items="${actorList}">
	        		<tr>
	        			<td>${a.actorId}</td>
	        			<td>
	        				<a href="${pageContext.request.contextPath}/on/actorOne?actorId=${a.actorId}">
	        						${a.firstName} ${a.lastName}</a>
	        			</td>
	        		</tr>
	        	</c:forEach>
	        </table>
	        <form id='formSearch' action="${pageContext.request.contextPath}/on/actorList" method="get">
	        	<input type="text" name="searchWord" id="searchWord">
	        	<button id="btnSearch">이름검색</button>
	        </form>
	  </div>
    </div>
  </div>
</body>
<script>
	$('#btnSearch').click(function() {
		if('#searchWord').val() == '') {
			alert('검색어를 입력하세요');
			return;	
		}
		$('#formSearch').submit();
	})
</script>

</html>