<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<!-- Font Awesome 아이콘 라이브러리 -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- jQueryGoogleCDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	        /* 링크 기본 스타일 */
		    a {
		        color: #000000;  /* 기본 회색 */
		        transition: color 0.3s ease;  /* 색상 변화 부드럽게 */
		    }
		
		    /* 마우스 오버 시 링크 색상 */
		    a:hover {
		         color: #333333;  /* 밝은 회색으로 변경 */
		    }
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
	   	    /* 링크 기본 스타일 */
			.film-card a {
			    color: #6c757d;  /* 기본 회색 */
			    text-decoration: none;  /* 밑줄 제거 */
			    transition: color 0.3s ease;  /* 색상 변화 부드럽게 */
			}
			
			/* 마우스 오버 시 링크 색상 */
			.film-card a:hover {
			    color: #adb5bd;  /* 밝은 회색으로 변경 */
			}
			
			/* 링크가 포함된 카드에 마우스를 올렸을 때 스타일 */
			.film-card:hover a {
			    color: white;  /* 카드에 마우스를 올리면 링크 색상이 흰색으로 변경 */
			}
	        
	        /* 출연 작품 카드 레이아웃 */
			.film-list {
			    display: grid;              /* 그리드 레이아웃 사용 */
			    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr)); /* 화면 크기에 맞춰 카드 자동 배치 */
			    gap: 20px;                  /* 카드 간의 간격 */
			    margin-top: 20px;           /* 상단 여백 */
			}
			
			.film-card {
			    background-color: #fff;     /* 배경색 흰색 */
			    border: 1px solid #ddd;     /* 경계선 */
			    border-radius: 8px;         /* 둥근 모서리 */
			    text-decoration: none;      /* 링크 기본 스타일 제거 */
			    overflow: hidden;           /* 내용이 넘칠 경우 잘라내기 */
			    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);  /* 카드에 그림자 효과 */
			    transition: transform 0.3s ease, box-shadow 0.3s ease; /* 부드러운 애니메이션 */
			}
			
			.film-card:hover {
			    transform: translateY(-5px); /* 마우스 오버 시 카드 위로 떠오르는 효과 */
			    box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);  /* 더 강한 그림자 */
			}
			
			.film-title {
			    padding: 20px;              /* 제목 주변 여백 */
			    font-size: 1.2rem;           /* 글자 크기 */
			    color: #333;                 /* 제목 색상 */
			    font-weight: bold;           /* 제목 두껍게 */
			    text-align: left;            /* 제목 왼쪽 정렬 */
			    background-color: #f8f9fa;   /* 제목 배경색을 연한 회색 */
			    border-bottom: 1px solid #ddd; /* 카드 하단에 경계선 추가 */
			    display: flex;               /* 제목과 아이콘을 가로로 배치 */
			    align-items: center;         /* 아이콘과 텍스트 세로 중앙 정렬 */
			    gap: 10px;                   /* 아이콘과 텍스트 사이 간격 */
			}
			
			.film-title i {
			    font-size: 1.5rem;           /* 아이콘 크기 */
			    color: #6c757d;              /* 회색으로 아이콘 색상 설정 (#6c757d는 일반적인 회색) */
			    transition: color 0.3s ease; /* 아이콘 색상 변화 애니메이션 */
			}
			
			.film-card:hover .film-title i {
			    color: #adb5bd;              /* 마우스 오버 시 아이콘 색상 변경 (좀 더 밝은 회색) */
			}
			
			.film-card:hover .film-title {
			    background-color: #007bff;  /* 마우스 오버 시 제목 배경색 변경 */
			    color: white;                /* 마우스 오버 시 제목 텍스트 색상 변경 */
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
	   		
	   	<!-- 
	   		해야할 것
	   		O 1) actor 상세 
	   		X 1-1) actor 수정 - /on/modifyActor
	   		X  1-2) actor 삭제 - /on/removeActor (actor_fil삭제 + film_actor삭제 + actor삭제)
	   		
	   		O 2) actorFile 리스트
	   		O 2-1) actorFile 추가
	   		X 2-2) actorFile 삭제 /on/removeFilmFile
	   		
	   		O 3) filmActor 리스트
	   		X 3-1) filmActor 추가 /on/addFilmActor -> 필름 검색 후 선택
	   		X 3-2) filmActor 삭제 /on/removeFilmByActor
	   	 -->
	   		
	   			
	    <div class="col-sm-7">
	        <h2 class="text-center mb-4">배우 정보</h2> <!-- 제목 추가 -->
	        <!-- ACTOR -->
	        <h3>배우</h3>
	        <table class = "table table-striped">
	        	<tr>
	        		<td class="bold-center" >actorId</td>
	        		<td>${actor.actorId}</td>
	        	</tr>
	        	<tr>
	        		<td class="bold-center" >firstName</td>
	        		<td>${actor.firstName}</td>
	        	</tr>
	        	<tr>
	        		<td class="bold-center" >lastName</td>
	        		<td>${actor.lastName}</td>
	        	</tr>
	        	<tr>
	        		<td class="bold-center" >lastUpdate</td>
	        		<td>${actor.lastUpdate}</td>
	        	</tr>
	        </table>
	        
	        <div>
	        	<a href="${pageContext.request.contextPath}/on/modifyActor?actorId=${actor.actorId}">
	        		배우 수정
	        	</a>
	        	&nbsp;
	        	<a href="${pageContext.request.contextPath}/on/removeActor?actorId=${actor.actorId}">
	        		배우 삭제
	        	</a>
	        </div>
	        
	        <br>
	        
	        <!-- 배우 이미지 -->
	        <h3>배우 파일</h3>
	        <table class = "table">
	        	<tr>
	        		<td>image</td>
	        		<td>type</td>
	        		<td>size</td>	        		
	        		<td>createDate</td>	        		
	        		<td>삭제</td>	        		
	        	</tr>
	        	<c:forEach var="af" items="${actorFileList}">
	        		<tr>
		        		<td>
		        			<img src="${pageContext.request.contextPath}/upload/${af.filename}.${af.ext}">
		        		</td>
		        		<td>${af.type}</td>
		        		<td>${af.size} Byte</td>
		        		<td>${af.createDate}</td>	        		
		        		<td>
		        			<a href="${pageContext.request.contextPath}/on/removeActorFile?actorFileId=${af.actorFileId}&actorId=${actor.actorId}" 
		        				class="btn btn-warning">삭제
		        			</a>
		        		</td>
	        		</tr>	        		
	        	</c:forEach>
	        </table>
	        <div>
	        	<a href="${pageContext.request.contextPath}/on/addActorFile?actorId=${actor.actorId}" 
	        		class="btn btn-success">
	        			이미지파일 추가
	        	</a>
	        </div>
	        
	        <br>
	        
	        <!-- FILM -->
	        <div>
	        	<h3>출연 작품 추가</h3>
	        	
	        	<div>
	        		<!-- 출연작 추가 -->
		        	<form id="formSearchFilm" method="get"
		        		action="${pageContext.request.contextPath}/on/actorOne"><!-- 영화 검색 -->
		        		<!-- film 검색 시 actorId 같이 넘겨주겠다 -->
		        		<input type="hidden" name="actorId" value="${actor.actorId}">
		        		<input type="text" name="searchTitle">
		        		<button id="btnSeachFilm" type="button">film 검색</button>
		        	</form>
		        	
		        	<form id="formAddFilm" method="post" action="${pageContext.request.contextPath}/on/addFilmActorByActor">	
		        		<input type="hidden" name="actorId" value="${actor.actorId}">
		        		<select size="5" name="filmId"> 
		        		<!-- 수정해야됨 -->
		        			<c:forEach var="sf" items="${searchFilmList}">
		        				<option value="${sf.filmId}">${sf.title}</option>
		        			</c:forEach>
		        		</select>
		        	</form>
	        		<button id="btnAddFilm" type="button">film 추가</button>
	        	</div>
	        </div>
	        
	        <br>
	        
	        <!-- 출연 작품 섹션 -->
			<div>
			    <h3>출연 작품</h3>
			    <div class="film-list">
			        <c:forEach var="f" items="${filmList}">
			            <div>
				            <a href="${pageContext.request.contextPath}/on/filmOne?filmId=${f.filmId}" class="film-card">
				                    <!-- 영화 제목 앞에 아이콘 추가 -->
				                    <i class="fas fa-film" aria-hidden="true"></i>
                    				<span class="film-title">${f.title}</span>
				            </a>
				             
				             &nbsp;
				               		
				             <a href="${pageContext.request.contextPath}/on/removeFilmActorByActor?filmId=${f.filmId}&actorId=${actor.actorId}" 
				             		class="btn btn-danger">삭제</a>
				             <!-- 삭제시 f.filmId & actor.actorId 필요 -->
			            </div>   		
			        </c:forEach>
			    </div>
			</div>
    </div>
  </div>
</body>
<script>
	// film title 검색하는 버튼
	$('#btnSeachFilm').click(function(){
		$('#formSearchFilm').submit();
	});
	
	// 출연작(film) 추가
	$('#btnAddFilm').click(function(){
		$('#formAddFilm').submit();
	});
</script>
</html>