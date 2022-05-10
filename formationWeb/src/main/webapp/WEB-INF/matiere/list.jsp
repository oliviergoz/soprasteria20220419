
<%@page import="quest.entity.Matiere"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<style>
	#formAddMatiere{display:none;}
	
	</style>
</head>
<body>
	<div class="container">
		<input onclick="showFormAjout()" type="button" value="Ajouter" class="btn btn-success" >
		<h1>liste des matieres</h1>
		<table class="table">
			<thead>
				<tr>
					<th>id:</th>
					<th>libelle:</th>
					<th>demo if</th>
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
						<c:choose>
						
							<c:when test="${m.id==1}">
								<td>c'est l'id 1</td>
							</c:when>
							<c:when test="${m.id==2}">
								<td>c'est l'id 2</td>
							</c:when>
							<c:otherwise>
								<td> c'est un autre id ?</td>
							</c:otherwise>
						</c:choose>
						
						
						<td><a href="?q=edit&id=${m.id}" class="btn btn-warning">editer</a></td>
						<td><a href="?q=delete&id=${m.id}" class="btn btn-danger">supprimer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

<a href="accueil.jsp"><input type="button" value="RETOUR" class="btn-danger btn"></a>
	<div id="formAddMatiere" style="display:none">
	
	
		<h1>Ajouter une matiere</h1>

		<form action="matiere" method="post">

			<input type="hidden" name="q" value="insert"> 
			<input placeholder="libelle" name="libelle" type="text" > 
			<input type="submit" value="Ajouter" class="btn btn-success">
		</form>
	</div>
	
 </div>
</body>
</html>

<script>


function showFormAjout()
{
	<!--var div = document.getElementById("formAddMatiere");-->
	formAddMatiere.style.display="block";
	
	
	
}

</script>