<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Ma journée</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<h1>Nous sommes le <c:out value="${ journee }"></c:out></h1>
	
	<div>
		<h2>Séance sportive</h2>
		<!-- 
		<c:forEach items="${ exercices }">
			<p><c:out value="${ exercice }"></c:out> <p>
		</c:forEach>
		 -->
		<input type="button" value="Ajouter une séance" class="btn btn-default" >
	</div>
	<h2>Aliment(s) consommé(s) sur la journée</h2>
	<div class="form-group" >
		<input type="button" value="Ajouter une consommation" class="btn btn-default">
		<input type=button onclick=window.location.href='/FitLife/AjoutAliment' value="Ajouter un nouvel aliment" class="btn btn-default"/>
	</div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>