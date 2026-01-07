<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="obj" class="Bean.ProductBean"/>
<%

if(request.getAttribute("n") != null){
	%>
    <h3 style="color: green;">YES, PRODUCT PRESENT</h3>
    <p>Product Details: <br><br><%= request.getAttribute("n") %></p>
<%
} else {
%>
    <h3 style="color: red;">NO, PRODUCT NOT PRESENT</h3>
<%
}
%>

</body>
</html>