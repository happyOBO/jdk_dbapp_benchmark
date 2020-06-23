<%--
    Document   : 15
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
        <title>Query 15</title>
    </head>
    <body>
        <h1>Query 15</h1>
        <h2>Given the course name, the department name that offers this course, and a threshold of score, output the top five commands that the users who took the course and obtain a score >= threshold</h2>
        <form method="POST" action="Query15.do">
            <table>
                <tr>
                    <td>Course: </td>
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
                <tr>
                    <td>Score: </td>
                    <td>
                        <input type="text" name="score" value="${score}"/>
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
            </tr>
            <c:forEach var="result" items="${results}">
                <tr>
                    <td>${result}</td>
                </tr>
            </c:forEach>
        </table>
        </c:if>
        <div align="center"><a href="index.jsp">Return Home</a></div>
    </body>
</html>
