<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formateur</title>
</head>
<body>

	<table class="table">
		<thead>
			<tr>
				<th>Prenom :</th>
				<th>Nom :</th>
				<th>Editer :</th>

			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="f" items="${formateurs}">
				<tr>
					<td>${f.prenom}</td>
					<td>${f.nom}</td>
					<td><a href="formateur?q=edit&id=${f.id}"  class="btn btn-warning">editer</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<a href="formateur?q=ajout"> Ajouter</a>






</body>
</html>