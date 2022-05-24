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
		<form:form action="${base}/module/save" method="get"
			modelAttribute="module">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" readonly="true" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="code">code:</form:label>
				<form:input path="code" type="number" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="debut">debut:</form:label>
				<form:input type="date" path="debut" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="fin">fin:</form:label>
				<form:input path="fin" type="date" class="form-control" />
			</div>
			<div class="form-group">
				<form:label path="matiere.id">matiere:</form:label>
				<form:select path="matiere.id" items="${matieres}" itemValue="id"
					itemLabel="libelle" class="form-control"></form:select>
			</div>
			<div class="form-group">
				<form:label path="formateur.id">formateur:</form:label>
				<form:select path="formateur.id" class="form-control">
					<form:option value="">pas de formateur</form:option>
					<form:options items="${formateurs}" itemLabel="infos"
						itemValue="id" />
				</form:select>
			</div>

					<div class="form-group">
						<form:label path="session.id">session:</form:label>
						<form:input path="session.id" readonly="true"/>
					</div>
		
			<div>
				<button type="submit" class="btn btn-primary">enregistrer</button>
				<a href="${base}/module" class="btn btn-warning">annuler</a>
			</div>
		</form:form>

	</div>
</body>
</html>