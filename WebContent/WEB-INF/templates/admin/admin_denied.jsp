<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org">
    <head>
        <title>Hello Spring Security</title>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="/css/main.css" th:href="@{/css/main.css}" />
    </head>
    <body>
        <div th:substituteby="index::logout"></div>
        <h1>Forbidden access</h1>
        <h1 th:text="${temp}"></h1>
        
        <p><a href="/login" th:href="@{/login}">Back to home page</a></p>
    </body>
</html>