<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Mes aliments</title>
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
						<th scope="col"> Calorie </th>
						<th scope="col"> Lipide </th>
						<th scope="col"> Acide gras </th>
						<th scope="col"> Glucide </th>		
						<th scope="col"> Sucre </th>					
						<th scope="col"> Proteine </th>
						
					</tr>
				</thead>
				<c:forEach items="${listeAlim}" var="item" varStatus="loop">
					<tr>
						
						<td><c:out value="${item.nom}"/></td>
						<td><c:out value="${item.calorie}" /></td>
						<td><c:out value="${item.lipide}" /></td>
						<td><c:out value="${item.acideG}" /></td>
						<td><c:out value="${item.glucide}" /></td>
						<td><c:out value="${item.sucre}" /></td>
						<td><c:out value="${item.proteine}" /></td>
						
					
						<td>
						<form method="get" action="ModifierAliment">
						<input type="hidden" value="${item.id}" name="id">
						<button class="btn btn-default" name="id" value="${item.id}">Modifier</button>
						</form>
						</td>
						<td><form method="get" action="SupprimerAliment">
						<input type="hidden" value="${item.id}" name="id">
						<button class="btn btn-default" name="id" value="${item.id}">Suppression</button>
						</form>
						</td>
					
						
						<!-- <td><button type="submit" class="btn btn-default" name="seance" value="${loop.index}">Voir</button></td>  -->
					</tr>
				</c:forEach>
			
			</table>
			
		
	</div>
	<div class="form-group">
		<input type="button" onclick=window.location.href='/FitLife/AjoutAliment' value="Ajouter un nouvel aliment" class="btn btn-default" >
		<input type=button onclick="history.go(-1)" value="Annuler" class="btn btn-default"/>
	</div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>