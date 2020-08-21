<html>
<head>
<title>Corona Kit Order</title>
</head>
<body>
<form action="confirmation.jsp">
<jsp:include page="visitor.jsp" />
<h2>Please review the details and place the order!</h2>
<p>Name: ${name} </p>
<p>Total Amount: ${totalAmount} </p>
<p>Address: ${address} </p>
<button>Place Order</button>
</form>
</body>
</html>

