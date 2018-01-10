<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
            	<li><a href="/FitLife/Accueil">Accueil</a></li> 
            	<c:if test="${!empty sessionScope.utilisateur}">
           	    <li><a href="/FitLife/Journee">Ma Journee</a></li>
                <li><a href="/FitLife/MesJournees">Mes journées</a></li>
                <li><a href="/FitLife/Seances">Mes séances</a></li>
                <li><a href="/FitLife/Profil">Profil</a></li>
                <li><a href="/FitLife/Compte">Compte</a></li>
                </c:if>
            </ul>
			<!-- si connecter cacher --> 
            <ul class="nav navbar-nav navbar-right">
            	<c:if test="${empty sessionScope.utilisateur}">
            	<li><a href="/FitLife/Connexion"><span class="glyphicon glyphicon-log-in"></span>Connexion</a></li>
               	<li><a href="/FitLife/Inscription"><span class="glyphicon glyphicon-user"></span>Inscription</a></li>
    	        </c:if>
    	        <c:if test="${!empty sessionScope.utilisateur}">
	           	<li><a href="/FitLife/Deconnexion"><span class="glyphicon glyphicon-log-out"></span>Deconnexion</a></li>
	           	</c:if>
            </ul>
            
        </div>
    </div>
</div>


