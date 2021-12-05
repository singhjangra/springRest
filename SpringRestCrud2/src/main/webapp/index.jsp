<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<body>

<h3>Spring CRM REST Demo</h3>

<hr>
	path==${pageContext.request.contextPath}
	<a href="${pageContext.request.contextPath}/api/customers">Customers</a>
	
	<a href="${pageContext.request.contextPath}/api/customers/3">Customer</a>
</body>
</html>