<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>
<b>Details Page</b>
Hello ,<%=request.getAttribute("firstName")+" "+request.getAttribute("lastName") %>
<br>
${fName}
<br>
${lName}
<br>
${date}
<br>
${names}
<br>
<c:forEach var="temp" items="${names }">${temp}<br></c:forEach>
</body>
</html>