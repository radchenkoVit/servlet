<%--
  Created by IntelliJ IDEA.
  User: Vitalii
  Date: 2/20/2018
  Time: 12:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Web site navigation</h1>
    <ul>
        <li><a href="/add.html">Add User Page</a></li>
        <li><a href="/user/delete">Delete User Page</a></li>
        <li><a href="/finduser.html">Find User Page</a></li>
    </ul>

    <c:if test="${cookie.containsKey('errorMessage')}">
        <p> Hi DEAR ${cookie['errorMessage'].value}</p>
    </c:if>

</body>
</html>
