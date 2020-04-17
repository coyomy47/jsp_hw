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
String s1= request.getParameter("cmd");
if(s1==null)s1="one";



%>
<div>
	<form method="get">
	<select name="cmd">
              <option value="one" <%= "one".equals(s1) ? "selected" : "" %>>one</option>
               <option value="two" <%= "two".equals(s1) ? "selected" : "" %>>two</option>
                <option value="three" <%= "three".equals(s1) ? "selected" : "" %>>three</option>
              
          </select>
          <div>
				<input type="text" name="form2" value="<%= s1 %>" />
			</div>
			
			<div>
				<button type="submit">OK</button>
			</div>
	
	</div>
</body>
</html>