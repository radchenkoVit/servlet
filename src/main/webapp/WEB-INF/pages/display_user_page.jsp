<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Display User Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">WebSiteName</a>
            </div>
            <ul class="nav navbar-nav">
                <li class="active"><a href="/index.html">Home</a></li>
                <li><a href="/add.html">Add User</a></li>
                <li><a href="/deleteuser.html">Delete User</a></li>
                <li><a href="/finduser.html">Find User</a></li>
            </ul>
            <form class="navbar-form navbar-left" action="#">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search" name="search">
                    <div class="input-group-btn">
                        <button class="btn btn-default" type="submit">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </div>
                </div>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Total view ${totalView.value}</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Hi Dear ${cookie['user'].value}</a></li>
                <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span>Logout</a></li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <c:set var="user" value="${userFromBack}"/>
        <div class="row">
            <div class="col-md-4">User info</div>
        </div>
        <div class="row">
            <div class="col-md-4">Name: ${user.name}</div>
        </div>
        <div class="row">
            <div class="col-md-4">Phone: ${user.phone}</div>
        </div>
        <div class="row">
            <div class="col-md-4">Email: ${user.email}</div>
        </div>
    </div>
</html>
