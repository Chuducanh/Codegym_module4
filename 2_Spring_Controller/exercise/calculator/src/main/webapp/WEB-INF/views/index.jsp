<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/index" method="post">
    <h2>Calculator</h2>
    <div style="display: inline-block">
        <input type="text" name="val1">
        <input type="text" name="val2">
    </div>

    <div style="display: inline-block">
        <button type="submit" name="function" value="+">Addition(+)</button>
        <button type="submit" name="function" value="-">Subtraction(-)</button>
        <button type="submit" name="function" value="*">Multiplication(X)</button>
        <button type="submit" name="function" value="/">Division(/)</button>
    </div>
</form>
<div>Result: ${result}</div>
</body>
</html>