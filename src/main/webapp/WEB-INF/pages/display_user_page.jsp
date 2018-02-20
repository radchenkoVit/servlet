<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
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

    <form action="/logout" method="get">
        <input type="submit" value="Logout">
    </form>

    <c:set var="total" value="${totalView}"/>
    <p>Total view of page: ${total.value}</p></body>
</html>
