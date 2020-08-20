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
<jsp:include page="visitor.jsp" />
<div>
<label>Select Items</label>
<select name="Select Items" required>
<option value="">--SELECT--</option>
<c:forEach items="${'FaceMask,Pocket Sanitizers,Gloves,Oximeter,Vitamin capsules'}" var="opt">
<option value="${opt}" ${opt.equals(coronaKit.name?'selected':'')}>${opt}
</option>
</c:forEach>
</select>
</div>
<br>
<div>
<label>Enter Quantity</label>
<input type="number" name="quantity" required/>
</div>
<br>
<button>SAVE</button>
</body>
</html>