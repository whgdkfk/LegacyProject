<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<style>
		div { 
			box-sizing:border-box; 
			padding: 0 auto;
			margin: 0 auto;
		}
		
		#header {
            width:80%;
            height:100px;
            padding-top:20px;
            margin:auto;
        }
        #header>div {width:100%; margin-bottom:10px;}
        #header_1 {height:80%;}
        #header_2 {height:60%;}

        #header_1>div{
            height:100%;
            float:left;
        }	
	</style>
</head>
<body>
	<div id="header">
	<div id="header_1">
            <div id="header_1_left">
                <img src="instagram.jpeg" alt="">
            </div>
            <div id="header_1_center"></div>
            <div id="header_1_right">
            
            <c:choose>
            	<c:when test="${ empty sessionScope.loginMember }">
	                <!-- 로그인 전 -->
	                <a href="signup-form">회원가입</a>
	                <!-- 모달의 원리 : 이 버튼 클릭시 data-targer에 제시되어있는 해당 아이디의 div요소를 띄워줌 -->
	                <a data-toggle="modal" data-target="#loginModal">로그인</a> 
                </c:when>
                <c:otherwise>
	                <!-- 로그인 후 -->
	                <label>${ sessionScope.loginMember.memberName }님 환영합니다</label> &nbsp;&nbsp;
	                <a href="my-page">마이페이지</a>
	                <a href="logout">로그아웃</a>
                </c:otherwise>
             </c:choose>
                
            </div>
        </div>
	</div>
	<!-- 로그인 모달 -->
	<div class="modal fade" id="loginModal">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<img src="instagram.jpeg">
				
				
				</div>
				
				<div class="modal-body">
					<input type="text" class="form-id" placeholder="아이디" id="userId" name="memberId"> <br>
					<input type="password" class="form-pw" placeholder="비밀번호" id="userPw" name="memberPw"> <br>
				</div>
				
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">로그인</button>
				</div>
				
				<div class="modal-signUp">
					<div>
						계정이 없으신가요? 
						<a href="signup-form">가입하기</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	
</body>
</html>