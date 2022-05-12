<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1>liste des modules</h1>
		<table class="table">
			<tbody>
				<c:forEach var="m" items="${modules}">
					<tr>
						<td>${m.id}</td>
						<td>${m.code}</td>
						<td>${m.matiere.libelle}</td>
						<td>${m.formateur.infos}</td>
						<td><fmt:parseDate value="${m.debut}" pattern="yyyy-MM-dd"
								type="date" var="dateDebut"></fmt:parseDate> <fmt:formatDate
								value="${dateDebut}" pattern="dd/MM/yyyy" /></td>
						<td><fmt:parseDate value="${m.fin}" pattern="yyyy-MM-dd"
								type="date" var="dateFin"></fmt:parseDate> <fmt:formatDate
								value="${dateFin}" pattern="dd/MM/yyyy" /></td>
						<td><a href="${base}/module/edit/?id=${m.id}"
							class="btn btn-primary">editer</a></td>
						<td><a href="${base}/module/suprimer/?id=${m.id}"
							class="btn btn-primary">Suprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


		<c:choose>
			<c:when test="${session!=null}">
				<a href="${base}/module/add?id=${session.id}" class="btn btn-link">ajouter
					un module a cette session </a>
			</c:when>
			<c:otherwise>
				<a href="${base}/module/add" class="btn btn-link">ajouter un
					module</a>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>