<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sessions</title>
<style>
#formAddSession {
	display: none;
}
</style>
</head>
<body>
		<input onclick="showFormAjout()" type="button" class="btn btn-success" value="Ajout">
		<h1>Liste des sessions</h1>
		<table class="table">
			<thead>
				<tr>
					<th>id:</th>
					<th>libelle:</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<!-- EL:Expression Language ${variable}
			page, request, session, servletContext
			 -->
			<tbody>
				<c:forEach var="s" items="${sessions}">
					<tr>
						<td>${s.id}</td>
						<td>${s.libelle}</td>
						<td><a href="?q=edit&id=${s.id}" class="btn btn-warning">editer</a></td>
						<td><a href="module?session=${s.id}" class="btn btn-primary">Voir les modules</a></td>
						<td><a href="?q=delete&id=${s.id}" class="btn btn-danger">supprimer</a></td> 
					</tr>
				</c:forEach>
			</tbody>
		</table>
				<div id="formAddSession">
			<h1>Ajouter une session</h1>
			<form action="session" method="post">

				<input type="hidden" name="q" value="insert"> 
				<input placeholder="libelle" name="libelle" type="text"> 
				<input type="submit" value="Ajouter" class="btn btn-success">

			</form>
		</div>
		
		<a href="accueil.jsp"><input type="button" value="RETOUR" class="btn-danger btn"></a>
</body>
</html>

<script>
	function showFormAjout() {
		formAddSession.style.display = "block";
	}
</script>