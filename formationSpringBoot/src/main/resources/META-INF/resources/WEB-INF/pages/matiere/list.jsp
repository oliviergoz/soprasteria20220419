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
	<div class="container">
		<h1>liste des matieres</h1>
		<table class="table">
			<thead>
				<tr>
					<th>id:</th>
					<th>libelle</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="m" items="${matieres}">
					<tr>
						<td>${m.id}</td>
						<td>${m.libelle}</td>
						<td><a class="btn btn-primary"
							href="${base}/matiere/edit?id=${m.id}">editer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${base}/matiere/add" class="btn btn-link">nouvelle
			matiere</a>
	</div>
</body>
</html>