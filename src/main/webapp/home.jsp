<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
%>
<%@ page import="java.util.List" %>
<%@ page import="metier.Produit" %>
<%
    String result = (String) request.getAttribute("result");
	List<Produit> produits = (List<Produit>) request.getAttribute("produits");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 20px;
        }
        h1 {
            color: #007bff;
        }
        form {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 20px;
        }
        input[type="text"] {
            width: 300px; /* Adjust the width as needed */
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button[type="submit"] {
            padding: 10px 20px; /* Adjust the padding as needed */
            border: none;
            background-color: #007bff;
            color: #fff;
            border-radius: 4px;
            cursor: pointer;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
            text-align: center;
        }
        tr:hover {
            background-color: #f5f5f5;
        }
        a {
            display: inline-block;
            margin-right: 10px;
            padding: 8px 16px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            text-align: center;
        }
        a:hover {
            background-color: #0056b3;
        }
        p {
            color: #dc3545;
        }
        .action-links {
            text-align: center;
        }²
    </style>
</head>
<body>
	<h1><%= result %></h1>
	
	<form method="get" action="searchProduits.do">
        <input type="text" name="searchProduits" placeholder="Chercher produit par nom">&nbsp;&nbsp;
        <button type="submit">Chercher</button>
    </form>
	
	<% if (produits == null || produits.isEmpty()) { %>
        <p>Aucun produit n'est disponible</p>
    <% } else { %>
	<table border="1">
	    <tr>
	        <th>Nom du Produit</th>
	        <th>Prix du Produit</th>
	        <th>Action</th>
	    </tr>
	    <% for (Produit produit : produits) { %>
	        <tr>
	            <td><%= produit.getNomProduit() %></td>
	            <td><%= produit.getPrix() %></td>
	            <td class="action-links">
	                <a href="deleteProduit.do?id=<%= produit.getIdProduit() %>">Supprimer</a>
	                <a href="updateProduit.send?id=<%= produit.getIdProduit() %>">Modifier</a>
	            </td>
	        </tr>
	    <% } %>
	</table>
	<% } %>
	<br>
	<a href='ajouterProduit.html'>Ajouter Produit</a>
</body>
</html>