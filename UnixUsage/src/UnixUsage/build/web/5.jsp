<%-- 
    Document   : 5
    Created on : Jul 4, 2009, 6:42:15 PM
    Author     : KTam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Query 5</title>
    </head>
    <body>
        <h1>Query 5</h1>
        <h2>Find the workload for students who belong to a given department</h2>
        <form method="POST" action="Query5.do">
            <table>
                <tr>
                    <td>Department: </td>
                    <td>
                        <select name="selectedDept" size="1">
                            <c:forEach var="dept" items="${allDepts}">
                                <option value="${dept.deptId}" <c:if test="${dept.deptId == selectedDept}">selected</c:if>>
                                    ${dept.deptName}
                                </option>
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
                <td>User Name</td>
                <td>Workload</td>
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

