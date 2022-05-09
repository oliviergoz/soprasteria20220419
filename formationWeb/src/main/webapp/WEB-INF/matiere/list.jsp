
<%@page import="quest.entity.Matiere"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
	<div class="container">
		<h1>liste des matieres</h1>
		<table class="table">
			<thead>
				<tr>
					<th>id:</th>
					<th>libelle:</th>
				</tr>
			</thead>
			<tbody>
				<!-- 
					EL:Expression Language
					${variable}
					page,request,session,servletContext
					request.getAttribute("matieres")
					session.getAttribute("matieres")
					application.getAttribute("matieres")
				 -->
				<c:forEach var="m" items="${matieres}">
					<tr>
						<td>${m.id}</td>
						<td>${m.libelle}</td>
						<td><a href="?q=edit&id=${m.id}" class="btn btn-primary">editer</a></td>
						<td><a href="?q=delete&id=${m.id}" class="btn btn-danger">supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>