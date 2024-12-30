<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Book</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #F4F4F4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .form-container {
            background: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }
        .form-container h2 {
            margin-bottom: 20px;
            color: #FF6F61;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #1A1A2E;
        }
        .form-group input[type="text"] {
            width: calc(100% - 10px);
            padding: 10px;
            border: 1px solid #00B8D4;
            border-radius: 5px;
            font-size: 16px;
            color: #1A1A2E;
        }
        .form-group input[type="text"]::placeholder {
            color: #555;
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #00B8D4;
            border: none;
            color: #fff;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .form-group button:hover {
            background-color: #FFEB3B;
            color: #1A1A2E;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Add Book</h2>
        <form action="${pageContext.request.contextPath}/add" method="post">
            <div class="form-group">
                <label for="bookName">Book Name</label>
                <input type="text" id="bookName" name="bookName" placeholder="Enter book name" required>
            </div>
            <div class="form-group">
                <label for="author">Author</label>
                <input type="text" id="author" name="author" placeholder="Enter author's name" required>
            </div>
            <div class="form-group">
                <button type="submit">Add Book</button>
            </div>
        </form>
    </div>
</body>
</html>
