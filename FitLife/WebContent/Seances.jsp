<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Mes s�ances</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<!--  Liste des s�ances -->
	<h1>Liste des s�ances</h1>
	<c:forEach items="${liste}" var="item">
		<div class="form-group">
	    	<a href='/FitLife/Seance'><c:out value="${item.nom}" /></a>
	    	<button class="btn btn-default" >Effacer la s�ance</button>
    	</div>
	</c:forEach>
	<!--  Boutton de cr�ation d'une nouvelle s�ance -->
	<input type=button onclick=window.location.href='/FitLife/CreerSeance' value="Cr�er une nouvelle s�ance" class="btn btn-default"/>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>