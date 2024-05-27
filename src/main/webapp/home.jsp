<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="Metier.Produit" %>
<%
    String result = (String) request.getAttribute("result");
    List<Produit> produits = (List<Produit>) request.getAttribute("produits");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>
    <style type="text/css">
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
            padding: 20px;
            display: flex;
            flex-direction: column;
            align-items: center;
            margin: 0;
            color: #333;
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }
        form {
            display: flex;
            justify-content: center;
            align-items: center;
            margin-bottom: 20px;
        }
        input[type="text"] {
            width: 300px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 1rem;
            background-color: #fff;
            color: #333;
        }
        button[type="submit"] {
            padding: 10px 20px;
            border: none;
            background-color: #007bff;
            color: #fff;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-left: 10px;
            text-align: center;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            max-width: 800px;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: #fff;
            text-align: center;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        a {
            display: inline-block;
            padding: 8px 16px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            text-align: center;
            transition: background-color 0.3s;
        }
        a:hover {
            background-color: #0056b3;
        }
        p {
            color: #dc3545;
            text-align: center;
        }
        .action-links a {
            text-align: center;
            margin: 0 5px;
        }
        .container {
            width: 100%;
            max-width: 800px;
        }
        .add-product {
            text-align: center;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #28a745;
            color: #fff;
            border-radius: 4px;
            text-decoration: none;
            transition: background-color 0.3s;
        }
        .add-product:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
    <h1><%= result != null ? result : "Liste des Produits" %></h1>
    
    <form method="get" action="searchProduits.do">
        <input type="text" name="searchProduits" placeholder="Chercher produit par nom">
        <button type="submit">Chercher</button>
    </form>
    
    <div class="container">
    <% if (produits == null || produits.isEmpty()) { %>
        <p>Aucun produit n'est disponible</p>
    <% } else { %>
    <table>
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
    </div>
    
    <a href="ajouterProduit.html" class="add-product">Ajouter Produit</a>
</body>
</html>
