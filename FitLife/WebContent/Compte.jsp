<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Mon compte</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<div class="form-group">
	<label>Email : </label> <c:out value="${ user.email }"></c:out>
	</div>
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
	<label>Taille : </label> <c:out value="${ user.taille/100 }"></c:out><span> m</span>
	</div>
     <input type=button onclick=window.location.href='/FitLife/ModifierCompte' value="Modifier le compte" class="btn btn-default"/>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>