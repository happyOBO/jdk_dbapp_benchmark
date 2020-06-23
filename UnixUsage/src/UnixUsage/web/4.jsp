<%--
    Document   : 4
    Created on : Jul 8, 2009, 12:49:45 AM
    Author     : KTam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Query 4</title>
    </head>
    <body>
        <h1>Query 4</h1>
        <h2>Given the range of student scores, compute how student workload changes (number of commands that they execute)</h2>
        <form method="POST" action="Query4.do">
            <table>
                <tr>
                    <td>Starting Score: </td>
                    <td>
                        <input type="text" name="startingScore" value="${startingScore}"/>
                    </td>
                </tr>
                <tr>
                    <td>Ending Score: </td>
                    <td>
                        <input type="text" name="endingScore" value="${endingScore}"/>
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
                <td>Student</td>
                <td>Workload</td>
                <c:forEach var="result" items="${results}">
                    <tr>
                        <td>${result.key}</td>
                        <td>${result.value}</td>
                    </tr>
                </c:forEach>
            </tr>
        </table>
        </c:if>
        <div align="center"><a href="index.jsp">Return Home</a></div>
    </body>
</html>

