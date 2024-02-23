<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function goJoinForm() {
	location.href="../joinus/join.jsp";
}
</script>



</head>
<body>
	<form action="loginProc.jsp" name="logInfo" method="post" onsubmit="return checkValue()">
	<img src="../img/poodle.png" alt="poodle" />
	<br /><br />
	<table>
		<tr>
			<td bgcolor="gold">아이디</td>
			<td><input type="text" name="id" maxlength="50" /></td>
		</tr>
		<tr>
			<td bgcolor="gold">비밀번호</td>
			<td><input type="password" name="password" maxlength="50" /></td>
		</tr>
	</table>
	<input type="submit" value="login" />
	<input type="button" value="join" onclick="goJoinForm()" />
	
	</form>
<%
String msg=request.getParameter("msg");

if(msg!=null&&msg.equals("0")){
	out.println("<br>");
	out.println("<font color='red' size='5'>비밀번호확인</font>");
	
}else if(msg!=null&&msg.equals("-1")){
	out.println("<br>");
	out.println("<font color='red' size='5'>아이디확인</font>");
}
%>
</body>
</html>