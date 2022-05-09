<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form id="formFormateur" action="formateur"  method="post">

	<input type="hidden" name="q" value="update">
	<input type="hidden" name="id" value="${formateur.id}">
	
	<input type="text" name="pwd" value="${formateur.password}">
	<input type ="text"name="login" value="${formateur.login}">
	<input type ="text"name="prenom" value="${formateur.prenom}">
	<input type ="text"name="nom" value="${formateur.nom}">

	<input type="submit" value="Modifier" class="btn btn-warning">
</form>


</body>
</html>