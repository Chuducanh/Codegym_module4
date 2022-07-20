<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        div {
            display: inline-block;
        }
    </style>
</head>
<body>
<form action="/index" method="post">
    <div class="condiment"><input type="checkbox" name="condiment" value="lecture">lettuce</div>
    <div class="condiment"><input type="checkbox" name="condiment" value="tomato">tomato</div>
    <div class="condiment"><input type="checkbox" name="condiment" value="mustard">mustard</div>
    <div class="condiment"><input type="checkbox" name="condiment" value="sprouts">sprouts</div>
    <div><input type="submit" value="save"></div>
</form>
<span>
    Your sandwich has: ${res}
</span>
</body>
</html>