<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Ma journ�e</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<h1>Nous sommes le <c:out value="${ journee }"></c:out></h1>
	<p>Besoin de la journ�e</p>
	<div class="form-group">
		<table>
			<thead>Calorie</thead><thead>Prot�ine</thead><thead>Lipide</thead><thead>Glucide</thead>
			<tr>
				<td><c:out value="${ calorie }"></c:out></td>
				<td><c:out value="${ proteine }"></c:out></td>
				<td><c:out value="${ lipide }"></c:out></td>
				<td><c:out value="${ glucide }"></c:out></td>
			</tr>
		</table>
	</div>
	<p>Besoin consomm�</p>
	<div class="form-group">
		<p>Calorie</p>
		<p>Prot�ine</p>
		<p>Lipide</p>
		<p>Glucide</p>
	</div>
	<div>
		<h2>S�ance sportive</h2>
		<c:forEach items="${ ListeSeance }" var="seance" varStatus="loop">
			<p><c:out value="${ seance.nom }"></c:out> <p>
		</c:forEach>
		<p><c:out value="${ ListeSeanceVide }"></c:out></p>
		<input type="button" onclick=window.location.href='/FitLife/AjouterSeance' value="Ajouter une s�ance" class="btn btn-default" >
	</div>
	<h2>Aliment(s) consomm�(s) sur la journ�e</h2>
	<p><c:out value="${ ListeConsommation }"></c:out></p>
	<div class="form-group" >
		<input type="button" onclick=window.location.href='/FitLife/AjoutAliment' value="Ajouter une consommation" class="btn btn-default">
		<!-- <input type=button onclick=window.location.href='/FitLife/AjoutAliment' value="Ajouter un nouvel aliment" class="btn btn-default"/> -->
	</div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>