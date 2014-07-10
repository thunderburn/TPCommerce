<%@ page import="java.util.List" %>
<%@ page import="entity.Vendeur" %>
<%@ page import="entity.Notevendeur" %>

<%--
  Created by IntelliJ IDEA.
  User: valentindufermont
  Date: 17/06/2014
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Les Vendeurs</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <h3>Ajouter un vendeur</h3>
    <a href="/vendeur?action=inscriptionVendeur" class="btn btn-lg btn-primary btn-block" style="width: 12%">Ajouter</a>

    <h3>Les Vendeurs</h3>
    <table class="table table-striped">
        <tr>
            <td>Nom</td>
            <td>Note</td>
            <td>Nombre de produits en vente</td>
            <td>Supprimer</td>
            <td>Modifier</td>
            <td></td>
        </tr>
        <%
            Vendeur vendeur = (Vendeur) request.getAttribute("vendeur");
            //Notevendeur note = (Notevendeur) request.getAttribute("note");
            List<Notevendeur> noteList = (List<Notevendeur>) request.getAttribute("notes");
            List<Vendeur> vendeurList = (List<Vendeur>) request.getAttribute("vendeurs");
            if(vendeurList.isEmpty()){
        %>
        <tr>
            <td><% out.print(vendeur.getVendNom());%></td>
            <td><% out.print(vendeur.getNotevendeurs());%></td>
        </tr>
            <%
    }else{
        for(int i = 0; i < vendeurList.size(); i++)
        {
    %>
        <tr>
            <td><% out.print(vendeurList.get(i).getVendNom ());%></td>
            <% if (i < noteList.size()){
            %>
            <td><% out.print(noteList.get(i));%></td>
            <%
            }else{
            %>
            <td>0</td>
            <%
                }
            %>
            <td><% out.print(vendeurList.get(i).getProduitVendeur().size()); %></td>
            <td><span class="glyphicon glyphicon-trash"></span></td>
            <td><span class="glyphicon glyphicon-th"></span></td>
            <td>
                <a href="/vendeur?id=<% out.print(vendeurList.get(i).getVendId());%>&action=infoVendeur">Voir</a>
            </td>
        </tr>
            <%
        }
    }
    %>
</div>
</table>
</body>
</html>
