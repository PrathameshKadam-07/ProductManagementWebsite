<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
You have Put <%= request.getAttribute("qty") %> which is greater then present Quantity.<br><br>
<a href="./home.jsp">Home</a> | <a href="./deleteProduct">Delete Item</a>
</body>
</html>