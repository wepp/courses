<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Isaiev
  Date: 02.05.2017
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Results:</br>
<c:forEach items="${courses}" var="course">
    <a href="${course.link}">${course.name}</a>
    <br/>
    <a href="${course.photoUrl}">${course.link}</a>
    <br/>
</c:forEach>
<br/>
</body>
</html>
