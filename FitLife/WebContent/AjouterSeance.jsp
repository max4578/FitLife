<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Ajouter une séance</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<div class="table-responsive">
	
		<!--  Liste des séances du joueur identifié -->
		<table class="table table-bordered">
			<caption>Liste des séances</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col"> Nom des séances </th>
				</tr>
			</thead>
			<c:forEach items="${listeSeance}" var="item" varStatus="loop">
				<tr>
					<td class="form-group">
					<form method="post" action="AjouterSeance">
					<c:out value="${item.nom}" />
					<button type="submit" name="numSeance" value="${ loop.index }" class="btn btn-primary">Selectionner</button>
					</form>
					
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="form-group">
		<input type=button onclick="history.go(-1)" value="Annuler" class="btn btn-default"/>
	</div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>