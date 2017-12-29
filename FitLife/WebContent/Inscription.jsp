<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="FitLife/css/bootstrap.min.css" type="text/css">
	<link rel="stylesheet" href="FitLife/css/bootstrap-theme.css" type="text/css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<title>Inscription</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<form method="post" action="Inscription">
	<fieldset>
         <legend>Inscription</legend>
         <p>Vous pouvez vous inscrire via ce formulaire.</p>
		 <div class="form-group">
	         <label for="email">Adresse email</label>
	         <input type="text" id="email" name="email" value="${param.email}" size="20" maxlength="60" />
	         <span class="erreur">${erreurs['email']}</span>
         </div>
		 <div class="form-group">
	         <label for="motdepasse">Mot de passe</label>
	         <input type="password" id="motdepasse" name="motdepasse" value="${param.motdepasse}" size="20" maxlength="20" />
	         <span class="erreur">${erreurs['motdepasse']}</span>
         </div>
		 <div class="form-group">
			 <label for="confirmation">Confirmation du mot de passe</label>
	         <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
	         <span class="erreur">${erreurs['confirmation']}</span>
         </div>
         <div class="form-group">
	         <label for="nom">Nom d'utilisateur</label>
	         <input type="text" id="nom" name="nom" value="${param.nom}" size="20" maxlength="20" />
	         <span class="erreur">${erreurs['nom']}</span>
         </div>
         <div class="form-group">
	         <label for="prenom">Prénom d'utilisateur</label>
	         <input type="text" id="prenom" name="prenom" value="${param.prenom}" size="20" maxlength="20" />
	         <span class="erreur">${erreurs['prenom']}</span>
	     </div>
         <div class="form-group">
	         <label for="sexe">Sexe</label>
	         <input type="radio" required name="sexe" id="r1" value="F" ><label for="r1">Féminin</label>
	      	 <input type="radio" required name="sexe" id="r2" value="M"><label for="r2">Masculin</label>
         </div>
         <div class="form-group">
	         <label for="anniversaire">Date de naissance</label>
	         <input type="date" max="2002-01-01" min="1920-01-01" name="anniversaire" value="${param.date}" required="required" />
         </div>
         <div class="form-group">
	         <label for="taille">Taille (cm)</label>
	   		 <input type="number" name="taille" id="taille" value="${param.taille}" size="20" maxlength="20" min="50" required="required" />
	   		 <span class="erreur">${erreurs['taille']}</span>
         </div>
         <div class="form-group">
	         <label for="poids">Poids (kilos)</label>
	   		 <input type="number" name="poids" id="poids" value="${param.poids}"size="20" maxlength="20" min="30" required="required" />
	   		 <span class="erreur">${erreurs['poids']}</span>
         </div>
         <button type="submit" class="btn btn-default">Submit</button>
         <input type="reset" value="Annuler" />
         <br />
         <br />
         <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
     </fieldset>
	</form>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>