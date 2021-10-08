<%-- 
    Document   : editnote
    Created on : 6-Oct-2021, 3:26:58 PM
    Author     : bdavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            <label>Title: </label>
            <input type="text" name="titleText" value="${theNote.title}"><br>
            <label>Contents: </label>
            <textarea name="contentsText" rows="6" cols="30" >${theNote.contents}</textarea><br>
            <input type="submit" name="submitButton" value="Save">
        </form>
    </body>
</html>
