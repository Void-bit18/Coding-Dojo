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
	<div class="container">
		<h1>Edit a project</h1>
		<a href="/dash">Back to dashboard.</a>
		<form:form action="/projects/edit/${oneProject.id }" method="put" modelAttribute="oneProject" class="form-control">
		<form:hidden path="teamlead"/>
			<div>
				<form:label path="title" class="form-label">Title</form:label>
				<form:input path="title" type="text" class="form-control"/>
				<form:errors path="title" class="text-danger"/>
			</div>
			<div>
				<form:label path="author" class="form-label">Author: </form:label>
				<form:input path="author" type="text" class="form-control"/>
				<form:errors path="author" class="text-danger"/>
			</div>
			<div>
				<form:label path="description" class="form-label">My Thoughts: </form:label>
				<form:textarea path="description" class="form-control"/>
				<form:errors path="description" class="text-danger"/>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
   
</body>
</html>