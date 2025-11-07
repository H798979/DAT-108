<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="simple.css">
    <title>Insert title here</title>
</head>
<body>
    <c:forEach var="avdeling" items="${avdelinger}">
        <p>${avdeling}</p>
    </c:forEach>
</body>
</html>