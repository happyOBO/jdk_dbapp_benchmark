<%-- 
    Document   : editDeptInfo
    Created on : Jul 12, 2009, 12:40:54 PM
    Author     : Naeem Q.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Department Info</title>
    </head>
    <body>
        <h1>Edit Department Info</h1>

        <form method="POST" action="EditDeptInfo.do">
            <table>
                <tr>
                    <td>Department ID: </td>
                    <td><input type="text" name="findDeptId"/></td>

                    <td><input type="SUBMIT" value="Find"></td>
                </tr>
            </table>
        </form>

        <c:if test="${deptInfo != null}">
            <form method="POST" action="EditDeptInfo.do">
                <table>
                    <tr>
                        <td>Department ID: </td>
                        <td><input type="text" readonly name="deptId" value="${deptInfo.deptId}"/></td>
                    </tr>
                    <tr>
                        <td>Department Name: </td>
                        <td><input type="text" name="deptName" value="${deptInfo.deptName}"/></td>
                    </tr>
                </table>
                <br><br>
                <center>
                    <input type="SUBMIT">
                </center>
            </form>
        </c:if>
        <c:if test="${errMsg != null}">
            Error encountered:<br><br>${errMsg}
        </c:if>
        <c:if test="${msg != null}">
            ${msg}
        </c:if>

        <div align="center"><a href="index.jsp">Return Home</a></div>
    </body>
</html>
