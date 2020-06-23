<%--
    Document   : 6
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
        <title>Query 6</title>
    </head>
    <body>
        <h1>Query 6</h1>
        <h2>Find the workload for students who enrolled to certain courses</h2>
        <form method="POST" action="Query6.do">
            <table>
                <tr>
                    <td>Course: </td>
                </tr>
                <tr>
                    <td>
                        <select name="selectedCourse" size="1">
                            <c:forEach var="course" items="${allCourses}">
                                <option value="${course.courseId}" <c:if test="${course.courseId == selectedCourse}">selected</c:if>>
                                    ${course.courseName}
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
