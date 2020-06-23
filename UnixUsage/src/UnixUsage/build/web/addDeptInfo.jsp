<%-- 
    Document   : addDeptInfo
    Created on : Jul 12, 2009, 12:04:47 AM
    Author     : Mukarram
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Department Info</title>
    </head>
    <body>
        <h1>Add Department Info</h1>

        <form method="POST" action="AddDeptInfo.do">
            <table>
                <tr>
                    <td>Department ID: </td>
                    <td><input type="text" name="deptId" value="${deptInfo.deptId}" /></td>
                </tr>
                <tr>
                    <td>Department Name: </td>
                    <td><input type="text" name="deptName" value="${deptInfo.deptName}" /></td>
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
