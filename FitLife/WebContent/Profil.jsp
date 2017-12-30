<!DOCTYPE html>
<html lang="fr">
<head>
<%@ include file="Head.jsp" %>
<title>Profil</title>
</head>
<body style="padding-top: 70px;">
<%@ include file="Menu.jsp" %>
<div class="container">
	<div class="form-group">
	<label>Nom : </label> <c:out value="${ user.nom }"></c:out>
	</div>
	<div class="form-group">
	<label>Prenom : </label> <c:out value="${ user.prenom }"></c:out>
	</div>
	<div class="form-group">
	<label>sexe : </label> <c:out value="${ user.sexe }"></c:out>
	</div>
	<div class="form-group">
	<label>Date de naissance : </label> <c:out value="${ user.dateNaissance }"></c:out>
	</div>
	<div class="form-group">
	<label>Poids : </label> <c:out value="${ user.poids }"></c:out><span> kg</span>
	</div>
	<div class="form-group">
	<label>Taille : </label> <c:out value="${ user.taille }"></c:out><span> cm</span>
	</div>
</div>
<div class="container">
	<!-- afficher évolution du poids bouton qui permet par mois , 3 mois , 6 mois -->
	<input type=button onclick=window.location.href='/FitLife/ModifierProfil' value="Enregistrez une nouvelle pesée" class="btn btn-default" />	
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>