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
	<form:form action="/category_form" method="post" modelAttribute="category">
		<div>
			<form:label path="name">Name</form:label>
			<form:input path="name"/>
			<form:errors path="name"></form:errors>
		</div>
		<form:button type="submit">Create</form:button>
	</form:form>
</body>
</html>