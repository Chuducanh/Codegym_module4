<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<form action ="/translate" method="post">
    <div>
        <label>Nhập từ cần dịch: </label>
        <input type="text" name="english" value="${english}">
    </div>
    <div>
        <label>Được hiểu là: </label>
        <span>${viet}</span>
    </div>
</form>

</body>
</html>