<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/join.css">
<script type="text/javascript" src="script/join.js"></script>
<title>Insert title here</title>
</head>
<body>
<form action="ProServlet?command" method="post" name="frm">
<input type="hidden" name="command" value="users_join">
 <div class="container">
      <div class="member-container">
      
        <div class="header">
          <div>회원 가입을 위해</div>
          <div>정보를 입력해주세요</div>
        </div>
        
        <div class="user-info">
          <div class="user-info-id">
            <div>* 아이디</div>
            <input type="text" />
          </div>
          
          <div class="user-info-pw">
            <div>* 비밀번호</div>
            <input type="password" />
          </div>
          
          <div class="user-info-pw-check">
            <div>* 비밀번호 확인</div>
            <input type="password" />
          </div>
          
           <div class="user-info-name">
            <div>* 이름</div>
            <input type="text" />
          </div>
          
        </div>
        <div class="gender">
          <input type="radio" name="gender" />
          <label for="women">여성</label>
          <input type="radio" name="gender" />
          <label for="men">남성</label>
        </div>
        
        <div class="agree-check">
          <input type="checkbox" /> 이용약관 개인정보 수집 및 이용, 마케팅 활용
          선택에 모두 동의합니다.
        </div>
        
        <div class="btn">
        	 <input type="submit" value="가입하기" onclick="return joinCheck()"> 
      	  	 <input type="reset" value="다시 작성"> 
        </div>
      </div>
    </div>
</form>
</body>
</html>