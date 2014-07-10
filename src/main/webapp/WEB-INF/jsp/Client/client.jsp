<%@ page import="java.util.List" %>
<%@ page import="entity.Client" %>
<%@ page import="service.Client.ClientServlet" %>
<%--
  Created by IntelliJ IDEA.
  User: nicolas
  Date: 16/06/14
  Time: 15:42
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
    <h3>Les clients</h3>
    <table class="table table-striped">
        <tr>
            <td>Nom</td>
            <td>Prénom</td>
            <td>Mail</td>
            <td></td>
        </tr>
<%
    Client client = (Client) request.getAttribute("client");
    List<Client> clientList = (List<Client>) request.getAttribute("clients");
    if(clientList.isEmpty()){
%>
        <tr>
            <td><% out.print(client.getCliNom());%></td>
            <td><% out.print(client.getCliPrenom());%></td>
            <td><% out.print(client.getCliMail());%></td>
            <td>
                <a href="/client?id=<%out.print(client.getCliId());%>&action=infoClient">Voir</a>
            </td>
        </tr>
        <%
    }else{
        for(int i = 0; i < clientList.size(); i++)
        {
            %>
            <tr>
                <td><% out.print(clientList.get(i).getCliNom());%></td>
                <td><% out.print(clientList.get(i).getCliPrenom());%></td>
                <td><% out.print(clientList.get(i).getCliMail());%></td>
                <td>
                    <a href="/client?id=<%out.print(clientList.get(i).getCliId());%>&action=infoClient">Voir</a>
                </td>
            </tr>
            <%
        }
    }
%>
    </table>
</div>
</body>
</html>