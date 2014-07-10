<%@ page import="entity.Commande" %>
<%--
  Created by IntelliJ IDEA.
  User: nicolas
  Date: 16/06/14
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="header.jsp"/>
    <div class="container">

        <%
            Commande commande = (Commande)request.getAttribute("commande");
        %>
        <h3>Ma commande numéro <% out.print(commande.getCommandeNumero());%></h3>
        <h4>Liste des produits</h4>
        <table class="table table-striped">
            <tr>
                <td>image</td>
                <td>Désignation</td>
                <td>Auteur</td>
                <td>Prix</td>
                <td>Vendeur</td>
                <td>TVA</td>
                <td>Quantité</td>
                <td>Voir</td>
            </tr>
        <%
            for(int i = 0; i < commande.getLigneCommandes().size(); i++)
            {
                %>
                <tr>
                    <td>
                        <img src="Pictures/<%out.print(commande.getLigneCommandes().get(i).getLicmdVend().getProduit().getProdId());%>.jpg" alt="test" style="width: 50px;"/>
                    </td>
            <%
                out.print("<td>"+commande.getLigneCommandes().get(i).getLicmdVend().getProduit().getProdNom()+"</td>");
                out.print("<td>"+commande.getLigneCommandes().get(i).getLicmdVend().getProduit().getProdAuteur()+"</td>");
                out.print("<td>"+commande.getLigneCommandes().get(i).getLicmdPrixHt()+"</td>");
                out.print("<td>"+commande.getLigneCommandes().get(i).getLicmdVend().getVendeur().getVendNom()+"</td>");
                out.print("<td>"+commande.getLigneCommandes().get(i).getLicmdTvaTaux()+"</td>");
                out.print("<td>"+commande.getLigneCommandes().get(i).getLicmdQuantite()+"</td>");
                %>
                <td><a href="/produit?id=<%out.print(commande.getLigneCommandes().get(i).getLicmdVend().getProduit().getProdId());%>&action=voirProduit">Voir</a></td></tr>
            <%
            }
        %>
        </table>
    </div>
</body>
</html>
