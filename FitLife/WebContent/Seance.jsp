<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Créer une séance</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<div class="table-responsive">
		<table class="table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th scope="col" colspan="2">Séance : <c:out value="${ seance.nom }"></c:out></th>
				</tr>	
			</thead>
			<c:forEach items="${ seance.list_exercice }" var="exercice" >
				<tr>
					<td>${ exercice.nom }</td>
					<td>${ exercice.type }</td>
				</tr>
		    </c:forEach>
		</table>
    </div>
	<div class="form-group">
		<form method="get" action="ModifierSeance">
			<button type="submit" class="btn btn-default" name="idSeance" value="${ seance.id }">Modifier</button>
		</form>
		<input type=button onclick="history.go(-1)" value="Retour" class="btn btn-default"/>
	</div>
</div>

<%@ include file="Footer.jsp" %>
</body>
</html>