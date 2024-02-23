<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function logoutProc() {
		location.href="./login/logoutProc.jsp";
	}


</script>

</head>
<body>
<h3>main</h3>

<%
if(session.getAttribute("sessionId")==null){//로그인 안댐
	response.sendRedirect("login/loginForm");
}else{
%>
<%=session.getAttribute("sessionId") %>님 로그인 되었습니다. <br /><br />
<input type="button"  value="Logout" onclick="logoutProc()"/>


<%
}
%>
</body>
</html>