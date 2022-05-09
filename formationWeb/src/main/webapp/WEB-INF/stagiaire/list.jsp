
<%@page import="quest.entity.Stagiaire"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div class="container">
		<input onclick="showFormAjout()" type="button" value="Ajouter"
			class="btn btn-success">
		<h1>liste des stagiaires</h1>
		<table class="table">
			<thead>
				<tr>
					<th>id :</th>
					<th>login :</th>
					<th>password :</th>
					<th>nom :</th>
					<th>prenom :</th>
					<th>session :</th>
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

				<c:forEach var="s" items="${stagiaires}">
					<tr>
						<td>${s.id}</td>
						<th>${s.login}</th>
						<th>${s.password}</th>
						<th>${s.nom}</th>
						<th>${s.prenom}</th>
						<th>${s.session.libelle}</th>
						
<%-- 						<c:choose> --%>

<%-- 							<c:when test="${m.id==1}"> --%>
<!-- 								<td>c'est l'id 1</td> -->
<%-- 							</c:when> --%>
<%-- 							<c:when test="${m.id==2}"> --%>
<!-- 								<td>c'est l'id 2</td> -->
<%-- 							</c:when> --%>
<%-- 							<c:otherwise> --%>
<!-- 								<td>c'est un autre id ?</td> -->
<%-- 							</c:otherwise> --%>
<%-- 						</c:choose> --%>


						<td><a href="?q=edit&id=${s.id}" class="btn btn-warning">editer</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div id="formAddStagiaire" style="display: none">


			<h1>Ajouter un stagiaire</h1>

			<form action="stagiaire" method="post">
				<input type="hidden" name="q" value="insert"> 
				<input type="text" name="login" placeholder="login" >
				<input type="password" name="password" placeholder="password" >
				<input type="text" name="nom" placeholder="nom" >
				<input type="text" name="prenom" placeholder="prenom" >
				
				<select name="session">
					<c:forEach var="session" items="${sessions}" >
					<option value="${session.id}">${session.libelle}</option>
					
					</c:forEach>
					
				</select>
				
				
				<input type="submit" value="Ajouter" class="btn btn-success">
			</form>
		</div>

	</div>
	<a href="accueil.jsp"><input type="button" value="RETOUR" class="btn-danger btn"></a>
</body>

<script>
	function showFormAjout() {
		<!--var
		div = document.getElementById("formAddMatiere");
		-->
		formAddStagiaire.style.display = "block";

	}
</script>

</html>

