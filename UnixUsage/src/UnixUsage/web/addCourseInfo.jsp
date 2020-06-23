<%--
    Document   : addCourseInfo.jsp
    Created on : Jul 11, 2009, 1:42:15 PM
    Author     : KTam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Course Info</title>
    </head>
    <body>
        <h1>Add Course Info</h1>

        <form method="POST" action="AddCourseInfo.do">
            <table>
                <tr>
                    <td>Course ID: </td>
                    <td><input type="text" readonly name="courseId" value="${courseInfo.courseId}"/></td>
                </tr>
                <tr>
                    <td>Course Name: </td>
                    <td><input type="text" name="courseName" value="${courseInfo.courseName}"/></td>
                </tr>
                <tr>
                    <td>Department: </td>
                    <td>
                        <select name="selectedDept" size="1">
                            <c:forEach var="dept" items="${allDepts}">
                                <option value="${dept.deptId}" <c:if test="${dept.deptId == courseInfo.deptId}">selected</c:if>>
                                    ${dept.deptName}
                                </option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Graduate Level: </td>
                    <td>
                        <select name="selectedGradLevel" size="1">
                            <option value="0" <c:if test="${courseInfo.gradLevel == '0'}">selected</c:if>>
                                Undergraduate
                            </option>
                            <option value="1" <c:if test="${courseInfo.gradLevel == '1'}">selected</c:if>>
                                Graduate
                            </option>
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
        <c:if test="${msg != null}">
            ${msg}
        </c:if>

        <div align="center"><a href="index.jsp">Return Home</a></div>
    </body>
</html>

