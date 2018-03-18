<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div align="center">
    <table border="1" cellpadding="3" cellspacing="3">
        <tr>
            <th>Food ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Calories</th>
        </tr>

        <c:forEach var="food" items="${foodList}">
            <tr>
                <td>${food.id}</td>
                <td>${food.name}</td>
                <td>${food.price}</td>
                <td>${food.description}</td>
                <td>${food.calories}</td>
            </tr>
        </c:forEach>

    </table>



    <table border="1" cellpadding="5" cellspacing="5">
        <tr>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="/FrontController?command=STAX&page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </tr>
    </table>
    <br>


    <a href="index.jsp">Go to main</a>
</div>




</body>
</html>
