<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Delete User Page</title>
</head>
<body>

    <c:if test="${cookie.containsKey('user')}">
        <p> Hi DEAR ${cookie['user'].value}</p>
    </c:if>

</body>
</html>
