<%@ page import="entity.Produit" %>
<%--
  Created by IntelliJ IDEA.
  User: nicolas
  Date: 17/06/14
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détails produit</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <%Produit produit = (Produit) request.getAttribute("produit");%>
    <div class="jumbotron">
        <h1><% out.print(produit.getProdNom());%></h1>
        <p><% out.print(produit.getProdDescription());%></p>
        <p><% out.print(produit.getProdAuteur());%></p>
        <p>Nombre de revendeurs : <span class="badge"><% out.print(produit.getVendeurs().size());%></span></p>
        <p>Prix moyen constaté :
            <span class="label label-info"><%
                double total = 0.0;
                double somme =0.0;
                int totalRevendeur = produit.getVendeurs().size();
                for(int j = 0; j <totalRevendeur ; j++){
                    // double tva = 1 + produitList.get(i).getTva().getTvaCode() /100;
                    somme = somme + (produit.getVendeurs().get(j).getVendPrix());
                    total = (somme/totalRevendeur);
                }
                out.print(((int)(total*100))/100.+" € ");
            %></span>
        </p>
    </div>

</div>
</body>
</html>
