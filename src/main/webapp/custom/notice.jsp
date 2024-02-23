<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Driver"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- <link rel="stylesheet" href="../CSS/nstyle.css" /> -->
</head>
<body>
	<h3>notice.jsp</h3>
	<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String pw = "123456";
	Connection conn = DriverManager.getConnection(url, user, pw);
	String sql = "select seq,title, writer, content, regdate, hit from notices order by to_number(seq) desc";

	//실행
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	%>



	<table width="900" border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회수</td>
		</tr>

		<%
		while (rs.next()) {
		%>
		<tr>
			<th><%=rs.getString("seq")%></th>
			<th><a href="noticeDetaile.do?c=<%=rs.getString("seq")%>"><%=rs.getString("title")%></a></th>
			<th><%=rs.getString("writer")%></th>
			<th><%=rs.getString("regdate")%></th>
			<th><%=rs.getInt("hit")%></th>
		</tr>
		<%
		}
		%>
	</table>
	<a href="noticeReg.jsp">글쓰기</a>
</body>
</html>