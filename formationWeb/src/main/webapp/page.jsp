<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!private String texte = "hello world";

	public String getTexte() {
		return texte;
	}%>
<body>
	<h1>ma jsp</h1>
	<%
	for (int i = 0; i < 5; i++) {
		out.write("write dans scriptlet");
	%>
	<div>hello <%=i%> <a href="unePageQuiDevraExister?param=<%=i%>">un lien</a></div>
	<%
	}
	%>
</body>
</html>