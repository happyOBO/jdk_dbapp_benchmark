<%--
    Document   : 19
    Created on : Jul 4, 2009, 8:08:09 PM
    Author     : KTam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Query 19</title>
    </head>
    <body>
        <h1>Query 19</h1>
        <h2>Compute the ratio of FILE versus NETWORK commands that students who belong to each department used</h2>
        <form method="POST" action="Query19.do">
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
                <td>Department</td>
                <td>Ratio</td>
                <c:forEach var="resultKey" items="${sortedResultKeys}">
                    <tr>
                        <td>${resultKey}</td>
                        <td>${results[resultKey]}</td>
                    </tr>
                </c:forEach>
            </tr>
        </table>
        </c:if>
        <div align="center"><a href="index.jsp">Return Home</a></div>
    </body>
</html>
