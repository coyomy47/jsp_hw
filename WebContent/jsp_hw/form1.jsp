<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int result=0;
String s1= request.getParameter("form1");
if(s1==null){
	s1="0";
	result=Integer.parseInt(s1);
}else {
	result=Integer.parseInt(s1)+1;//확인
	
	
}

%>

	<form method="get">

	<input type="text" name="form1" value="<%= result %>"/>
	<button type "submit" value="+">++</button>

	
</body>
</html>