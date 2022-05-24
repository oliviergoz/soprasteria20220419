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
<title>Eval</title>
</head>
<body>
	<div class="container">
		<form:form action="${base}/evaluation/save" method="post"
			modelAttribute="evaluation">
			<div class="form-group">
				<form:label path="stagiaire.id">Stagiaire:</form:label>
				<form:select path="stagiaire.id" class="form-control">
					<form:options items="${stagiaires}" itemLabel="infos"
						itemValue="id" />
				</form:select>
			</div>
			<div class="form-group">
				<form:label path="module.id">module:</form:label>
				<form:select path="module.id" class="form-control">

					<form:options items="${modules}" itemLabel="id" itemValue="id" />
				</form:select>
			</div>

			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" readonly="true" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="date">date:</form:label>
				<form:input path="date" type="date" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="note">note:</form:label>
				<form:input type="number" path="note" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="commentaire">commentaire:</form:label>
				<form:input type="text" path="commentaire"
					class="form-control" />
			</div>

			<div>
				<button type="submit" class="btn btn-primary">enregistrer</button>
				<a href="${base}/evaluation" class="btn btn-warning">annuler</a>
			</div>
		</form:form>
	</div>

</body>
</html>