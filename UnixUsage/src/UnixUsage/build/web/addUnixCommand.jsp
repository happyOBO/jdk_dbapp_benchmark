<%-- 
    Document   : addUnixCommand
    Created on : Jul 12, 2009, 12:28:13 AM
    Author     : Mukarram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Unix Command</title>
    </head>
    <body>
        <h1>Add Unix Command</h1>

        <form method="POST" action="AddUnixCommand.do">
            <table>
                <tr>
                    <td>Unix Command: </td>
                    <td><input type="text" name="unixCommand" value="${unixCommand.unixCommand}" /></td>
                </tr>
                <tr>
                    <td>Category: </td>
                    <td><input type="text" name="category" value="${unixCommand.category}" /></td>
                </tr>
            </table>
            <br><br>
            <center>
                <input type="SUBMIT">
            </center>
        </form>
        <c:if test="${errMsg != null}">
            Error encountered:<br><br>${errMsg}
        </c:if>
        <c:if test="${msg != null}">
            ${msg}
        </c:if>

        <div align="center"><a href="index.jsp">Return Home</a></div>

</html>
