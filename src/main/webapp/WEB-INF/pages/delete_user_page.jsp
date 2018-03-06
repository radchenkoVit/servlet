<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Delete User Page</title>
</head>
<body>

    <ul>
        <li><a href="/user/add">Add User Page</a></li>
        <li><a href="/user/delete">Delete User Page</a></li>
        <li><a href="/user/find">Find User Page</a></li>
    </ul>

    <c:if test="${cookie.containsKey('user')}">
        <p> Hi DEAR ${cookie['user'].value}</p>
    </c:if>

</body>
</html>
