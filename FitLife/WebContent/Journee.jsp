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
	<div class="form-group">
		<table class="table">
			<caption>Besoin de la journée</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">Calorie</th>
					<th scope="col">Protéine</th>
					<th scope="col">Lipide</th>
					<th scope="col">Glucide</th>
				</tr>	
			</thead>
			<tr>
				<td><c:out value="${ calorie }"></c:out><span> Kcal</span></td>
				<td><c:out value="${ proteine }"></c:out><span> gr</span></td>
				<td><c:out value="${ lipide }"></c:out><span> gr</span></td>
				<td><c:out value="${ glucide }"></c:out><span> gr</span></td>
			</tr>
		</table>
	</div>
	<div class="table-responsive">
		<table class="table">
			<caption>Valeur consommé aujourd'hui</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">Calorie</th>
					<th scope="col">Protéine</th>
					<th scope="col">Lipide</th>
					<th scope="col">Glucide</th>
				</tr>	
			</thead>
			<tr>
				<td><c:out value="${ calorieConsomme }"></c:out><span> Kcal</span></td>
				<td><c:out value="${ proteineConsommee }"></c:out><span> gr</span></td>
				<td><c:out value="${ lipideConsomme }"></c:out><span> gr</span></td>
				<td><c:out value="${ glucideConsomme }"></c:out><span> gr</span></td>
			</tr>
		</table>
	</div>
	<div class="table-responsive">
	<form method="post" action="Journee">
		<table class="table table-bordered">
			<caption>Séance sportive</caption>
			<c:forEach items="${ ListeSeance }" var="seance" varStatus="loop">
			<thead class="thead-dark">
				<tr>
					<th scope="col" class="table-primary"><c:out value="${ seance.nom }"></c:out></th>
					<th scope="col" class="table-primary">
						<button type="submit" name="numSeance" value="${ loop.index }" class="btn btn-danger" >Supprimer la séance</button>
					</th>
					
				</tr>
			</thead>
				<c:forEach items="${ seance.list_exercice }" var="exercice" varStatus="loop">
					<tr>
						<td><c:out value="${ exercice.nom }"></c:out></td>
					</tr>
				</c:forEach>
			</c:forEach>		
		</table>
	</form>
		<p><c:out value="${ ListeSeanceVide }"></c:out></p>
		<input type="button" onclick=window.location.href='/FitLife/AjouterSeance' value="Ajouter une séance" class="btn btn-default" >
	</div>
	<div class="table-responsive">
    <form method="post" action="Journee">
        <table class="table table-bordered">
            <caption>Aliment(s) consommé(s) sur la journée</caption>
            <thead class="thead-dark">
                <tr class="table-primary">
                    <th scope="col"> Nom de l'aliment </th>
                    <th scope="col"> Quantité </th>
                    <th scope="col"> Période de la journée </th>
                </tr>
            </thead>
            <c:forEach items="${ ListeConsommation }" var="consommation" varStatus="loop">
                <tr>
                    <td><c:out value="${ consommation.aliment.nom }"></c:out></td>
                    <td><c:out value="${ consommation.quantite }"></c:out><span> gr</span></td>
                    <td><c:out value="${ consommation.periode }"></c:out></td>
                    <td>
                        <button type="submit" name="numAliment" value="${ loop.index }" class="btn btn-danger" >Supprimer la consommation</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
        <p><c:out value="${ ListeConsommationVide }"></c:out></p>
        <input type="button" onclick=window.location.href='/FitLife/MesAliments' value="Ajouter une consommation" class="btn btn-default">
    </div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>