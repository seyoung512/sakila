<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	        <h2 class="text-center mb-4">배우 파일 추가</h2> <!-- 제목 추가 -->
	       
	       <div>${msg}</div>
	       
	        <form id="formAddActorfile" method="post"
	        		enctype="multipart/form-data"
	        		action="${pageContext.request.contextPath}/on/addActorFile">
	        	
	        	<table class="table">
	        		<tr>
	        			<!-- actorId는 변하면 안됨 -->
	        			<td>actorId</td>
	        			<td>
	        				<input type="text" name="actorId" value="${actorId}" readonly>
	        			</td>
	        		</tr>
	        		<tr>
	        			<td>file</td>
	        			<td>
	        				<div id="fileDiv">
		        				<button type="button" id="btnAddFile">파일추가</button>
		        				<button type="button" id="btnRemoveFile">파일삭제</button>
		        				<input type="file" name="actorFile" class="actorFile form-control">
		        			</div>
	        			</td>
	        		</tr>
	        	</table>
	        	<button id="btnaddActorFile" >파일추가</button>
	        </form>
	  </div>
    </div>
  </div>
</body>
<script>
	// 제출 버튼 클릭시 주의문
	$('#btnAddActorFile').click(function(){
		if($('.actorFile').length > 0 && $('.actorFile').last().val() == '') {
			alert('첨부할 파일이 없습니다');
		} else if($('.actorFile').last().val() == '') {
			alert('첨부되지 않은 파일이 없습니다');
		} else {
			$('#formAddActorFile').submit();
		}
	});
	
	// 파일 추가 버튼 클릭시 첨부 파일 없을 때 주의문, 있을 시 파일 생성
	$('#btnAddFile').click(function() {
		if($('.actorFile').last().val() == '') { // 마지막 input=file값이 공백이라면
			alert("첨부하지 않은 파일이 이미 존재합니다");
		} else {
			let html = '<div class="mt-2"><input type="file" name="actorFile" class="actorFile form-control"></div>'; // 파일 추가생성
			$('#fileDiv').append(html);
		}
	});
	
	// 파일 삭제 버튼 클릭시 첨부 파일이 없을 때 주의문, 있을 시 마지막 파일부터 삭제 
	$('#btnRemoveFile').click(function() {
		// 마지막 <input type="file" name="actorFile" class="actorFile"> 태그를 제거
		// console.log($('.actorFile').length);
		if($('.actorFile').length == 0) { // class="actorFile" 없다
			alert('삭제할 빈 input=file이 존재하지 않습니다');
		} else {
			 $('.actorFile').last().closest('div').remove(); // 마지막 파일 삭제
		}
	});
</script>
</html>