<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification session </title>
</head>
<body>


<h1>Modifier une session</h1>
<form action="session"  method="post">

	<input type="hidden" name="q" value="update">
	<input type="hidden" name="id" value="${sessions.id}">
	<input placeholder="libelle" name="libelle" type="text" value="${sessions.libelle}">
	<input type="submit" value="Modifier" class="btn btn-warning">
</form>
<a href="session"><input type="button" value="RETOUR" class="btn-danger btn"></a>
</body>
</html>