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
	String prenom = (String) request.getAttribute("prenom");
	%>
	<h1>
		bonjour
		<%=request.getAttribute("prenom").toString().toUpperCase()%></h1>
	<h1>
		avec une variable
		<%=prenom.toUpperCase()%></h1>
</body>
</html>