<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org" xmlns:sec="https://www.thymeleaf.org/thymeleaf-extras-springsecurity5">
    <head>
        <title>Hello Spring Security</title>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="/css/main.css" th:href="@{/css/main.css}" />
    </head>
    <body>
        
        <h1>Hello Spring Security</h1>
        <p>This is an unsecured page, but you can access the secured pages after authenticating.</p>
        <ul>
            <li>Go to the <a href="/login" th:href="@{/login}">secured pages</a></li>
        </ul>
    </body>
</html>