<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="/form" method="post" modelAttribute="product">
		<p>
			<form:label path="name">Name</form:label>
			<form:input path="name"/>
			<form:errors path="name"></form:errors>
		</p>
		<p>
			<form:label path="description">Description</form:label>
			<form:textarea path="description"/>
			<form:errors path="description"></form:errors>
		</p>
		<p>
			<form:label path="price">Price</form:label>
			<form:input path="price"/>
			<form:errors path="price"></form:errors>
		</p>
		<form:button type="submit">Create</form:button>
	</form:form>
</body>
</html>