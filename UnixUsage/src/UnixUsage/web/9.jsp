<%--
    Document   : 9.jsp
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
        <title>Query 9</title>
    </head>
    <body>
        <h1>Query 9</h1>
        <h2>Find the workload differences for graduate versus undergraduate students</h2>
        <form method="POST" action="Query9.do">
            <center>
                <input type="SUBMIT">
            </center>
        </form>
        <c:if test="${errMsg != null}">
            Error encountered:<br><br>${errMsg}
        </c:if>

        <c:if test="${undergradResults != null}">
        <h2>Results</h2>
        <table border="5">
            <tr>
                <td>Undergraduate Workload</td>
                <td>${undergradResults}</td>
            </tr>
            <tr>
                <td>Graduate Workload</td>
                <td>${gradResults}</td>
            </tr>
        </table>
        </c:if>
        <div align="center"><a href="index.jsp">Return Home</a></div>
    </body>
</html>
