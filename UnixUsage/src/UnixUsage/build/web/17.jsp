<%--
    Document   : 17.jsp
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
        <title>Query 17</title>
    </head>
    <body>
        <h1>Query 17</h1>
        <h2>Partition and output names of users based on categories of the commands that these users used</h2>
        <form method="POST" action="Query17.do">
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
                <td>Category</td>
                <td>Users</td>
            </tr>
            <c:forEach var="result" items="${results}">
                <tr>
                    <td>${result.key}</td>
                    <td>${result.value}</td>
                </tr>
            </c:forEach>
        </table>
        </c:if>
        <div align="center"><a href="index.jsp">Return Home</a></div>
    </body>
</html>
