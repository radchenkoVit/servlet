<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add User Page</title>
</head>
<body>

    <form action="/user/add" method="post">
        <p>Name: <input name="name" type="text" placeholder="write here name"></p>
        <p>Phone: <input name="phone" type="text" placeholder="write here name"></p>
        <p>Email: <input name="email" type="text" placeholder="write here name"></p>
        <input type="submit">
    </form>

    <c:set var="total" value="${totalView}"/>
    <p>Total view of page: ${total.value}</p>
</body>
</html>
