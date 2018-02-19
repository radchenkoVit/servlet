<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Display User Page</title>
</head>
<body>
    <p>User info</p>

    <c:set var="user" value="${userFromBack}"/>
    <p>Name: ${user.name}</p>
    <p>Phone: ${user.phone}</p>
    <p>Email: ${user.email}</p>
    <input type="submit">


    <c:set var="total" value="${totalView}"/>
    <p>Total view of page: ${total}</p>
</body>
</html>
