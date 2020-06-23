<%--
    Document   : editUserInfo.jsp
    Created on : Jul 4, 2009, 1:42:15 PM
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
        <title>Edit User Info</title>
    </head>
    <body>
        <h1>Edit User Info</h1>

        <form method="POST" action="EditUserInfo.do">
            <table>
                <tr>
                    <td>User ID: </td>
                    <td><input type="text" name="findUserId"/></td>

                    <td><input type="SUBMIT" value="Find"></td>
                </tr>
            </table>
        </form>

        <c:if test="${userInfo != null}">
            <form method="POST" action="EditUserInfo.do">
                <table>
                    <tr>
                        <td>User ID: </td>
                        <td><input type="text" readonly name="userId" value="${userInfo.userId}"/></td>
                    </tr>
                    <tr>
                        <td>First Name: </td>
                        <td><input type="text" name="firstname" value="${userInfo.firstname}"/></td>
                    </tr>
                    <tr>
                        <td>Last Name: </td>
                        <td><input type="text" name="lastname" value="${userInfo.lastname}"/></td>
                    </tr>
                    <tr>
                        <td>Sex: </td>
                        <td>
                            <select name="selectedSex" size="1">
                                <option value="M" <c:if test="${userInfo.sex == 'M'}">selected</c:if>>
                                    Male
                                </option>
                                <option value="F" <c:if test="${userInfo.sex == 'F'}">selected</c:if>>
                                    Female
                                </option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Department: </td>
                        <td>
                            <select name="selectedDept" size="1">
                                <c:forEach var="dept" items="${allDepts}">
                                    <option value="${dept.deptId}" <c:if test="${dept.deptId == userInfo.departmentId}">selected</c:if>>
                                        ${dept.deptName}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Office: </td>
                        <td>
                            <select name="selectedOffice" size="1">
                                <c:forEach var="office" items="${allOffices}">
                                    <option value="${office.officeId}" <c:if test="${office.officeId == userInfo.officeId}">selected</c:if>>
                                        ${office.officeName}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Graduate Level: </td>
                        <td>
                            <select name="selectedGradLevel" size="1">
                                <option value="0" <c:if test="${userInfo.graduate == '0'}">selected</c:if>>
                                    Undergraduate
                                </option>
                                <option value="1" <c:if test="${userInfo.graduate == '1'}">selected</c:if>>
                                    Graduate
                                </option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Race: </td>
                        <td>
                            <select name="selectedRace" size="1">
                                <c:forEach var="race" items="${allRaces}">
                                    <option value="${race.raceCode}" <c:if test="${race.raceCode == userInfo.raceId}">selected</c:if>>
                                        ${race.race}
                                    </option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="text" name="password" value="${userInfo.password}"/></td>
                    </tr>
                    <tr>
                        <td>Years Using Unix: </td>
                        <td><input type="text" name="yearsUsingUnix" value="${userInfo.yearsUsingUnix}"/></td>
                    </tr>
                    <tr>
                        <td>Enrollment Date (mm/dd/yyyy): </td>
                        <td><input type="text" name="enrollDate" value="<fmt:formatDate pattern="MM/dd/yyyy" value="${userInfo.enrollDate}"/>"/></td>
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

