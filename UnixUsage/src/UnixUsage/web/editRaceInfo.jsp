<%--
    Document   : editRaceInfo.jsp
    Created on : Jul 4, 2009, 1:42:15 PM
    Author     : KTam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Race Info</title>
    </head>
    <body>
        <h1>Edit Race Info</h1>

        <form method="POST" action="EditRaceInfo.do">
            <table>
                <tr>
                    <td>RaceCode: </td>
                    <td><input type="text" name="findRaceCode"/></td>

                    <td><input type="SUBMIT" value="Find"></td>

            </table>
        </form>

        <c:if test="${raceInfo != null}">
            <form method="POST" action="EditRaceInfo.do">
                <table>
                    <tr>
                        <td>RaceCode: </td>
                        <td><input type="text" readonly name="raceCode" value="${raceInfo.raceCode}"/></td>
                    </tr>
                    <tr>
                        <td>Race: </td>
                        <td><input type="text" name="race" value="${raceInfo.race}"/></td>
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

