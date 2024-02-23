<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="customer.db.DbConn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>loginProc</h3>
	<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("password");
	//연결
	Connection conn = DbConn.getConnection();
	String sql = "select pw from member2 where id=?";

	//db 실행
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	ResultSet rs = pstmt.executeQuery();

	//로그인 경우의 수
	String ypass = null;
	int x = -1;
	String msg = "";
	if (rs.next()) {
		ypass = rs.getString("pw");
		if (ypass.equals(pass))
			x = 1;//로그인성공
		else
			x = 0;
	} else {
		x = -1;
	}
	System.out.println("xxx : " + x);

	if (x == 1) {//성공
		session.setAttribute("sessionId", id);
		msg = "../mainForm.jsp";
	} else if (x == 0) {//실패 패스워드 불일치
		msg = "./loginForm.jsp?c=0";
	} else {//아이디 없음
		msg = "./loginForm.jsp?c=-1";
	}
	response.sendRedirect(msg);
	%>


</body>
</html>