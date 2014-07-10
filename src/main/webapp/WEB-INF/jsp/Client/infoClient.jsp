<%@ page import="entity.Client" %>
<%--
  Created by IntelliJ IDEA.
  User: nicolas
  Date: 16/06/14
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.1/css/bootstrap.min.css"/>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <h3>Vos informations</h3>
<%
    Client client = (Client) request.getAttribute("client");
    out.print("<p>Prénom : "+client.getCliPrenom()+"</p>");
    out.print("<p>Nom : "+client.getCliNom()+"</p>");
    out.print("Mail : "+client.getCliMail()+"</p>");


    %>
    <h3>Vos adresses</h3>
    <table class="table table-striped ">
        <tr>
            <td>Adresse</td>
            <td>Adresse2</td>
            <td>Code Postal</td>
            <td>Ville</td>
            <td>Type</td>
            <td>Supprimer</td>
            <td>Modifier</td>
        </tr>
    <%
    for(int i = 0; i < client.getAdresses().size(); i++)
    {
        %>
        <tr>
        <%
        out.print("<td>"+client.getAdresses().get(i).getAdrAdresse1()+"</td>");
        out.print("<td>"+client.getAdresses().get(i).getAdrAdresse2()+"</td>");
        out.print("<td>"+client.getAdresses().get(i).getAdrCp()+"</td>");
        out.print("<td>"+client.getAdresses().get(i).getAdrVille()+"</td>");
        out.print("<td>"+client.getAdresses().get(i).getType().getAdrtypeLibelle()+"</td>");
        %>
        <td><span class="glyphicon glyphicon-trash"></span></td>
        <td><span class="glyphicon glyphicon-th"></span></td>
        </tr>
        <%
    }
    %>
    </table>
    <h3>Vos moyens de paiement</h3>
    <table class="table table-striped ">
        <tr>
            <td>Numéro</td>
            <td>Date</td>
            <td>Sécurité</td>
            <td>Supprimer</td>
            <td>Modifier</td>
        </tr>
    <%
    for(int k = 0; k < client.getCbList().size(); k++)
    {
        %>
        <tr>
        <%
        out.print("<td>"+client.getCbList().get(k).getCbNumero()+"</td>");
        out.print("<td>"+client.getCbList().get(k).getCbDate()+"</td>");
        out.print("<td>"+client.getCbList().get(k).getCbSecu()+"</td>");
        %>
            <td><span class="glyphicon glyphicon-trash"></span></td>
            <td><span class="glyphicon glyphicon-th"></span></td>
        </tr>
        <%
    }
    %>
    </table>
    <h3>Vos commandes</h3>

    <table class="table table-striped ">
        <tr>
            <td>Numéro</td>
            <td>Date</td>
            <td>Carte bancaire</td>
            <td>Voir</td>
        </tr>
    <%

        if(client.getCommandes().size() == 0)
        {
            out.print("Aucune commande pour le moment");
        }
        else
        {



    for(int j = 0; j < client.getCommandes().size(); j++)
    {
        out.print("<tr><td>"+client.getCommandes().get(j).getCommandeNumero()+"</td>");
        out.print("<td>"+client.getCommandes().get(j).getCommandeDate()+"</td>");
        out.print("<td>"+client.getCommandes().get(j).getCbByCbCbId().getCbNumero()+"</td>");
        %>
        <td><a href="/commande?id=<%out.print(client.getCommandes().get(j).getCommandeId());%>">Voir</a></td>
        </tr>
        <%
    }
}

%>

    </table>
</div>
</body>
</html>
