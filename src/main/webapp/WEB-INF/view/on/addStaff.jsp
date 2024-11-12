<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <title>스탭 추가</title>
    <style>
       body {
        background-color: #f0f0f0; /* 부드러운 배경색 */
        padding: 20px; /* 페이지 여백 */
    }
    .form-container {
        max-width: 600px; /* 최대 너비를 600px로 제한 */
        margin: auto; /* 가운데 정렬 */
    }
    .input-group {
        margin-bottom: 15px; /* 입력 그룹 간격 */
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
                <h1 class="text-center">스탭 추가</h1>
                
                <form id="formAddress" action="${pageContext.request.contextPath}/on/addStaff" method="get">
                   <div class="input-group mb-3">
                       <input type="text" name="searchAddress" id="searchAddress" class="form-control" placeholder="주소 검색어 입력">
                       <button type="button" id="btnAddress" class="btn btn-custom">주소 검색</button>
                   </div>
                </form>
                
                <br>
                
                <h3>주소 선택</h3>
                <select id="resultAddress" size="10" class="form-select mb-3">
                    <c:forEach var="a" items="${addressList}">
                        <option value="${a.addressId}">(ADDRESS ID: ${a.addressId}) ${a.address}</option>
                    </c:forEach>
                </select>
                <button type="button" id="btnAddrSel" class="btn btn-custom">주소 선택</button>
                
                <br>
                
                <h3>정보 입력</h3>
                <form id="addForm" action="${pageContext.request.contextPath}/on/addStaff" method="post">
                   <table class="table">
	                   <tr>
							<td>storeId</td>
							<td>
								<select name="storeId" id="storeId">
									<option value="">:::선택:::</option>
									<c:forEach var="s" items="${storeList}">
										<option value="${s.storeId}">${s.storeId}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						
						<tr>
							<td>addressId</td>
							<td>
								<input type="text" name="addressId" id="addressId" readonly>
							</td>
						</tr>
						
						<tr>
							<td>firstName</td>
							<td>
								<input type="text" name="firstName" id="firstName">
							</td>
						</tr>
						
						<tr>
							<td>lastName</td>
							<td>
								<input type="text" name="lastName" id="lastName">
							</td>
						</tr>
						
						<tr>
							<td>email</td>
							<td>
								<input type="text" name="email" id="email">
							</td>
						</tr>
						
						<tr>
							<td>userName</td>
							<td>
								<input type="text" name="username" id="username">
							</td>
						</tr>
						
					</table>
                    <button id="btnAddLanguage" type="button" class="btn btn-custom">언어 추가</button>
                </form>
            </div>
        </div>
    </div>
    <script>
	 // 액션 서브밋 버턴
	$('#btnAddStaff').click(function() {
		// 입력폼 유효성 검사
		if($('#storeId').val() == null || $('#storeId').val() =='') {
			alert('storeId를 입력하세요');
		} else if($('#addressId').val() == null || $('#addressId').val() =='') {
			alert('addressId를 입력하세요');
		} else if($('#firstName').val() == null || $('#firstName').val() =='') {
			alert('firstName를 입력하세요');
		} else if($('#lastName').val() == null || $('#lastName').val() =='') {
			alert('lastName를 입력하세요');
		} else if($('#email').val() == null || $('#email').val() =='') {
			alert('email를 입력하세요');
		} else if($('#username').val() == null || $('#username').val() =='') {
			alert('username를 입력하세요');
		} else{
			console.log('submit....');
			$('#addForm').submit();
		}
	});
	
	// 주소 선택 버턴
	$('#btnAddrSel').click(function() {
		console.log($('#resultAddress').val());
		if($('#resultAddress').val() == null || $('#resultAddress').val() =='') {
			alert('주소 선택을 먼저 하세요');
		} else {
			$('#addressId').val($('#resultAddress').val());
		}
	});

	// 주소 검색 버턴
	$('#btnAddress').click(function(){
		if($('#searchAddress').val() == "") {
			alert('주소 검색어를 입력하세요');
		} else {
			$('#formAddress').submit();
		}
	});
    </script>
</body>
</html>