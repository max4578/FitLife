<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<div class="table-responsive">
		<table class="table table-bordered">
			<caption>Page de mes journées</caption>
			<thead class="thead-dark">
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Calories consommées</th>
					<th scope="col">Protéines consommées</th>
					<th scope="col">Lipides consommés</th>
					<th scope="col">Glucides consommés</th>
				</tr>	
			</thead>
			<tr>
				<c:forEach items="${ listeJournee }" var="journee" varStatus="loop">
				<tr>
					<td><c:out value="${ journee.afficherDateJour() }"></c:out></td>
					<td><c:out value="${ journee.affichageConso(journee.calorie_consom) }"></c:out><span> kcal</span></td>
					<td><c:out value="${ journee.affichageConso(journee.proteine_consom) }"></c:out><span> gr</span></td>
					<td><c:out value="${ journee.affichageConso(journee.lipide_consom) }"></c:out><span> gr</span></td>
					<td><c:out value="${ journee.affichageConso(journee.glucide_consom) }"></c:out><span> gr</span></td>
				</tr>
				</c:forEach>
			</tr>
		</table>
	</div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>