<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- spring tag --%>
<%@ taglib prefix="form" uri="http://springframework.org/tags/form" %>
<%@ page import="spring.training.util.AttributeNames" %>
<html>
<head>
    <title>Add Items</title>
</head>
<body>
    <div align="center">
        <form:form method="POST" modelAttribute="${AttributeNames.TODO_ITEM}">
        </form>

    </div>

</body>
</html>