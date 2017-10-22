<%--
  Created by IntelliJ IDEA.
  User: jake-python
  Date: 10/21/17
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get author information by name</title>
</head>
<body>
<form action="/book/info/author">
    <label for="authorName">Author Name:</label>
    <input type="text" name="author"/>
    <input type="submit" value="Search for author"/>
</form>
</body>
</html>
