<%-- 
    Document   : index
    Created on : Jun 28, 2009, 10:04:29 PM
    Author     : Kevin Kinloch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Group 4 Unix User Usage Application </title>
    </head>
    <body>
        <h1><center>Group 4 Unix Usage Application</center></h1>
        <h2>Add/Edit Data</h2>
        <table>
            <tr><td>Usage History</td><td>[<a href="AddUsageHistory.do">Add</a>]</td><td></td></tr>
            <tr><td>User Information</td><td>[<a href="AddUserInfo.do">Add</a>]</td><td>[<a href="EditUserInfo.do">Edit</a>]</td></tr>
            <tr><td>Course Information</td><td>[<a href="AddCourseInfo.do">Add</a>]</td><td>[<a href="EditCourseInfo.do">Edit</a>]</td></tr>
            <tr><td>Transcript</td><td>[<a href="AddTranscript.do">Add</a>]</td><td>[<a href="EditTranscript.do">Edit</a>]</td></tr>
            <tr><td>Department Information</td><td>[<a href="AddDeptInfo.do">Add</a>]</td><td>[<a href="EditDeptInfo.do">Edit</a>]</td></tr>
            <tr><td>Office Information</td><td>[<a href="AddOfficeInfo.do">Add</a>]</td><td>[<a href="EditOfficeInfo.do">Edit</a>]</td></tr>
            <tr><td>Race Information</td><td>[<a href="AddRaceInfo.do">Add</a>]</td><td>[<a href="EditRaceInfo.do">Edit</a>]</td></tr>
            <tr><td>Unix Command</td><td>[<a href="AddUnixCommand.do">Add</a>]</td><td></td></tr>
         </table>

         <h2>Queries</h2>
            2. <a href="Query2.do">Given the list of offices, compare the usages of printers that are located in these offices</a><br>
            3. <a href="Query3.do">Given the list of user names, compare usages of the printers by these users</a><br>
            4. <a href="Query4.do">Given the range of student scores, compute how student workload changes</a><br>
            5. <a href="Query5.do">Find the workload for students who belong to a given department</a><br>
            6. <a href="Query6.do">Find the workload for students who enrolled to certain courses</a><br>
            7. <a href="Query7.do">Find the differences in workloads for students who have the GPAs from 3.4 and up versus the rest of students</a><br>
            8. <a href="Query8.do">Find the workload for students who reside in given offices</a><br>
            9. <a href="Query9.do">Find the workload differences for graduate versus undergraduate students</a><br>
            10. <a href="Query10.do">Given a course name and a session range (2 session ids that indicate whether it is before, during, or after the course), output the ratio between FILE and NETWORK commands used by the students who has taken the course</a><br>
            11. <a href="Query11.do">Given the input as a department name and a date, output the normalized ratio of commands that users who work at that department execute before and after that date</a><br>
            12. <a href="Query12.do">Given the department name and a race of the users as inputs, output the most popular commands executed by users who work at that department and belong to this race</a><br>
            13. <a href="Query13.do">Given the input value of as a department name, compute the ratio of females to males who study in that department</a><br>
            14. <a href="Query14.do">Given a department name, output the top three commands that the users in that department</a><br>
            15. <a href="Query15.do">Given the course name, the department name that offers this course, and a threshold of score, output the top five commands that the users who took the course and obtain a score >= threshold</a><br>
            16. <a href="Query16.do">Given a unix command and a graduate level, output commands that share the same complexity with the given command and users at the same graduate level who used these commands</a><br>
            17. <a href="Query17.do">Partition and output names of users based on three levels of complexity of the commands that these users used</a><br>
            18. <a href="Query18.do">Compute the ratio of advanced versus simple commands that students who belong to the department of computer science used</a><br>
            19. <a href="Query19.do">Using 18, compare ratios for different departments</a><br>
            20. <a href="Query20.do">Output the average ratio of password length for users who belong to the department of computer science versus the other departments</a><br>
            21. <a href="Query21.do">Output the average ratio of password length for users who used the command latex versus those who never used it</a><br>
    </body>
</html>
