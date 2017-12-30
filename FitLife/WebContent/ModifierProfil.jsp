<!DOCTYPE html>
<html lang="fr">
<head>
<%@ include file="Head.jsp" %>
<title>Modifier Profil</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<form method="post" action="ModifierProfil">
         <p>Entrez votre nouveau poids.</p>
         <div class="form-group">
	         <label for="poids">Poids (kilos)</label>
	   		 <input type="number" step=".1" name="poids" id="poids" value="${param.poids}"size="20" maxlength="20" min="30" required="required" placeholder="poids / weight"/>
         </div>
         <button type="submit" class="btn btn-default">Enregistrer</button>
         <input type=button onclick=window.location.href='/FitLife/Profil' value="Annuler" class="btn btn-default"/>	
	</form>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>