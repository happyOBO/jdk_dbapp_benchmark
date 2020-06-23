<%--
    Document   : 8
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
        <title>Query 8</title>
    </head>
    <body>
        <h1>Query 8</h1>
        <h2>Find the workload for students who reside in given offices</h2>
        <form method="POST" action="Query8.do">
            <table>
                <tr>
                    <td>Office: </td>
                </tr>
                <c:forEach var="office" items="${allOffices}">
                <tr>
                    <td>
                        <input type="checkbox" name="selectedOffices"
                            <c:forEach var="selectedOffice" items="${selectedOffices}">
                                <c:if test="${selectedOffice == office.officeId}">checked</c:if>
                            </c:forEach>
                        value="${office.officeId}"/>${office.officeName}
                    </td>
                </tr>
                </c:forEach>
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
                <td>User</td>
                <td>Workload</td>
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
