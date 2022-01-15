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
	<h1><c:out value="${product.name }"></c:out></h1>
	
	<h2>Categories</h2>
	<c:forEach var="p" items="${product.categories}">
		<p>*<c:out value="${ p.name}"></c:out></p>
	</c:forEach>
	
	<form:form action="/category_selection" method="post" modelAttribute="cp">
		<form:input path="product" type="hidden" value="${product.id }"/>
		<div>
		<form:label path="category">Categories</form:label>
		<form:select path="category">
			<c:forEach var="c" items="${categories}">
				<option value="${c.id }">${c.name } </option>
			</c:forEach>
		</form:select>
		
		<form:errors></form:errors>
		</div>
		<button type="submit">Create</button>
	</form:form>
</body>
</html>