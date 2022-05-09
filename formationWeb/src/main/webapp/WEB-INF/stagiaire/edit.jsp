<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>Modifier un stagiaire</h1>

<form action="stagiaire"  method="post">

	<input type="hidden" name="q" value="update">
	<input type="hidden" name="id" value="${stagiaire.id}">
	<input placeholder="login" name="login" type="text" value="${stagiaire.login}">
	<input placeholder="password" name="password" type="text" value="${stagiaire.password}">
	<input placeholder="nom" name="nom" type="text" value="${stagiaire.nom}">
	<input placeholder="prenom" name="prenom" type="text" value="${stagiaire.prenom}">
	<select name="session">
					<c:forEach var="session" items="${sessions}" >
					
						<c:choose>
						<c:when test="${session.id==stagiaire.session.id}">
								<option selected value="${session.id}">${session.libelle}</option>
						</c:when>
						
						<c:otherwise>
							<option value="${session.id}">${session.libelle}</option>
						</c:otherwise>
						
						</c:choose>
				
					</c:forEach>
					
				</select>
	

	<input type="submit" value="Modifier" class="btn btn-warning">
</form>
<a href="stagiaire"><input type="button" value="RETOUR" class="btn-danger btn"></a>


</body>
</html>