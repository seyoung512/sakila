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
                <h1 class="text-center">언어 추가</h1>
                
                <form id="addLanguage" action="${pageContext.request.contextPath}/on/addLanguage" method="post">
                    <table class="table">
                        <tr>
                            <td>Name</td>
                            <td>
                                <input type="text" name="name" id="name" class="form-control">
                            </td>
                        </tr>
                    </table>
                    <button id="btnAddLanguage" type="button" class="btn btn-custom">언어 추가</button>
                </form>
            </div>
        </div>
    </div>
    <script>
        // 액션 서브밋 버튼
        $('#btnAddLanguage').click(function() {
            // 입력폼 유효성 검사
            if($('#name').val() === "") {
                alert('name를 입력하세요');
            } else {
                console.log('submit....');
                $('#addLanguage').submit();
            }
        });
    </script>
</body>
</html>