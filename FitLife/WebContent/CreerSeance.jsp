<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Créer une séance</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<form method="get" action="CreerSeance">
         <div class="form-group">
	         <label for="nom">Nom de la séance</label>
	   		 <input type="text" name="nom" id="nom" required="required" placeholder="Nom de la séance"/>
         </div>
		<!--  Liste choix du type d'exercice -->
        <div class="form-group">
			<select name="liste">
			    <c:forEach items="${ liste }" var="exercice">
			        <option value="${ exercice.nom }">
			            ${ exercice.nom }
			        </option>
			    </c:forEach>
			</select>
			<input type="submit" value="Choix type" class="btn btn-default"/>
		</div>
		<!--  Liste des exercices du type d'exercices -->
		
		<!--  Liste des exercices de la séance-->
		<br />
		<label>Exercice(s) de la séance</label>
		<c:forEach items="${ listeExercicesSeance }" var="exo">
			<div class="form-group">
				${exo.nom}
				<input type="submit" value="Supprimer" class="btn btn-default"/>
			</div>
	    </c:forEach>
		<div class="form-group">
		<button type="submit" class="btn btn-default">Enregistrer</button>
		<input type=button onclick="history.go(-1)" value="Annuler" class="btn btn-default"/>
		</div>
	</form>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>