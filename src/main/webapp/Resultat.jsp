<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
    Boolean result = (Boolean) request.getAttribute("result");
    
    if(result != null && result) { %>
        <p>La v�rification a r�ussi.</p>
    <% } else { %>
        <p>La v�rification a �chou�.</p>
    <% } %>

</body>
</html>