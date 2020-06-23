<%--
    Document   : addUsageHistory.jsp
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
        <title>Add Usage History</title>
    </head>
    <body>
        <h1>Add Usage History</h1>

        <form method="POST" action="AddUsageHistory.do">
            <table>
                <tr>
                    <td>User: </td>
                    <td>
                        <select name="selectedUser" size="1">
                            <c:forEach var="user" items="${allUsers}">
                                <option value="${user.userId}" <c:if test="${user.userId == usageHistoryUserId}">selected</c:if>>
                                    ${user.lastname}, ${user.firstname}
                                </option>
                            </c:forEach>
                        </select>
                    </td>

                </tr>
                <tr>
                    <td>Session ID: </td>
                    <td><input type="text" name="sessionId" value="${usageHistorySessionId}"/></td>
                </tr>
                <tr>
                    <td>Command: </td>
                    <td><input type="text" name="command" value="${usageHistoryCommand}"/></td>
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

