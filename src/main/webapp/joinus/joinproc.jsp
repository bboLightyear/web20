<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>joinproc.jsp</h3>


<%
request.setCharacterEncoding("UTF-8");
String id=request.getParameter("id");
String pwd=request.getParameter("pwd");
String pwd2=request.getParameter("pwd2");
String name=request.getParameter("name");
String gender=request.getParameter("gender");


String year=request.getParameter("year");
String month=request.getParameter("month");
String day=request.getParameter("day");
String birth=String.format("%s-%s-%s",year,month,day);

String IsLunar=request.getParameter("IsLunar");
String cphone=request.getParameter("cphone");
String email=request.getParameter("email");
/* String hobby=request.getParameter("hobby");  *///배열로 받아야 함(아니면 하나만 받아짐 )
String[] hobbis=request.getParameterValues("hobby"); 
String hobby="";

if(hobbis!=null){
for(int i=0; i<hobbis.length;i++){
	hobby+=hobbis[i];
	if(hobbis.length>i+1){
		hobby+=",";
	}
}
}

String sql="insert into member2 VALUES(?,?,?,?,?,?,?,?,?,sysdate)";
Class.forName("oracle.jdbc.driver.OracleDriver");
String url="jdbc:oracle:thin:@localhost:1521:xe";
String user="hr";
String pw="123456";
Connection conn=DriverManager.getConnection(url,user,pw);

//실행
PreparedStatement pstmt=conn.prepareStatement(sql);
pstmt.setString(1,id);
pstmt.setString(2,pwd);
pstmt.setString(3,name);
pstmt.setString(4,gender);
pstmt.setString(5,birth);
pstmt.setString(6,IsLunar);
pstmt.setString(7,cphone);
pstmt.setString(8,email);
pstmt.setString(9,hobby);

pstmt.executeUpdate();

response.sendRedirect("../index.jsp");

%>
</body>
</html>