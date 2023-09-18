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
		<P>Welcome, <c:out value="${userName}"/> | <a href="/logout">Logout</a>
		<p><a href="/projects/new">+Add a book to my shelf!</a>
		<h3>Books from everyone's shelves</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="eachProject" items="${projectList }">
					<tr>
						<td> ${eachProject.id } </td>
						<td> <a href="/projects/${eachProject.id }"><c:out value="${eachProject.title }"/></a></td>
						<td> <c:out value="${eachProject.author }"/> </td>
						<td> <c:out value="${eachProject.teamlead.userName }"/> </td>
						
						
					</tr>
					
				</c:forEach>
			</tbody>
			
			
		</table>
	</div>
   
</body>
</html>