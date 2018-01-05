<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Mes séances</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<!--  Liste des séances -->
	<h1>Liste des séances</h1>
	<c:forEach items="${liste}" var="item" varStatus="loop">
		<div class="form-group">
	    	<a href='/FitLife/Seances/${ loop.index }'><c:out value="${item.nom}" /></a>
	    	<button class="btn btn-default" onclick=window.location.href='/FitLife/Seances?liste=${loop.index}'>Effacer la séance</button>
    	</div>
	</c:forEach>
	<!--  Boutton de création d'une nouvelle séance -->
	<input type=button onclick=window.location.href='/FitLife/CreerSeance' value="Créer une nouvelle séance" class="btn btn-default"/>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>