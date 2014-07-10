<%--
  Created by IntelliJ IDEA.
  User: edouard
  Date: 16/06/14
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>connexion</title>


</head>
<body>
<jsp:include page="../header.jsp"/>
    <div class="container">
        <%
            String success = (String) request.getAttribute("success");
            if(success != null)
            {
                out.print("<p class='alert alert-success'>"+success+"</p>");
            }
        %>

    <form class="form-horizontal" method="post" action="/connexion" role="form">
        <div class="form-group">
            <label name="email" for="email"class="col-sm-2 control-label">Email</label>
            <div class="col-sm-10">
                <input type="email" name="email" id="email" class="form-control" required/>
            </div>
        </div>
        <div class="form-group">
            <label name="pwd" for="pwd"class="col-sm-2 control-label">Mot de passe</label>
            <div class="col-sm-10">
                <input type="password" name="pwd" id="pwd" class="form-control" required/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" value="Valider" class="btn btn-default">Valider</button>
            </div>
        </div>
    </form>
    </div>
</body>
</html>
