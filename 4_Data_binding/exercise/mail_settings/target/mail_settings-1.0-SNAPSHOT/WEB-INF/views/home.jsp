<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Settings</h2>
<form:form action="user" method="post" modelAttribute="setting">
        <table>
            <tr>
                <td><form:label path="language">Language:</form:label></td>
                <td><form:select path="language">
                    <form:option value="English" label="English"/>
                    <form:option value="Vietnamese" label="Vietnamese"/>
                    <form:option value="Chinese" label="Chinese"/>
                    <form:option value="Japanese" label="Japanese"/>
                </form:select></td>
            </tr>
            <tr>
                <td><form:label path="pageSize">Page Size: </form:label></td>
                <td>Show <form:select path="pageSize">
                    <form:option value="15" label="15"/>
                    <form:option value="25" label="25"/>
                    <form:option value="50" label="50"/>
                    <form:option value="100" label="100"/>
                    </form:select> emails per page</td>
            </tr>
            <tr>
                <td><form:label path="spam">Spams filter: </form:label></td>
                <td><form:checkbox path="spam" value="true"/> Enable spams filter</td>
            </tr>
            <tr>
                <td><form:label path="signature">Signature: </form:label></td>
                <td><form:textarea path="signature"/></td>
            </tr>
            <tr>
                <td><form:button>Save</form:button></td>
            </tr>
        </table>
</form:form>
</body>
</html>