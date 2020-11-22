<%-- 
    Document   : resetNewPassword
    Created on : Nov 22, 2020, 1:19:47 PM
    Author     : 775653
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password Page</title>
    </head>
    <body>
        <h1>Enter new Password</h1>
        <form method="post" action="reset">
            <input type="text" name="newPassword">
            <input type="submit" value="Submit">
            <input type="hidden" name="uuid" value="${uuid}">
        </form>
    </body>
</html>
