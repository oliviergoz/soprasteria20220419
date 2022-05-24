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
<title>Sessions</title>
</head>
<body>
	<div class="container">
		<h1>liste des sessions</h1>
		<table class="table">
			<tbody>
				<c:forEach var="s" items="${sessions}">
					<tr>
						<td>${s.id}</td>
						<td>${s.libelle}</td>

						<!-- lien qui amene vers la liste des stagiaire de cette session  -->
						<!-- lien qui amene vers la liste des modules de cette session  -->
						<td><a href="${base}/session/edit/?id=${s.id}"
							class="btn btn-primary">editer</a></td>
							
							<td><a href="${base}/module/modulesSession/?id=${s.id}"
							class="btn btn-primary">Voir/gerer Module</a></td>
							
							<td><a href="${base}/session/gestionStagiaire/?id=${s.id}"
							class="btn btn-primary">Voir/gerer Stagaire</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${base}/session/add" class="btn btn-link">ajouter une session</a>

	</div>
</body>
</html>