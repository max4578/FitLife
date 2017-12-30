<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Cr�er une s�ance</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<form method="get" action="CreerSeance">
         <div class="form-group">
	         <label for="nom">Nom de la s�ance</label>
	   		 <input type="text" name="nom" id="nom" required="required" placeholder="Nom de la s�ance"/>
         </div>
		<!--  Liste choix du type d'exercice -->
		<select name="liste">
		    <c:forEach items="${ liste }" var="exercice">
		        <option value="${ exercice.nom }">
		            ${ exercice.nom }
		        </option>
		    </c:forEach>
		</select>
		<!--  Liste des exercices -->
		<div class="form-group">
		<button type="submit" class="btn btn-default">Enregistrer</button>
		<input type=button onclick=window.location.href='/FitLife/Seances' value="Annuler" class="btn btn-default"/>
		</div>
	</form>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>