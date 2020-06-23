<%--
    Document   : 16.jsp
    Created on : Jul 9, 2009, 12:21:14 AM
    Author     : KTam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Query 16</title>
    </head>
    <body>
        <h1>Query 16</h1>
        <h2>Given a unix command and a graduate level, output commands that share the same complexity with the given command and users at the same graduate level who used these commands</h2>
        <form method="POST" action="Query16.do">
            <table>
                <tr>
                    <td>Unix Command: </td>
                    <td><input type="text" name="unixCommand" value="${unixCommand}"/></td>
                </tr>
                <tr>
                    <td>Graduate Level </td>
                    <td>
                        <select name="gradLevel" size="1">
                            <option value="0" <c:if test="${gradLevel == 0}">selected</c:if>>Undergraduate</option>
                            <option value="1" <c:if test="${gradLevel == 1}">selected</c:if>>Graduate</option>
                        </select>
                    </td>
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

        <c:if test="${results != null}">
        <h2>Results</h2>
        <table border="5">
            <tr>
                <td>Command</td>
            </tr>
            <c:forEach var="result" items="${results}">
                <tr>
                    <td>${result}</td>
                </tr>
            </c:forEach>
        </table>
        </c:if>
        <div align="center"><a href="index.jsp">Return Home</a></div>
    </body>
</html>
