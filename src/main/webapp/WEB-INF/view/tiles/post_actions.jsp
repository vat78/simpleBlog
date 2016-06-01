
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<h4>Actions:</h4>
<ol class="list-unstyled">

    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username" var="loginId"/>

        <sec:authorize access="hasRole('ROLE_ADMIN') or '${loginId}' == '${post.author.name}'">
            <li><a href="/posts?edit=${post.id}">Edit post</a></li>
            <li><a href="#" onClick="deleteConfirm();">Delete post</a></li>
        </sec:authorize>

    </sec:authorize>
</ol>

<script>
    function deleteConfirm() {
        if (confirm("Are you shure?"))
        {
            top.location.href="/posts?delete=${post.id}"
        }
    }
</script>