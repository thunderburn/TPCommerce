<%@ page import="entity.Vendeur" %>

<%--
  Created by IntelliJ IDEA.
  User: valentindufermont
  Date: 18/06/2014
  Time: 12:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<jsp:include page="../header.jsp"/>
    <div class="container">
        <%
            Vendeur vendeur = (Vendeur) request.getAttribute("vendeur");
            out.print("<p>Nom : " +vendeur.getVendNom() + "</p>");
        %>
        <form role="form" class="form-signin" method="post" action="/suppressionVendeur?id=<% out.print(vendeur.getVendId());%>&action=suppressionVendeur">
            <h3>information de suppression</h3>
            <p>Vous êtes sur le point de supprimer le vendeur <% out.print(vendeur.getVendNom());%>
            Etes vous sur de vouloir continuer?</p>

        </form>
    </div>
</body>
</html>
