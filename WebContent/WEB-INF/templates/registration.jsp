<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="https://www.thymeleaf.org">
    <head>
        <title>Registration page</title>
        <meta charset="utf-8" />
        <link rel="stylesheet" href="/css/main.css" th:href="@{/css/main.css}" />
	</head>
    <body>
        <h1>Registration page</h1>
        <form th:action="@{/registration}" method="post">
            <label for="username">Username</label>:
            <input type="text" id="username" name="username" autofocus="autofocus" /> <br />
            <label for="password">Password</label>:
            <input type="password" id="password" name="password" /> <br />
            <label for="password">Confirm your password</label>:
            <input type="password" id="passwordConfirm" name="passwordConfirm" /> <br />
            <input type="submit" value="submit" />
        </form>
        <p><a href="/index" th:href="@{/index}">Back to home page</a></p>
    </body>
</html>