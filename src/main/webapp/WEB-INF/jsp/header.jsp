<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.1/css/bootstrap.min.css"/>
<div class="navbar-wrapper">
    <div class="container">

        <div class="navbar navbar-inverse navbar-static-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/index">TPECommerce</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="/index">Home</a></li>
                        <li><a href="/client">Les clients</a></li>
                        <li><a href="/produit">Les produits</a></li>
                        <li><a href="/vendeur">Les vendeurs</a></li>
                        <li><a href="/connexion">Se connecter</a></li>
                        <li><a href="/inscription">S'inscrire</a></li>
                    </ul>
                    <form method="post" role="form" action="/produit?search=<%%>&action=searchProduit">
                        <div class="input-group input-group-sm col-sm-4 pull-right">
                            <span class="input-group-addon"><button type="submit"><span class="glyphicon glyphicon-search"></span></button></span>
                            <input type="text" class="form-control" placeholder="Votre recherche">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
