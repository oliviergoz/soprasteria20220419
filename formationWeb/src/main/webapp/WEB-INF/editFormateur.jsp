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
	
	Password : <input type="text" name="pwd" placeholder="password" value="${formateur.password}"> <br>
	login : <input type ="text"name="login" placeholder="login" value="${formateur.login}"><br>
	Prenom :<input type ="text"name="prenom" placeholder="prenom" value="${formateur.prenom}"><br>
	Nom :<input type ="text"name="nom" placeholder="nom" value="${formateur.nom}"><br>

	<input type="submit" value="Modifier" class="btn btn-warning">
</form>


</body>
</html>