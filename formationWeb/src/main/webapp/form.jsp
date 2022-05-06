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
	if (request.getAttribute("erreur") != null) {
	%>
	<div style="color: red;">erreur prenom obligatoire</div>
	<%
	}
	%>
	<form method="get" action="bonjour">
		<input name="prenom">
		<button type="submit">envoyer</button>
	</form>
</body>
</html>