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
                	<h2 class="text-center mb-4">Personal Information</h2>
                 <!-- 프로필 사진 추가 -->
                <img src="${staff.profilePicUrl}" alt="Profile Picture" class="profile-pic">
	   		
		        <table class="table table-striped">
		            <tbody>
		                <tr>
		                    <td class="bold-center">아이디</td>
		                    <td>${staff.staffId}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">이름</td>
		                    <td>${staff.firstName}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">주소</td>
		                    <td>${staff.staffAddress}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">주소2</td>
		                    <td>${staff.staffAddress2}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">staffDistrict</td>
		                    <td>${staff.staffDistrict}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">staffPostCode</td>
		                    <td>${staff.staffPostCode}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">staffPhone</td>
		                    <td>${staff.staffPhone}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">staffCity</td>
		                    <td>${staff.staffCity}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">staffCountry</td>
		                    <td>${staff.staffCountry}</td>
		                </tr>
		            </tbody>
		        </table>
		        <br>
		        <h2 class="text-center mb-4">Store Information</h2> <!-- 제목 추가 -->
		        <table class="table table-striped">
		            <tbody>
		                <tr>
		                    <td class="bold-center">managerStaffId</td>
		                    <td>${staff.managerStaffId}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">managerName</td>
		                    <td>${staff.managerName}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">storeId</td>
		                    <td>${staff.storeId}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">storeAddress</td>
		                    <td>${staff.storeAddress}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">storeAddress2</td>
		                    <td>${staff.storeAddress2}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">storeDistrict</td>
		                    <td>${staff.storeDistrict}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">storePostCode</td>
		                    <td>${staff.storePostCode}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">storePhone</td>
		                    <td>${staff.storePhone}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">storeCity</td>
		                    <td>${staff.storeCity}</td>
		                </tr>
		                <tr>
		                    <td class="bold-center">storeCountry</td>
		                    <td>${staff.storeCountry}</td>
		                </tr>
		            </tbody>
				</table>
	  		</div>
    	</div>
  	</div>
	</body>
</html>