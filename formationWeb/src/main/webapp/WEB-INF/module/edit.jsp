<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>Modifier un module</h1>

		<form action="module" method="post">

			<input type="hidden" name="q" value="update"> 
			<input type="hidden" name="session" value="${param.session}"> 
			<input type="hidden" name="id" value="${param.id}"> 
			<input placeholder="debut" name="debut" type="date" value="${module.debut}"> 
			<input placeholder="fin" name="fin" type="date" value="${module.fin}"> 
			
			
			<select name="formateur">
				<c:forEach var="f" items="${formateurs}">
					<c:choose>
						<c:when test="${f.id==module.formateur.id}">
							<option selected value="${f.id}">${f.nom} ${f.prenom}</option>
						</c:when>
						<c:otherwise>
							<option value="${f.id}">${f.nom} ${f.prenom}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
			
			
			<select name="matiere">
				<c:forEach var="m" items="${matieres}">
					<c:choose>
						<c:when test="${m.id==module.matiere.id}">
							<option selected value="${m.id}">${m.libelle}</option>
						</c:when>
						<c:otherwise>
							<option value="${m.id}">${m.libelle}</option>
						</c:otherwise>
					</c:choose>
					
				</c:forEach>
			</select>
		
			<input type="submit" value="Modifier" class="btn btn-success">
		</form>



</body>
</html>