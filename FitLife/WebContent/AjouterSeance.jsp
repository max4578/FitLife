<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Ajouter une séance</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<!--  Liste des séances du joueur identifié -->
	<p>liste des séances</p>
	<div class="form-group">
		<input type="button" onclick=window.location.href='/FitLife/CreerSeance' value="Créer une nouvelle séance" class="btn btn-default" >
		<input type=button onclick="history.go(-1)" value="Annuler" class="btn btn-default"/>
	</div>
	
<%@ include file="Footer.jsp" %>
</body>
</html>