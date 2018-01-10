<%@ page import="accueil.Type" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Séance <c:out value="${ seance.nom }"></c:out></title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">

	<p>Quel type d'exercice voulez-vous ajouter ?</p>
	
	<form method="get" action="ModifierSeance">
	<select name="liste">
		<c:set var="enumValues" value="<%=Type.values()%>"/>
	    <c:forEach items="${ enumValues }" var="typeExercice">
	        <option value="${ typeExercice }">
	            ${ typeExercice }
	        </option>
	    </c:forEach>
	</select>
	<input type="submit" value="Choix type" class="btn btn-default"/>
	
	</form>
	
	<!-- Liste des exercices du type -->
	<div class="table-responsive">
		<table class="table table-bordered">
		
			<thead class="thead-dark">
				<tr>
					<th scope="col">Exercices disponibles</th>
				</tr>	
			</thead>
			
			<c:forEach items="${ listeExercices }" var="exercice" varStatus="loop">
					<tr>
						<td class="form-group">
						<form method="post" action="ModifierSeance">
						<c:out value="${exercice.nom}" ></c:out>
						<input type="number" min="0" placeholder="nombre de répétition" name="nbrRep">
						<button type="submit" name="exercice" value="${ loop.index }" class="btn btn-default">Ajouter</button>
						</form>
						</td>
					</tr>
		    </c:forEach>
		</table>
    </div>
    
    <!-- Liste des exercices de la séance -->
	<div class="table-responsive">
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th scope="col" colspan="2">Séance : <c:out value="${ seance.nom }"></c:out></th>
				</tr>	
			</thead>
			<c:forEach items="${ seance.list_exercice }" var="exercice" >
				<tr>
					<td>${exercice.nom}</td>
					<td>${exercice.type}</td>
				</tr>
		    </c:forEach>
		</table>
    </div>
	<div class="form-group">
		<input type=button onclick=window.location.href='/FitLife/Seances' value="Retour" class="btn btn-default"/>
	</div>
</div>

<%@ include file="Footer.jsp" %>
</body>
</html>