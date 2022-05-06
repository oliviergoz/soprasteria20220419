<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<%
		if (request.getAttribute("erreur") != null) {
		%>
		<div class="alert alert-danger">erreur d'authentification</div>
		<%}%>
		<form method="post" action="login">
			<div class="form-group">
				<label>login:</label> <input class="form-control" name="login">
			</div>
			<div class="form-group">
				<label>mot de passe:</label> <input type="password"
					class="form-control" name="password">
			</div>
			<button type="submit" class="btn btn-primary">envoyer</button>
		</form>
		<a href="page">on va sur page.jsp</a>
	</div>
</body>
</html>