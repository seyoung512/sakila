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
	    	<!-- main content -->
	        <h2 class="text-center mb-4">배우 추가</h2> <!-- 제목 추가 -->
	        <form id="formActor" method="post" action="${pageContext.request.contextPath}/on/addActor"
	        	enctype="multipart/form-data">
		        <table class = "table">
		        	<tr>
		        		<td class="bold-center" >성</td>
		        		<td><input type="text" name="firstName"></td>
		        	</tr>
		        	<tr>
		        		<td class="bold-center" >이름</td>
		        		<td><input type="text" name="lastName"></td>
		        	</tr>
		        	<tr>
		        		<td class="bold-center" >파일</td>
		        		<td>
		        			<div id="fileDiv">
		        				<button type="button" id="btnAddFile">파일추가</button>
		        				<button type="button" id="btnRemoveFile">파일삭제</button>
		        			</div>
		        		</td>
		        	</tr>
		        </table>
		        <button type="button" id="btnAddActor">배우 추가</button>
	  		</form>
	  </div>
    </div>
  </div>
</body>
<script>
	$('#btnAddActor').click(function() {
		if($('#firstName').val() == '' || $('#lastName').val() == '') {
				alert('이름을 입력하세요');
		} else if($('.actorFile').length > 0 && $('.actorFile').last().val() == '') {
			alert('첨부되지 않은 파일이 있습니다');
		} else {
			$('#formActor').submit();
		}
	});
	
	$('#btnAddFile').click(function() {
		/* 자바스크립트 API
		$('.actorFile')
		arr.forEach(function(item, index) {
		}); */
		// JQuery API 사용
		/*
		let flag = true;
		$('.actorFile').each(function() { // (index, item) item == $(this)
			if($(this).val()=='') {
				flag == false;
			}
		}); */
		
		if($('.actorFile').last().val() == '') { // 마지막 input=file값이 공백이라면
			alert("첨부하지 않은 파일이 이미 존재합니다");
		} else {
			let html = '<div class="mt-2"><input type="file" name="actorFile" class="actorFile form-control"></div>'; // 파일 추가생성
			$('#fileDiv').append(html);
		}
	});
	
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