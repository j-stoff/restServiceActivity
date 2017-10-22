<%--
  Created by IntelliJ IDEA.
  User: jake-python
  Date: 10/21/17
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get book by id</title>
</head>
<body>
<form action="/book/info/id">
    <label for="bookId">Book Id:</label>
    <input type="text" name="bookId"/>

    <input type="submit" value="Search by ID"/>
</form>
</body>
</html>
