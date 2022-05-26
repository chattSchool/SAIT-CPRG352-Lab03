<%-- 
    Document   : agecalculator
    Created on : 26-May-2022, 11:16:10 AM
    Author     : Dakota
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        
        <form method="post" action="age">
            <label>Enter your age: </label>
            <input type="text" name="age" value="">
            <br>
            <input type="submit" value="Age next birthday">
        </form>
        <span>${message}</span>
        <br>
        <a href="#">Arithmetic Calculator</a>
    </body>
</html>
