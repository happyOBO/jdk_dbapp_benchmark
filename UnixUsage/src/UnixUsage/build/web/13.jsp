<%-- 
    Document   : 13
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
        <title>Query 13</title>
    </head>
    <body>
        <h1>Query 13</h1>
        <h2>Given the input value of as a department name, compute the ratio of females to males who study in that department</h2>
        <form method="POST" action="Query13.do">
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

