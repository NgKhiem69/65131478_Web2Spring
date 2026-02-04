<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BAI 2.2</title>
</head>
<body>
 <%! int x=10; int y; int z= 0; %>
 <% y=200; 
 	z=x+y;
 	out.append("Results:");
 	out.append(String.valueOf(z));
 	%>
<h2> ANOTHER WAY TO PRINT IS EXPRESSION</h2>
<hr> 
<%="Results:" %>
<%=z %>
</body>
</html>