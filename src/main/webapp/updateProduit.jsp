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
    <title>Update Product</title>
    <style type="text/css">
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #2c2c2c;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            color: #fff;
        }
        h2 {
            color: #fff;
            text-align: center;
            margin-bottom: 20px;
            position: absolute;
            top: 20px;
            width: 100%;
        }
        form {
            max-width: 400px;
            width: 100%;
            background-color: #333;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #bbb;
        }
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #444;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 1rem;
            background-color: #555;
            color: #fff;
        }
        button[type="submit"] {
            width: 100%; 
            padding: 10px;
            border: none;
            border-radius: 4px;
            background-color: #007bff;
            color: #fff;
            font-size: 1rem;
            cursor: pointer;
            transition: background-color 0.3s;
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
        <input type="text" id="nom" name="nom" value="<%= produit.getNomProduit() %>" required>
        
        <label for="prix">Prix du Produit:</label>
        <input type="number" id="prix" name="prix" min="0" value="<%= produit.getPrix() %>" required>
        
        <button type="submit">Update</button>
    </form>
</body>
</html>
