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
		<!--  Liste des s�ances du joueur identifi� -->
	
			<table class="table table-bordered">
				<caption>Liste des s�ances</caption>
				<thead class="thead-dark">
					<tr>
						<th scope="col"> Nom des s�ances </th>
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
						<button class="btn btn-default" name="id" value="${item.id}">Modifier</button>
						</form>
						</td>
						<td>
						<form method="get" action="SupprimerAliment">
						<button class="btn btn-default" name="id" value="${item.id}">Suppression</button>
						</form>
						</td>
						<td>
						<form method="get" action="Consommation">
						<button class="btn btn-default" name="id" value="${item.id}">Ajouter � la journ�e</button>
						</form>
						</td>
						
					</tr>
				</c:forEach>
			
			</table>
			
		
	</div>
	<div class="form-group">
		<input type="button" onclick=window.location.href='/FitLife/AjoutAliment' value="Ajouter un nouvel aliment" class="btn btn-default" >
		<input type=button onclick=window.location.href='/FitLife/Journee' value="Annuler" class="btn btn-default"/>
	</div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>