<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Library Management</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #F4F4F4;
            color: #1A1A2E;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            width: 100%;
        }
        h1 {
            color: #FF6F61;
            margin-bottom: 20px;
        }
        a {
            display: inline-block;
            margin: 10px;
            padding: 10px 20px;
            background-color: #00B8D4;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }
        a:hover {
            background-color: #FFEB3B;
            color: #1A1A2E;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Library Management</h1>
        <a href="${pageContext.request.contextPath}/add">Add Book</a>
        <a href="${pageContext.request.contextPath}/books">View Books</a>
    </div>
</body>
</html>
