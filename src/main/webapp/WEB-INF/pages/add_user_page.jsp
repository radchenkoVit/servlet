<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add User Page</title>
</head>
<body>

    <c:if test="${cookie.containsKey('user')}">
        <p> Hi DEAR ${cookie['user'].value}</p>
    </c:if>

    <form action="/user/add" method="post">
        <p>Name: <input name="name" type="text" placeholder="write here name"></p>
        <p>Phone: <input name="phone" type="text" placeholder="write here phone"></p>
        <p>Email: <input name="email" type="text" placeholder="write here email"></p>
        <p>Password: <input name="password" type="password" placeholder="write here pass"></p>
        <input type="submit">
    </form>

    <form action="/logout" method="get">
        <input type="submit" value="Logout">
    </form>

    <c:set var="total" value="${totalView}"/>
    <p>Total view of page: ${total.value}</p>
</body>
</html>
