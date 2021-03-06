<!DOCTYPE html>
<html  xmlns:th="https://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
    <head>
        <title>Hello Spring Security</title>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="/css/main.css" th:href="@{/css/main.css}" />
    </head>
    <body>
        <div th:substituteby="index::logout"></div>
        <h1>This is a secured page!</h1>
        <h1 th:text="${temp}"></h1>
        <div sec:authorize="isAuthenticated()" style="display: inline-block;">
    Welcome, <span sec:authentication="name"></span>   
</div>
<div sec:authorize="hasRole('ROLE_ADMIN')">
  This content is only shown to administrators.
</div>
        <p><a href="/admin/admin" th:href="@{/admin/admin}">Access Admin Page</a></p>
        <p><a href="/login" th:href="@{/login}">Back to home page</a></p>

    </body>
</html>