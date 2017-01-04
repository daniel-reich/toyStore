<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Current Inventory</title>
</head>
<body>
<h1>Current Inventory</h1>

Welcome <c:out value="${username}"/>

<form name="userStats" method="POST" action="/user/getUserStats">
    Quiz Category: <select name="category">
    <c:forEach var="category" items="${categories}">
        <option value="<c:out value="${category}"/>"><c:out value="${category}"/></option>
    </c:forEach>
</select><br><br>

    Question Type: <select name="questionType">
    <c:forEach var="questionType" items="${questionTypes}">
        <option value="<c:out value="${questionType}"/>"><c:out value="${questionType}"/></option>
    </c:forEach>
</select><br><br>
    Question Difficulty: <select name="difficulty">
    <c:forEach var="difficulty" items="${difficulties}">
        <option value="<c:out value="${difficulty}"/>"><c:out value="${difficulty}"/></option>
    </c:forEach>
</select><br><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <input type="submit" value="Let the Quiz Begin">
</form>


<div style="color:green;font-weight: bold;">
    <c:out value="${correct}" />
</div>


<div style="color:red;font-weight: bold;">
    <c:out value="${incorrect}" />
</div>

<br><br><br><br>
<a href="/admin/">admin</a>
<a href="/user/">Login as User</a>
<a href="/user/newUser">Create User</a>
</body>
</html>