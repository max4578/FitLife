<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Ajouter une s�ance</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<!--  Liste des s�ances du joueur identifi� -->
	<p>liste des s�ances</p>
	<div class="form-group">
		<input type="button" onclick=window.location.href='/FitLife/CreerSeance' value="Cr�er une nouvelle s�ance" class="btn btn-default" >
		<input type=button onclick="history.go(-1)" value="Annuler" class="btn btn-default"/>
	</div>
	
<%@ include file="Footer.jsp" %>
</body>
</html>