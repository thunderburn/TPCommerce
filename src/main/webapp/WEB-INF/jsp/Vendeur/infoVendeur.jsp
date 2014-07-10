<%@ page import="entity.Vendeur" %>
<%--
  Created by IntelliJ IDEA.
  User: valentindufermont
  Date: 17/06/2014
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info du Vendeur</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <h3>Informations</h3>
    <%
        Vendeur vendeur = (Vendeur) request.getAttribute("vendeur");
        out.print("<p>Nom : " +vendeur.getVendNom() + "</p>");
    %>

    <h3> Les produits en ventes</h3>
    <table class="table table-striped">
        <tr>
            <td>Nom</td>
            <td>Description</td>
            <td>Auteur</td>
            <td>Editeur</td>
            <td>Genre</td>
            <td>Supprimer</td>
            <td>Modifier</td>
        </tr>
        <%
            for(int i = 0; i < vendeur.getProduitVendeur().size(); i++)
            {
        %>
        <tr>
            <%
                out.print("<td>" + vendeur.getProduitVendeur().get(i).getProduit().getProdNom()+ "</td>");
                out.print("<td>" + vendeur.getProduitVendeur().get(i).getProduit().getProdDescription() + "</td>");
                out.print("<td>" + vendeur.getProduitVendeur().get(i).getProduit().getProdAuteur() + "</td>");
                out.print("<td>" + vendeur.getProduitVendeur().get(i).getProduit().getProdEditeur() + "</td>");
                out.print("<td>" + vendeur.getProduitVendeur().get(i).getProduit().getProdGenre() + "</td>");
            %>
            <td><span class="glyphicon glyphicon-trash"></span></td>
            <td><span class="glyphicon glyphicon-th"></span></td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>
