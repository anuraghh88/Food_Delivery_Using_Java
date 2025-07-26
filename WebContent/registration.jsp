<%@ page import="java.net.URLEncoder" %>
<%
    String selectedItem = request.getParameter("item");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
    <h1>Register</h1>
    <form action="UserController" method="POST">
        <input type="hidden" name="item" value="<%= selectedItem != null ? selectedItem : "" %>">
        <input type="text" name="username" placeholder="Username"><br>
        <input type="password" name="password" placeholder="Password"><br>
        <input type="email" name="email" placeholder="Email"><br>
        <button type="submit">Register</button>
    </form>
</body>
</html>
