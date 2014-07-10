<%--
  Created by IntelliJ IDEA.
  User: valentindufermont
  Date: 17/06/2014
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscrire un vendeur</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <%
        String success = (String) request.getAttribute("success");
        if(success != null)
        {
            out.print("<p class='alert alert-warning'>"+success+"</p>");
        }

    %>
    <form role="form" class="form-signin" method="post" action="/inscriptionVendeur?action=validerForm">
        <div class="form-group">
            <td>
                <label for="nom">Nom</label>
            </td>
            <td>
                <input type="text" class="form-control" id="nom" name="nom" style="width: 20%" placeholder="Nom du vendeur" required/>
            </td>
            <br>
            <input type="submit" class="btn btn-lg btn-primary btn-block" style="width: 12%" value="Valider"/>
        </div>
    </form>
</div>
</body>
</html>
