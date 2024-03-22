<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/login.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap"/>

<title>Insert title here</title>
<script type="text/javascript" src="script/user.js"></script>
</head>
<body>
    <div class="container">
      <h2>Login</h2>
      <form method="post" action="UserServlet?command=user_login_check" id="login-form" name="frm">
        <div class="login_input">
          <input type="text" name="id" value="id" placeholder="아이디를 입력해주세요." />
          <input type="password" name="password" value="pwd" placeholder="비밀번호를 입력해주세요." />
        </div>
        <div class="submit_button">
          <input type="submit" value="Login" onclick="return userCheck()"/>
        </div>
      </form>
    </div>
  </body>
</html>