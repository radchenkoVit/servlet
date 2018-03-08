<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Delete User Page</title>
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
                <li><a href="/index.html">Home</a></li>
                <li><a href="/add.html">Add User</a></li>
                <li class="active"><a href="/deleteuser.html">Delete User</a></li>
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

    <form class="form-horizontal" action="/user/delete" method="post">
        <div class="form-group">
            <label class="control-label col-sm-2" for="email">Email to delete:</label>
            <div class="col-sm-4">
                <input name="userEmailToDelete" type="text" class="form-control" id="email" placeholder="Enter email">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Delete User</button>
            </div>
        </div>
    </form>
</body>
</html>
