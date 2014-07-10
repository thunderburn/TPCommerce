<%--
  Created by IntelliJ IDEA.
  User: nicolas
  Date: 17/06/14
  Time: 12:53
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
        <form role="form" class="form-signin" method="post" action="/inscription?action=validerForm">
            <%
                String erreur = (String) request.getAttribute("erreur");
                if(erreur != null)
                {
                    out.print("<p class='alert alert-warning'>"+erreur+"</p>");
                }

            %>
            <div class="form-group">
                <label for="prenom">Prénom</label>
                <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom" required/>
            </div>
            <div class="form-group">
                <label for="nom">Nom : </label>
                <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" required/>
            </div>
            <div class="form-group">
                <label for="mail">Mail : </label>
                <input type="email" class="form-control" id="mail" name="mail" placeholder="Mail" required/>
            </div>
            <p style="display : none" class="alert alert-warning" id="erreurMdp" >Les deux mots de passe ne sont pas identiques...</p>
            <div class="form-group">
                <label for="mdp">Mot de passe : </label>
                <input type="password" class="form-control" id="mdp" name="mdp" placeholder="Mot de passe" required/>
            </div>
            <div class="form-group">
                <label for="mdp2">Confirmer mot de passe : </label>
                <input type="password" class="form-control" id="mdp2" placeholder="Confirmation du mot de passe : " required/>
            </div>
            <input type="submit" class="btn btn-lg btn-primary btn-block" value="S'inscrire" onclick="return validerFormInscription()"/>
        </form>
    </div>
<script>
    function validerFormInscription()
    {
        document.getElementById("erreurMdp").style.display="none";
        if(document.getElementById("mdp").value != document.getElementById("mdp2").value)
        {
            document.getElementById("erreurMdp").style.display="block";
            return false;
        }
        else
        {
            document.getElementById("erreurMdp").style.display="none";
            return true;
        }
    }
</script>
</body>
</html>
