<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    table { border-collapse: collapse; }
    td {padding:5px;  border: solid 1px gray; }
</style>
</head>
<body>
<table>

<tr>
<%
 for(int i=2;i<=9;i++)
 {
%>

	<td>
	<%
 	for(int j=1;j<=9;j++)
 	{
	%>
 		
  		<%=i%> X <%=j%> = <%=j*i%>
  		<br/>
 		
 
	<%
 	}
%></td>


<%
 }
%>
</tr>
</table>

</body>
</html>