<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Mes séances</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<div class="table-responsive">
		<!--  Liste des séances du joueur identifié -->
		<form method="get" action="Seance">
			<table class="table table-bordered">
				<caption>Liste des séances</caption>
				<thead class="thead-dark">
					<tr>
						<th scope="col"> Nom des séances </th>
						<th scope="col"> Choisir la séance </th>
						<th scope="col"> Voir la séance </th>
					</tr>
				</thead>
				<c:forEach items="${listeSeance}" var="item" varStatus="loop">
					<tr>
						<td><c:out value="${item.nom}" /></td>
						<td><button class="btn btn-default" onclick=window.location.href="/FitLife/SupprimerSeance?seance=${loop.index}">Supprimer</button></td>
						<td><button type="submit" class="btn btn-default" name="seance" value="${loop.index}">Voir</button></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	<div class="form-group">
		<input type="button" onclick=window.location.href='/FitLife/CreerSeance' value="Créer une nouvelle séance" class="btn btn-default" >
		<input type=button onclick="history.go(-1)" value="Annuler" class="btn btn-default"/>
	</div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>