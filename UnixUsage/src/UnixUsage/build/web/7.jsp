<%--
    Document   : 7.jsp
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
        <title>Query 7</title>
    </head>
    <body>
        <h1>Query 7</h1>
        <h2>Find the differences in workloads for students who have the GPAs from 3.4 and up versus the rest of students</h2>
        <form method="POST" action="Query7.do">
            <center>
                <input type="SUBMIT">
            </center>
        </form>
        <c:if test="${errMsg != null}">
            Error encountered:<br><br>${errMsg}
        </c:if>

        <c:if test="${highGPAResults != null}">
        <h2>Results</h2>
        <table border="5">
            <tr>
                <td>Workload for students having 3.4 GPA or higher</td>
                <td>${highGPAResults}</td>
            </tr>
            <tr>
                <td>Workload for the rest of the students</td>
                <td>${lowGPAResults}</td>
            </tr>
        </table>
        </c:if>
        <div align="center"><a href="index.jsp">Return Home</a></div>
    </body>
</html>
