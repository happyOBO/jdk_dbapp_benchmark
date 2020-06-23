<%-- 
    Document   : 12
    Created on : Jul 1, 2009, 12:49:45 AM
    Author     : KTam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Query 12</title>
    </head>
    <body>
        <h1>Query 12</h1>
        <h2>Given the department name and a race of the users as inputs, output the most popular commands executed by users who work at that department and belong to this race</h2>
        <form method="POST" action="Query12.do">
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
                <tr>
                    <td>Race: </td>
                    <td>
                        <select name="selectedRace" size="1">
                            <c:forEach var="race" items="${allRaces}">
                                <option value="${race.raceCode}" <c:if test="${race.raceCode == selectedRace}">selected</c:if>>${race.race}</option>
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
                <td>Command</td>
                <td>Number of executions</td>
            </tr>
            <c:forEach var="resultKey" items="${sortedResultKeys}">
                <tr>
                    <td>${resultKey}</td>
                    <td>${results[resultKey]}</td>
                </tr>
            </c:forEach>
        </table>
        </c:if>
        <div align="center"><a href="index.jsp">Return Home</a></div>
    </body>
</html>
