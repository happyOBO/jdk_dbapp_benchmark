<%--
    Document   : 18
    Created on : Jul 4, 2009, 7:50:07 PM
    Author     : KTam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Query 18</title>
    </head>
    <body>
        <h1>Query 18</h1>
        <h2>Compute the ratio of FILE versus NETWORK commands that students who belong to the department of computer science used</h2>
        <form method="POST" action="Query18.do">
            <table>
                <tr>
                    <td>Department: </td>
                    <td>
                        <select name="selectedDept" size="1">
                            <c:forEach var="dept" items="${allDepts}">
                                <c:if test="${dept.deptName == 'Computer Science'}">
                                    <option value="${dept.deptId}">
                                        ${dept.deptName}
                                    </option>
                                </c:if>
                            </c:forEach>
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
                <td>Ratio</td>
            </tr>
            <tr>
                <td>${results}</td>
            </tr>
        </table>
        </c:if>
        <div align="center"><a href="index.jsp">Return Home</a></div>
    </body>
</html>

