<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Categories</h2>
	<c:forEach var="c" items="${categories }">
		<p><a href="/items/${c.id }"><c:out value="${c.name }"></c:out></a></p>
	</c:forEach>
	<h2>Products</h2>
	<c:forEach var="p" items="${products}">
		<p><a href="/show/${p.id }"><c:out value="${p.name }"></c:out></a></p>
	</c:forEach>
</body>
</html>