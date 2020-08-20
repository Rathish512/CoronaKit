<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CoronaKit Order</title>
</head>
<body>
<jsp:include page="header.jsp" />
<c:choose>
	<c:when test="${coronaKits==null || coronaKits.isEmpty() }">
	<p>No Items. List is Empty! </p>
	</c:when>
	<c:otherwise>
	<table border="1" cellspacing="5px" cellpadding="5px">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Description</th>
		<th>Cost</th>
		<th>Actions</th>
	</tr>
	<c:forEach items="${coronaKits}" var="coronaKit">
	<tr>
	<td>${coronaKit.id}</td>
	<td>${coronaKit.name}</td>
	<td>${coronaKit.description}</td>
	<td>${coronaKit.cost}</td>
	<td>
		<a href="deleteItem?id=${coronaKit.id}">DELETE</a>
		<span>|</span>
		<a href="editItem?id=${coronaKit.id}">EDIT</a>
	</td>
	</tr>
	</c:forEach>
	</table>
	</c:otherwise>
</c:choose>
</body>
</html>