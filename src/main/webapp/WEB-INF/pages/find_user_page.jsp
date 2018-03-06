<%--
  Created by IntelliJ IDEA.
  User: Vitalii
  Date: 3/6/2018
  Time: 2:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Find User Page</title>
</head>
<body>

    <c:if test="${cookie.containsKey('user')}">
        <p> Hi DEAR ${cookie['user'].value}</p>
    </c:if>

    <form action="/user/find" method="post">
        <input name="email" type="text" placeholder="Type user email">
        <input type="submit" value="Find User">
    </form>

    <form action="/logout" method="get">
        <input type="submit" value="Logout">
    </form>

    <c:set var="total" value="${totalView}"/>
    <p>Total view of page: ${total.value}</p></body>
</body>
</html>
