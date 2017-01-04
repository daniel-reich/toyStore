<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Toy Store</title>
</head>
<body>
Welcome to Garret's Toy Store<br><br>

Please enter your credentials:
<form name="login" method="POST" action="/login/">
    Email: <input type="text" name="employeeEmail" /><br><br>
    Password: <input type="text" name="employeePassword" /><br>
</form>

</body>
</html>