<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/edit/${book.bookId}" method="post">
        <div class="form-group">
            <label for="bookName">Book Name</label>
            <input type="text" id="bookName" name="bookName" value="${book.bookName}" placeholder="Enter book name" required>
        </div>
        <div class="form-group">
            <label for="author">Author</label>
            <input type="text" id="author" name="author" value="${book.author}" placeholder="Enter author's name" required>
        </div>
        <div class="form-group">
            <button type="submit">Update Book</button>
        </div>
    </form>
</body>
</html>
