<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<div class="container">
		<h1>edition formateur</h1>
		<form:form action="${base}/formateur/save" method="post"
			modelAttribute="formateur">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" readonly="true"
					placeholder="generation automatique" class="form-control" />
			</div>

			<div class="form-group">
				<form:label path="prenom">prenom:</form:label>
				<form:input path="prenom" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="nom">nom:</form:label>
				<form:input path="nom" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="login">login:</form:label>
				<form:input path="login" class="form-control" />
			</div>
			<c:if test="${formateur.id==null}">
				<div class="form-group">
					<form:label path="password">password:</form:label>
					<form:input type="password" path="password" class="form-control" />
				</div>
			</c:if>
			<div>
				<button type="submit" class="btn btn-primary">enregistrer</button>
				<a href="${base}/formateur" class="btn btn-warning">annuler</a>
			</div>
		</form:form>

	</div>
</body>
</html>