<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Modifier compte</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<form method="POST" action="ModifierCompte">
	<fieldset>
         <legend>Compte</legend>
         
         	 <div class="form-group">
	         <input type="hidden" id="email" name="email" value="${user.email}" size="80" maxlength="50" placeholder="votre email / your email" />
         </div>
		 <div class="form-group">
	         <label for="motdepasse">Mot de passe</label>
	         <input type="password" id="motdepasse" name="motdepasse" value="${user.password}" size="50" maxlength="20" placeholder="mot de passe / password"/>
	         <span class="erreur">${erreurs['motdepasse']}</span>
         </div>
         <div class="form-group">
	         <label for="nom">Nom d'utilisateur</label>
	         <input type="text" id="nom" name="nom" value="${user.nom}" size="50" maxlength="20" placeholder="nom / name"/>
	         <span class="erreur">${erreurs['nom']}</span>
         </div>
         <div class="form-group">
	         <label for="prenom">Prénom d'utilisateur</label>
	         <input type="text" id="prenom" name="prenom" value="${user.prenom}" size="50" maxlength="20"  placeholder="prénom / firstname"/>
	         <span class="erreur">${erreurs['prenom']}</span>
	     </div>
         <div class="form-group">
	         <label for="sexe">Sexe</label>
	         <input type="radio" required name="sexe" id="r1" value="F" ><label for="r1">Féminin</label>
	      	 <input type="radio" required name="sexe" id="r2" value="M"><label for="r2">Masculin</label>
         </div>
         <div class="form-group">
	         <label for="anniversaire">Date de naissance</label>
	         <input type="date" max="2002-01-01" min="1920-01-01" name="anniversaire" required="required" />
         </div>
         <div class="form-group">
	         <label for="taille">Taille (cm)</label>
	   		 <input type="number" step=".1" name="taille" id="taille" value="${user.taille}" size="20" maxlength="20" min="50" required="required" placeholder="taille / size"/>
	   		 <span class="erreur">${erreurs['taille']}</span>
         </div>
         <button type="submit" class="btn btn-default">Modifier</button>
         <input type=button onclick=window.location.href='/FitLife/Compte' value="Annuler" class="btn btn-default" />
         <br />
         <br />
         <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
     </fieldset>
	</form>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>