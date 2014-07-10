<%@ page import="entity.Produit" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigInteger" %>
<%--
  Created by IntelliJ IDEA.
  User: edouard
  Date: 17/06/14
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des produits</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <h3>Les produits</h3>
    <table class="table table-striped">
        <tr>
            <td>Nom</td>
            <td>Prix moyen constaté</td>
            <td>Nombre de vendeurs</td>
            <td>  </td>
        </tr>
        <%
            List<Produit> produitList = (List<Produit>) request.getAttribute("produits");
            for(int i = 0; i < produitList.size(); i++)
            {
        %>
        <tr>
            <td><% out.print(produitList.get(i).getProdNom());%></td>
            <td><%
                double total = 0.0;
                double somme =0.0;
                int totalRevendeur = produitList.get(i).getVendeurs().size();
                for(int j = 0; j <totalRevendeur ; j++){
                   // double tva = 1 + produitList.get(i).getTva().getTvaCode() /100;
                    somme = somme + (produitList.get(i).getVendeurs().get(j).getVendPrix());
                    total = (somme/totalRevendeur);
                }
                out.print(((int)(total*100))/100.+" € ");
            %></td>
            <td><% out.print(produitList.get(i).getVendeurs().size());%></td>
            <td>
                <a href="/produit?id=<%out.print(produitList.get(i).getProdId());%>&action=infoProduit">Voir</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>