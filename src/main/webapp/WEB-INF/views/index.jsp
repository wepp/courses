<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>

    <link rel="stylesheet" type="text/css" href="/resources/css/style.css"/>

    <title>Index Page</title>
</head>

<body>
<h1>TEST</h1>
${queryJsp.query}
<spring:form method="post"  modelAttribute="queryJsp" action="search">

    Query: <spring:input path="query"/> <br/>
    <spring:button class="main__btn">Search</spring:button>

</spring:form>

</body>

</html>