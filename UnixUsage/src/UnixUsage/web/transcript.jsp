    Document   : index
    Created on : Jun 27, 2009, 12:30:32 AM
    Author     : Kevin Kinloch
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transcript</title>
    </head>
    <h1><center>Transcript</center></h1>
    <body><form name="TransActionNe" action="TransAction" method="POST">
        Select
        <input type="radio" name="Function" value="" checked="checked" />
        Add
         <input type="radio" name="Function" value="" checked="checked" />
        Insert
         <input type="radio" name="Function" value="" checked="checked" />
        Delete
         <input type="radio" name="Function" value="" checked="checked" />
        <br></br>
        <br></br>
        <br></br>
        User Id.  :<input type="text" name="User_ID" value="" />
        <br></br>
        Course Id.:<input type="text" name="Course_id" value="" />
        <br></br>
        Score     :<input type="text" name="Score" value="" />
        <br></br>
        <input type="submit" value="Submit" name="Submit" />
        <input type="reset" value="Reset" name="reset" />
        </form>
    </body>
</html>
