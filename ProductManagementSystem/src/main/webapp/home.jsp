<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 0;
        }
        header {
            background-color: #2c3e50;
            color: white;
            padding: 15px;
            text-align: center;
        }
        nav {
            margin: 40px auto;
            text-align: center;
        }
        nav a {
            display: inline-block;
            margin: 15px;
            padding: 12px 20px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
        }
        nav a:hover {
            background-color: #2980b9;
        }
        footer {
            margin-top: 40px;
            text-align: center;
            padding: 10px;
            background-color: #ddd;
        }
    </style>
</head>
<body>
    <header>
        <h1>Product Management System</h1>
    </header>

    <nav>
        <a href="./addProduct.html">➕ Add Product</a>
        <a href="./editProduct.html">✏️ Edit Product</a>
        <a href="./deleteProduct.html">❌ Delete Product</a>
        <a href="./searchProduct.html">🔍 Search Product</a>
        <a href="./displayServlet">📋 Display All Products</a>
    </nav>

    <footer>
        <p>&copy; 2026 Product Management Portal</p>
    </footer>
</body>
</html>