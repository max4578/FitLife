<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Ajouter une s�ance</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<div class="table-responsive">
		<!--  Liste des s�ances du joueur identifi� -->
		<table class="table table-bordered">
			<caption>Liste des s�ances</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col"> Nom des s�ances </th>
					<th scope="col"> Choisir la s�ance </th>
					<th scope="col"> Voir la s�ance </th>
				</tr>
			</thead>
			<c:forEach items="${listeSeance}" var="item" varStatus="loop">
				<tr>
				<form method="post" action="AjouterSeance">
					<td><c:out value="${item.nom}" /></td>
					<td><button type="submit" name="numSeance" value="${ loop.index }" class="btn btn-default">Selectionner</button></td>
				</form>
					<td><button class="btn btn-default" onclick=window.location.href="/FitLife/Seance?seance=${loop.index}">Voir</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="form-group">
		<input type="button" onclick=window.location.href='/FitLife/CreerSeance' value="Cr�er une nouvelle s�ance" class="btn btn-default" >
		<input type=button onclick="history.go(-1)" value="Annuler" class="btn btn-default"/>
	</div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>