<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test</title>
</head>
<body>
<h1>Users</h1>
<c:if test="${empty person}">
	No records found!
</c:if>
<table style="border: 1px solid; width: 500px; text-align:center">
	<thead style="background:#fcf">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>id</th>
			<th colspan="4"></th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${person}" var="persons">
		<tr>
		<td><c:out value="${person.primer_nombre}"/></td>
		<td><c:out value="${person.primer_apellido}"/></td>
		<td><c:out value="${person.id}"/></td>
		</tr>
	</c:forEach>
	
	</tbody>
</table>
</body>
</html>