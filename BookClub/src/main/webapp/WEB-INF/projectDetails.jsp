<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Club</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">

		<h2><c:out value="${oneProject.title}"/></h2>
		<a href="/dash">Back to the shelves.</a>
		<br>
		<h4><c:out value="${oneProject.teamlead.userName}"/> read <c:out value="${oneProject.title}"/> by <c:out value="${oneProject.author}"/>.</h4>
		<h5>Here are <c:out value="${oneProject.teamlead.userName}"/>'s thoughts: </h5>
		<br>
		<br>
		<c:out value="${oneProject.description}"/>

		
		<c:if test="${oneProject.teamlead.id == userId }">
		<div>
			<form>
				<a href="/projects/edit/${oneProject.id}">Edit</a>
			</form>
			<form action="/projects/${oneProject.id }" method="post">
				<input type="hidden" name="_method" value="delete" />
				<button type="submit" class="btn btn-danger">Delete</button>
			</form>
		</div>
		</c:if>
		
	</div>
   
</body>
</html>