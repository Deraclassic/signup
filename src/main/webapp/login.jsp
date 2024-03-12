<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 3/11/24
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div align="center">
    <h2>Login</h2>
    <form action="login-servlet" method="post">
        Email: <input type="email" name="email" required><br /><br />
        Password: <input type="password" name="password" required><br /><br />
        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>
