<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Mes s�ances</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<div class="table-responsive">
		<!--  Liste des s�ances du joueur identifi� -->
		<form method="post" action="Seances">
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
						<td><c:out value="${ item.nom }" /></td>
						<td><button type="submit" class="btn btn-default" name="idSeance" value="${ item.id }">Supprimer</button></td>
						<td><button type="submit" class="btn btn-default" name="seance" value="${loop.index}">Voir</button></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	<div class="form-group">
		<input type="button" onclick=window.location.href='/FitLife/CreerSeance' value="Cr�er une nouvelle s�ance" class="btn btn-default" >
	</div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>