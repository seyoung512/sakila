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
<style>
   body {
       display: flex;
       justify-content: center;
       align-items: center;
       height: 100vh; /* 전체 화면 높이에 맞추기 */
       margin: 0;
       background-color: #f0f0f0; /* 배경 색상 */
   }

   .container {
       width: 300px; /* 컨테이너 너비 */
   }

   h1 {
       text-align: center; /* 제목 가운데 정렬 */
       margin-bottom: 20px; /* 제목과 폼 사이 간격 */
   }

   form {
       background-color: #e0e0e0; /* 폼 색상 */
       padding: 20px;
       border-radius: 5px;
       box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
   }

   .form-label {
       margin-bottom: 5px;
   }

   .form-control {
       margin-bottom: 15px; /* 입력 필드 간격 */
   }

   .btn {
       width: 100%; /* 버튼 너비 */
   }
   
   .error-message {
           color: red; /* 오류 메시지 색상 */
           font-weight: bold; /* 두껍게 */
           margin-bottom: 15px; /* 아래 간격 */
           display: none; /* 기본적으로 숨김 */
           text-align: right; /* 오른쪽 정렬 */
       }
</style>
</head>
<body>
	<div class="container">
		<h2 class="mb-3">STAFF Login </h2>
		<span>${msg}</span>
		
		<div class="error-message" id="error-message"></div>
		
		<form action="${pageContext.request.contextPath}/off/login" method="post">
	  		<div class="mb-3 mt-3">
	    		<label for="staffId" class="form-label">staffId:</label>
	    		<input type="text" class="form-control" id="staffId" name="staffId">
	  		</div>
	  		<div class="mb-3">
	    		<label for="password" class="form-label">password:</label>
	    		<input type="password" class="form-control" id="password" name="password">
	  		</div>
	  		<button type="submit" class="btn btn-primary">로그인</button>
		</form>
	</div>
</body>
<script>
	// btn버턴 클릭시 폼값 유효성 검사
	$( '#btn').click(funtion(){
		console.log('click');
		// 숫자가 아니면 isNaN() or $.isNumberic()
		if($.inNumberic($('#staffId').val()) == false) {
			alert('staffId는 숫자만 입력 가능')
		} else if($('#password').val().length < 4){
			alert('password는 4자이상 가능');
		} else {
			$('#from').submit();
		}
	});
</script>
</html>