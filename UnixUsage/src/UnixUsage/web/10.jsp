<%--
    Document   : 10
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
        <title>Query 10</title>
    </head>
    <body>
        <h1>Query 10</h1>
        <h2>Given a course name and a session range (2 session ids that indicate whether it is before, during, or after the course), output the ratio between FILE and NETWORK commands used by the students who has taken the course</h2>
        <form method="POST" action="Query10.do">
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
                    <td>Starting Session ID: </td>
                    <td>
                        <input type="text" name="startSession" value="${startSession}"/>
                    </td>
                </tr>
                <tr>
                    <td>Ending Session ID: </td>
                    <td>
                        <input type="text" name="endSession" value="${endSession}"/>
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
