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
	<label>sexe : </label> <c:out value="${ sexe }"></c:out>
	</div>
	<div class="form-group">
	<label>Date de naissance : </label> <c:out value="${ dateNaissance }"></c:out>
	</div>
	<div class="form-group">
	<label>Poids : </label> <c:out value="${ user.poids }"></c:out><span> kg</span>
	</div>
	<div class="form-group">
	<label>Taille : </label> <c:out value="${ user.taille/100 }"></c:out><span> m</span>
	</div>
	<div class="form-group">
	<label>IMC : </label> <c:out value="${ imc }"></c:out>
	</div>
	<p style="color : ${ couleurMessage }"><c:out value="${ messageIMC }"></c:out></p>
	<input type=button onclick=window.location.href='/FitLife/ModifierProfil' value="Enregistrez une nouvelle pesée" class="btn btn-default" />	
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>