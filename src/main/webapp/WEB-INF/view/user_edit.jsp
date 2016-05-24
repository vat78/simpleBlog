<%--
  Created by IntelliJ IDEA.
  User: vat
  Date: 24.05.16
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/resources/img/favicon.ico">

    <title>Edit user</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="/resources/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/blog.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="/resources/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="/resources/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav">
            <a class="blog-nav-item active" href="../">Home</a>
            <a class="blog-nav-item" href="#">New features</a>
            <a class="blog-nav-item" href="#">Press</a>
            <a class="blog-nav-item" href="#">New hires</a>
            <a class="blog-nav-item" href="#">About</a>
        </nav>
    </div>
</div>

<div class="container">

    <div class="blog-header">
        <h1 class="blog-title">
        </h1>
        <p class="lead blog-description">

            <c:if test="${user.name} == ''">
                Create user
            </c:if>

            <c:if test="${user.name} != ''">
                Edit user <c:out value="${user.fullName}" />:</p>
            </c:if>

    </div>

    <div class="row">

        <div class="col-sm-8 blog-main">

            <sf:form method="POST" modelAttribute="user">
                <fieldset>

                    <table cellpadding="0">

                        <tr>
                            <th>
                                <label for="user_name">User name:</label>
                            </th>
                            <td>
                                <sf:input path="id" type="hidden" id="user_id"/>
                                <sf:input path="name" maxlength="50" size="50" id="user_name" /><br/>
                                <small><sf:errors path="name" type="text.error" /></small>
                            </td>
                        </tr>

                        <tr>
                            <th>
                                <label for="user_password">Password:</label>
                            </th>
                            <td>
                                <sf:password path="password" maxlength="50" size="50" id="user_password" /><br/>
                                <small><sf:errors path="password" type="text.error" /></small>
                            </td>
                        </tr>

                        <tr>
                            <th>
                                <label for="user_fullname">Full name:</label>
                            </th>
                            <td>
                                <sf:input path="fullName" size="50" id="user_fullname" />
                            </td>
                        </tr>

                        <tr>
                            <th>
                                <label for="user_admin">Admin rights:</label>
                            </th>
                            <td>
                                <sf:checkbox path="admin" id="user_admin" />
                            </td>
                        </tr>

                        <tr>
                            <th></th>
                            <td>
                                <sf:button id="save" name="save">
                                    Save
                                </sf:button>
                            </td>
                        </tr>

                    </table>
                </fieldset>
            </sf:form>


        </div><!-- /.blog-main -->

        <div class="col-sm-3 col-sm-offset-1 blog-sidebar">
            <div class="sidebar-module sidebar-module-inset">
                <h4>About</h4>
                <p>Fill all fields for create/edit user.</p>
            </div>
            <div class="sidebar-module">

            </div>
            <div class="sidebar-module">

            </div>
        </div><!-- /.blog-sidebar -->

    </div><!-- /.row -->

</div><!-- /.container -->

<footer class="blog-footer">
    <p>Blog template built for <a href="http://getbootstrap.com">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
    <p>
        <a href="#">Back to top</a>
    </p>
</footer>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="/resources/js/vendor/jquery.min.js"><\/script>')</script>
<script src="/resources/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/resources/js/ie10-viewport-bug-workaround.js"></script>

</body>
</html>