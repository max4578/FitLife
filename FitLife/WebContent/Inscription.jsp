<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription</title>
<link type="text/css" rel="stylesheet" href="CSS/form.css" />
</head>
<body>
<%@ include file="Menu.jsp" %>
	<form method="post" action="Inscription">
	<fieldset>
         <legend>Inscription</legend>
         <p>Vous pouvez vous inscrire via ce formulaire.</p>

         <label for="email">Adresse email <span class="requis">*</span></label>
         <input type="text" id="email" name="email" value="${param.email}" size="20" maxlength="60" />
         <span class="erreur">${erreurs['email']}</span>
         <br />
		 <br />
         <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
         <input type="password" id="motdepasse" name="motdepasse" value="${param.motdepasse}" size="20" maxlength="20" />
         <span class="erreur">${erreurs['motdepasse']}</span>
         <br />
		 <br />
		 <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
         <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
         <span class="erreur">${erreurs['confirmation']}</span>
         <br />
         <br />
         <label for="nom">Nom d'utilisateur<span class="requis">*</span></label>
         <input type="text" id="nom" name="nom" value="${param.nom}" size="20" maxlength="20" />
         <span class="erreur">${erreurs['nom']}</span>
         <br />
         <br />
         <label for="prenom">Prénom d'utilisateur<span class="requis">*</span></label>
         <input type="text" id="prenom" name="prenom" value="${param.prenom}" size="20" maxlength="20" />
         <span class="erreur">${erreurs['prenom']}</span>
         <br />
         <br />
         <label for="sexe">Sexe<span class="requis">*</span></label>
         <input type="radio" required name="sexe" id="r1" value="F" ><label for="r1">Féminin</label>
      	 <input type="radio" required name="sexe" id="r2" value="M"><label for="r2">Masculin</label>
         <br />
         <br />
         <label for="anniversaire">Date de naissance<span class="requis">*</span></label>
         <input type="date" max="2002-01-01" min="1920-01-01" name="anniversaire" value="${param.date}" required="required" />
         <br />
         <br />
         <label for="taille">Taille (cm)<span class="requis">*</span></label>
   		 <input type="number" name="taille" id="taille" value="${param.taille}" size="20" maxlength="20" min="50" required="required" />
   		 <span class="erreur">${erreurs['taille']}</span>
         <br />
         <br />
         <label for="poids">Poids (kilos)<span class="requis">*</span></label>
   		 <input type="number" name="poids" id="poids" value="${param.poids}"size="20" maxlength="20" min="30" required="required" />
   		 <span class="erreur">${erreurs['poids']}</span>
         <br />
         <br />
         <input type="submit" value="Connexion" class="sansLabel" />
         <input type="reset" value="Annuler" />
         <br />
         <br />
         <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
     </fieldset>
	</form>
<%@ include file="Footer.jsp" %>
</body>
</html>