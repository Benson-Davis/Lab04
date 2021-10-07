<%-- 
    Document   : viewnote
    Created on : 6-Oct-2021, 3:26:05 PM
    Author     : bdavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p>Title: ${theNote.title}</p>
        <p>Contents:</p>
        <p>${theNote.contents}</p>
        <p><a href="note?edit">Edit</a></p>        
    </body>
</html>