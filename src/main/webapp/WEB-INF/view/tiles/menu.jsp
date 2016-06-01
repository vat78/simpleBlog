<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav class="blog-nav">
    <a class="blog-nav-item active" href="/">Home</a>
    <a class="blog-nav-item" href="/posts?new">New post</a>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a class="blog-nav-item" href="/admin">Users</a>
    </sec:authorize>
    <sec:authorize access="isAnonymous()">
        <a class="blog-nav-item" href="/login">Login</a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <a class="blog-nav-item" href="/logout">Logout</a>
    </sec:authorize>
</nav>
