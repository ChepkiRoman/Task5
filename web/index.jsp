<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Task5</title>
</head>
<body>

<div align="center">
    <form action="FrontController" method="get">
        <input type="hidden" name="command" value="SAX">
        <button name="SAX" type="submit">SAX</button>
    </form>
    <form action="FrontController" method="get">
        <input type="hidden" name="command" value="STAX">
        <button name="StAX" id="stax" type="submit">StAX</button>
    </form>
    <form action="FrontController" method="get">
        <input type="hidden" name="command" value="DOM">
        <button name="DOM" id="dom" type="submit">DOM</button>
    </form>
</div>

</body>
</html>
