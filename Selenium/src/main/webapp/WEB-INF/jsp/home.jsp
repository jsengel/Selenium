<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="fr">
<head>
	<meta charset="utf-8">
	<title>Selenium</title>
	<link href="<c:url value="css/style.css" />" rel="stylesheet">
</head>
<body>
	<h1>Selenium</h1>
	<c:if test="${(result == null) || (result != 'SUCCESS')}">
	<a id="testLink" href="/test">Click me until success !</a>
	</c:if>
	<p id="testResult" style="color:${color};">${result}</p>
</body>
</html>