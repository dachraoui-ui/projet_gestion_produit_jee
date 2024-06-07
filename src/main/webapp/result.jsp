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
    <title>Search Products</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100vh;
            margin: 0;
            color: #333;
            padding: 20px;
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }
        form {
            max-width: 400px;
            width: 100%;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-bottom: 20px;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-size: 1rem;
            background-color: #fff;
            color: #333;
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
            margin-top: 10px;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ccc;
            color: #333;
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
            display: block;
            margin-top: 20px;
            color: #007bff;
            text-decoration: none;
            font-size: 1rem;
        }
        a:hover {
            text-decoration: underline;
            transform:Scale(1.1);

        }
        .message {
            max-width: 400px;
            width: 100%;
            text-align: center;
            background-color: #fff;
            padding: 10px;
            border-radius: 4px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            color: #333;
        }
    </style>
</head>
<body>
    <h1>Chercher produit</h1>

    <form method="get" action="searchProduits.do">
        <input type="text" name="searchProduits" placeholder="Chercher produit par nom">
        <button type="submit">Chercher</button>
    </form>
    
    <% if (produits == null) { %>
        <div class="message">Aucun produit n'est disponible</div>
    <% } else { %>
        <table>
            <tr>
                <th>Nom du Produit</th>
                <th>Prix du Produit</th>
            </tr>
            <% for (Produit produit : produits) { %>
                <tr>
                    <td><%= produit.getNomProduit() %></td>
                    <td><%= produit.getPrix() %></td>
                </tr>
            <% } %>
        </table>
    <% } %>
    <a href="login.html">Retourner à la page login</a>
</body>
</html>
