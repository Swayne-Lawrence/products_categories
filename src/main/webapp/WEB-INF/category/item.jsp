<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1><c:out value="${category.name }"></c:out></h1>
	
	<h2>Categories</h2>
	<c:forEach var="c" items="${category.products}">
		<p>*<c:out value="${ c.name}"></c:out></p>
	</c:forEach>
	
	<form:form action="/product_selection" method="post" modelAttribute="cp">
		<form:input path="category" type="hidden" value="${category.id }"/>
		<div>
		<form:label path="product">Categories</form:label>
		<form:select path="product">
			<c:forEach var="p" items="${products}">
				<option value="${p.id }">${p.name } </option>
			</c:forEach>
		</form:select>
		
		<form:errors></form:errors>
		</div>
		<button type="submit">Create</button>
	</form:form>
</body>
</html>