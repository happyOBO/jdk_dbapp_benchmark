<%-- 
    Document   : editOfficeInfo
    Created on : Jul 12, 2009, 12:55:20 PM
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
        <title>Edit Office Info</title>
    </head>
    <body>
        <h1>Edit Office Info</h1>

        <form method="POST" action="EditOfficeInfo.do">
            <table>
                <tr>
                    <td>Office ID: </td>
                    <td><input type="text" name="findOfficeId"/></td>

                    <td><input type="SUBMIT" value="Find"></td>
                </tr>
            </table>
        </form>

        <c:if test="${officeInfo != null}">
            <form method="POST" action="EditOfficeInfo.do">
                <table>
                    <tr>
                        <td>Office ID: </td>
                        <td><input type="text" readonly name="officeId" value="${officeInfo.officeId}"/></td>
                    </tr>
                    <tr>
                        <td>Office Name: </td>
                        <td><input type="text" name="officeName" value="${officeInfo.officeName}"/></td>
                    </tr>
                    <tr>
                    <td>Has Printer: </td>
                    <td>
                        <select name="hasPrinter" size="1">
                            <option value="0" <c:if test="${officeInfo.hasPrinter == '0'}">selected</c:if> />
                                No
                            </option>
                            <option value="1" <c:if test="${officeInfo.hasPrinter == '1'}">selected</c:if> />
                                Yes
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
