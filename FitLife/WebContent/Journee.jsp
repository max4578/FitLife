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
	<h2>Besoin de la journée</h2>
	<div class="form-group">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Calorie</th>
					<th scope="col">Protéine</th>
					<th scope="col">Lipide</th>
					<th scope="col">Glucide</th>
				</tr>	
			</thead>
			<tr>
				<td><c:out value="${ calorie }"></c:out></td>
				<td><c:out value="${ proteine }"></c:out></td>
				<td><c:out value="${ lipide }"></c:out></td>
				<td><c:out value="${ glucide }"></c:out></td>
			</tr>
		</table>
	</div>
	<h2>Valeur consommé aujourd'hui</h2>
	<div class="form-group">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Calorie</th>
					<th scope="col">Protéine</th>
					<th scope="col">Lipide</th>
					<th scope="col">Glucide</th>
				</tr>	
			</thead>
			<tr>
				<td><c:out value="${ calorieConsomme }"></c:out></td>
				<td><c:out value="${ proteineConsommee }"></c:out></td>
				<td><c:out value="${ lipideConsomme }"></c:out></td>
				<td><c:out value="${ glucideConsomme }"></c:out></td>
			</tr>
		</table>
	</div>
	<div>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col"> <h2>Séance sportive</h2> </th>
				</tr>
			</thead>
			<tr>
				<c:forEach items="${ ListeSeance }" var="seance" varStatus="loop">
				<td><c:out value="${ seance.nom }"></c:out></td>
				</c:forEach>		
			</tr>
		</table>
		<p><c:out value="${ ListeSeanceVide }"></c:out></p>
		<input type="button" onclick=window.location.href='/FitLife/AjouterSeance' value="Ajouter une séance" class="btn btn-default" >
	</div>
	<div>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col"> <h2>Aliment(s) consommé(s) sur la journée</h2> </th>
				</tr>
			</thead>
			<tr>
				<c:forEach items="${ ListeSeance }" var="seance" varStatus="loop">
				<td><c:out value="${ seance.nom }"></c:out></td>
				</c:forEach>		
			</tr>
		</table>
		<p><c:out value="${ ListeConsommation }"></c:out></p>
		<input type="button" onclick=window.location.href='/FitLife/AjoutAliment' value="Ajouter une consommation" class="btn btn-default">
	</div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>