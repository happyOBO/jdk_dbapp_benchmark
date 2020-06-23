<%--
    Document   : 3
    Created on : Jul 7, 2009, 12:52:45 AM
    Author     : Kevin Kinloch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Query 3</title>
    </head>

    <body>
        <h1>Query 3</h1>
        <h2>Given a list of users, compare the usages of printers that are located in these offices</h2>
        <form method="POST" action="Query3.do">
            <table border="2">
                <tr>
                    <td>User Name</td>
                    <td>Select User(s)</td>
                </tr>
                <c:forEach var="user" items="${allUsers}">
                 <tr>
                    <td>
                        ${user.lastname}, ${user.firstname}
                    </td>
                    <td>
                        <input type="checkbox" name="selectedUsers"
                        <c:forEach var="selectedUser" items="${selectedUsers}">
                            <c:if test="${selectedUser == user.userId}">checked</c:if>
                        </c:forEach>
                        value="${user.userId}" />
                    </td>
                </tr>
                </c:forEach>
            </table>
            <br>
            <center>
                <input type="SUBMIT"><input type="RESET" value="Reset" />
            </center>
        </form>

        <% if (request.getAttribute("errMsg") != null) {%>
            Error encountered:<br><br>${errMsg}
        <%}%>

        <c:if test="${results != null}">
        <h2>Results</h2>
        <table border="5">
            <tr>
                <td>User</td>
                <td>Printer Usage</td>
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

