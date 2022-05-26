<%-- 
    Document   : arithmeticcalculator
    Created on : 26-May-2022, 1:22:21 PM
    Author     : Dakota
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        
        <form method="post" action="arithmetic">
            <label>First: </label>
            <input type="text" name="firstNum" value="${firstNum}">
            <br>
            <label>Second: </label>
            <input type="text" name="secondNum" value="${secondNum}">
            <br>
            <input type="submit" name="button" value="+">
            <input type="submit" name="button" value="-">
            <input type="submit" name="button" value="*">
            <input type="submit" name="button" value="%">
        </form>
        
        <p>Result: ${result}</p>
        <a href="age">Age Calculator</a>
    </body>
</html>
