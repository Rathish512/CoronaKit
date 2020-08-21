 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
 <%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "rathishdb";
String userid = "root";
String password = "root";
try {
Class.forName(driver);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<html>
<head>
<title> CoronaKit Order </title>
</head>
<body>
<jsp:include page="visitor.jsp" />
<form action ="addKit" method="post">

<h3>List of items that are currently in stock</h3>

	<table border="1" cellspacing="5px" cellpadding="5px">
	<tr>
		<th>Name</th>
		<th>Description</th>
		<th>Cost</th>
		<th>Item Number</th>
	</tr>
	<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql ="select * from coronakit";
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr>
<td><%=resultSet.getString("name") %></td>
<td><%=resultSet.getString("description") %></td>
<td><%=resultSet.getString("cost") %></td>
<td><%=resultSet.getString("id") %></td>
</tr>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
	</table>
	<br>
<hr/>
<br>
<div>
<label>Enter Item Number:</label>
<input type = "text"  name = "itemNumber"/>
</div>
<br>
<div>
<label>Enter Quantity:</label>
<input type = "text"  name = "quantity"/>
</div>
<br>
<div>
<label>Enter Name:</label>
<input type = "text"  name = "Name"/>
</div>
<br>
<div>
<label>Enter Address:</label>
<textarea name = "Address">
</textarea>
</div>
<br>
<input type = "submit"  name = "save" />
</form>
</body>
</html>