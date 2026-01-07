<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="5" width = "100%">
<tr>
<th>Product id</th>
<th>Product name</th>
<th>Price</th>
<th>Qty</th>
</tr>
<c:forEach var="table" items="${productList}">
<tr>
<td><c:out value="${table.pid}"/></td>
<td><c:out value="${table.pname}"/></td>
<td><c:out value="${table.price}"/></td>
<td><c:out value="${table.qty}"/></td>
</tr>
</c:forEach>
</table>
</body>
</html>