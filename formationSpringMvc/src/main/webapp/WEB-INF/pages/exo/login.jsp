<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
<body>
	<div class="container">
		<c:if test="${erreur != null}">
			<div class="alert alert-danger">${erreur}</div>
		</c:if>
		<form method="post" action="${base}/exo/login">
			<div class="form-group">
				<label>login:</label> <input class="form-control" name="login">
			</div>
			<div class="form-group">
				<label>mot de passe:</label> <input type="password"
					class="form-control" name="password">
			</div>
			<button type="submit" class="btn btn-primary">envoyer</button>
		</form>
	</div>
</body>
</body>

</html>