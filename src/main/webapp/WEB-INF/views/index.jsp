<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <title>Index Page</title>
</head>

<body>
${queryJsp.query}
<spring:form method="post"  modelAttribute="queryJsp" action="search">

    Query: <spring:input path="query"/> <br/>
    <spring:button>Search</spring:button>

</spring:form>

</body>

</html>