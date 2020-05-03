<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ToDoItems</title>
</head>
<body>
    <div align="center">
        <table border ="1" cellpadding = "5">
            <caption> <h1> ToDoItems </h1> </caption>
            <tr>
                <th>Title</th>
                <th>Deadline</th>

                <c:forEach var="item" items="${toDoData.items}">
                    <tr>
                        <td><c:out value="${item.title}"/>
                        <td><c:out value="${item.deadline}"/>
                    </tr>
                </c:forEach>

            </tr>
        </table>
    </div>

</body>
</html>