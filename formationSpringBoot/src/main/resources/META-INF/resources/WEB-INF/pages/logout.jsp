<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" value="${pageContext.request.contextPath}" />
<form method="post" action="${base}/logout">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}">
	<button type="submit" class="btn btn-link">deconnexion</button>
</form>
