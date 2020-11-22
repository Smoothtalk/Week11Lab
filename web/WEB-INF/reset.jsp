<%-- 
    Document   : reset
    Created on : Nov 21, 2020, 7:51:59 PM
    Author     : 775653
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Page</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        <p>Please enter your email address to reset your password</p>
        <form method="post" action="reset">
            Email Address <input type="text" name="resetEmail" value="${resetEmail}">
            <br>
            <input type="submit" value="submit">
        </form>
            <p>avinash.chandiramani@edu.sait.ca</p>
    </body>
</html>
