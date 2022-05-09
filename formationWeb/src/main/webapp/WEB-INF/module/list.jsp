
<%@page import="quest.entity.Matiere"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des modules</title>

	<style>
	#formAddMatiere{display:none;}
	
	</style>
</head>
<body>
	<div class="container">
		<input onclick="showFormAjout()" type="button" value="Ajouter" class="btn btn-success" >
		<h1>liste des modules de la session : </h1>
		<table class="table">
			<thead>
				<tr>
					<th>Id:</th>
					<th>Debut</th>
					<th>Fin</th>
					<th>Code</th>
					<th>Formateur</th>
					<th>Matiere</th>
				</tr>
			</thead>
			<tbody>
		
				<c:forEach var="m" items="${modules}">
					<tr>
						<td>${m.id}</td>
						<td>${m.debut}</td>
						<td>${m.fin}</td>
						<td>${m.code}</td>
						<td>${m.formateur.nom} ${m.formateur.prenom}</td>
						<td>${m.matiere.libelle}</td>
						
						<td><a href="?q=edit&session=${param.session}&id=${m.id}" class="btn btn-warning">editer</a></td>
						<td><a href="?q=delete&session=${param.session}&id=${m.id}" class="btn btn-danger">supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	<div id="formAddModule" style="display:none">
	
	
		<h1>Ajouter un module</h1>

		<form action="module" method="post">

			<input type="hidden" name="q" value="insert"> 
			<input type="hidden" name="session" value="${param.session}"> 
			<input placeholder="debut" name="debut" type="date"> 
			<input placeholder="fin" name="fin" type="date"> 
			
			
			<select name="formateur">
				<c:forEach var="f" items="${formateurs}">
					<option value="${f.id}">${f.nom} ${f.prenom}</option>
				</c:forEach>
			</select>
			
			
			<select name="matiere">
				<c:forEach var="m" items="${matieres}">
					<option value="${m.id}">${m.libelle}</option>
				</c:forEach>
			</select>
		
			<input type="submit" value="Ajouter" class="btn btn-success">
		</form>
	</div>
	
 </div>
 <a href="accueil.jsp"><input type="button" value="RETOUR" class="btn-danger btn"></a>
</body>
</html>

<script>


function showFormAjout()
{
	<!--var div = document.getElementById("formAddMatiere");-->
	formAddModule.style.display="block";
	
	
	
}

</script>