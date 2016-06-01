
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<c:forEach var="post" items="${posts}">

    <s:url value="/users/{userName}" var="user_url">
        <s:param name="userName" value="${post.author.id}" />
    </s:url>

    <s:url value="/posts/{postId}" var="post_id">
        <s:param name="postId" value="${post.id}" />
    </s:url>


    <div class="blog-post">
        <h2 class="blog-post-title">
            <a href="${post_id}">
                <c:out value="${post.title}" />
            </a>
        </h2>
        <p class="blog-post-meta">
            <c:out value="${post.created}" />
            by <a href="${user_url}">
            <c:out value="${post.author.fullName}" />
        </a>
        </p>

        <p> <c:out value="${post.text}" /></p>
    </div><!-- /.blog-post -->

</c:forEach>
