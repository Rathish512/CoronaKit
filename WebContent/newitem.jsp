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
<h3>${isNew?'newItem':'editItem' }</h3>
<form action="${isNew?'addItem':'saveItem'}" method="post">
<div>
<label>Id</label>
<input type="number" name="id" value="${coronaKit.id}" required ${isNew?'':'readonly'}/>
</div>
<div>
<label>Name</label>
<input type="text" name="name" value="${coronaKit.name}" required />
</div>
<div>
<label>Description</label>
<input type="text" name="description" value="${coronaKit.description}" required />
</div>
<div>
<label>Cost</label>
<input type="decimal" name="cost" value="${coronaKit.cost}" required />
</div>
<button>SAVE</button>
</form>
</body>
</html>