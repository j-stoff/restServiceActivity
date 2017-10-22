<%--
  Created by IntelliJ IDEA.
  User: jake-python
  Date: 10/21/17
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get book by title</title>
</head>
<body>
<form action="/book/info/title">
    <label for="bookTitle">Book Title:</label>
    <input type="text" name="bookTitle"/>
    <br/>
    <input type="submit" value="Search by title"/>
</form>
</body>
</html>
