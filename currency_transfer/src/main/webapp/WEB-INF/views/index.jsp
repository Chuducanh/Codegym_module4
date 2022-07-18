<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<form action="/transfer" method="post">
  <div><label for="dollar">Tiền muốn chuyển: </label></div>
  <div><input type="text" name="dollar" value="${dollar}"></div>
  <div><label for="viet">Tiền sau khi chuyển: </label></div>
  <div><span name="viet">${viet} ngàn đồng</span></div>
</form>
</body>
</html>