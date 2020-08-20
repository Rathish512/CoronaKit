<html>
<header>
	<h1>Welcome Admin!</h1>
	<h2>Please review the items list and Add/Edit/Delete accordingly!</h2>
	<hr />
	<nav>
		<a href="list">Items List</a>
		<span>|</span>
		<a href="newItem">New Item</a>
		<span>|</span>
		<a href="index.jsp">Logout</a>			
	</nav>
	<hr />
</header>
<body>
<c:if test="${msg != null }">
		<p><strong>${msg}</strong></p>
	</c:if>
</body>
</html>
