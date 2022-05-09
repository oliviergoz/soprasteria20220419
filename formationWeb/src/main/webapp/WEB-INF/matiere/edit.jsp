<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<h1>Modifier une matiere</h1>

<form action="matiere"  method="post">

	<input type="hidden" name="q" value="update">
	<input type="hidden" name="id" value="${matiere.id}">
	<input placeholder="libelle" name="libelle" type="text" value="${matiere.libelle}">

	<input type="submit" value="Modifier" class="btn btn-warning">
</form>



</body>
</html>