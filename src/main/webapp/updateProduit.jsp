<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="metier.Produit" %>
<%
	Produit produit = (Produit) request.getAttribute("produit");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<style type="text/css">
		body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
            justify-content: center;
            align-items: center;
        }
        h2 {
            color: #007bff;
            text-align: center;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
        	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	    }
	    input[type="text"],
	    input[type="number"],
	    button[type="submit"] {
	        width: 100%;
	        padding: 10px;
	        margin-bottom: 10px;
	        border: 1px solid #ccc;
	        border-radius: 3px;
	        box-sizing: border-box;
	    }
	    button[type="submit"] {
	        background-color: #007bff;
	        color: #fff;
	        border: none;
	        cursor: pointer;
	    }
	    button[type="submit"]:hover {
	        background-color: #0056b3;
	    }
	</style>
</head>
<body>
	<h2>Update le Produit</h2>
    <form method="post" action="updateProduit.do?id=<%= produit.getIdProduit() %>">
        <label for="nom">Nom du Produit:</label>
        <input type="text" id="nom" name="nom" value="<%= produit.getNomProduit() %>" required><br><br>
        
        <label for="prix">Prix du Produit:</label>
        <input type="number" id="prix" name="prix" min="0" value="<%= produit.getPrix() %>" required><br><br>
        
        <button type="submit">Update</button>
    </form>
</body>
</html>