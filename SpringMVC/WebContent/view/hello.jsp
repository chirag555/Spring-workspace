<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<b>Welcome</b>
<br>
<form action="displayname">
<input type=text name="firstname" required>
<input type=text name="lastname">

<input type=submit value="Submit">

</form>

</body>
</html>