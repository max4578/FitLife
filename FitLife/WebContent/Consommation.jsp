<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Ajouter une consommation</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
	<div class="container">
		<div class="table-responsive">
		<!--  Aliment à ajouter -->
		<form method="post" action="Consommation">
			<table class="table table-bordered">
				<caption>Aliment</caption>
				<thead class="thead-dark">
					<tr>
						<th scope="col"> Nom de l'aliment </th>
						<th scope="col"> Quantité </th>
						<th scope="col"> Période </th>
					</tr>
				</thead>
				<tr>
					<td><c:out value="${ consommation.aliment.nom }" ></c:out></td>
					<td><input type="number" min="0" name="quantite"><span> grammes</span></td>
					<td>
					<select id="periode" name="periode">
					  <option value="Matin" selected>Matin</option> 
					  <option value="Midi">Midi</option>
					  <option value="Soir">Soir</option>
					</select>
					</td>
					<td>
						<div class="form-group">
							<input type="submit" class="btn btn-success" value="Valider">
							<button onclick=window.location.href='/FitLife/AjoutAliment' class="btn btn-danger">Annuler</button>
						</div>	
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	</div>
<%@ include file="Footer.jsp" %>
</body>
</html>