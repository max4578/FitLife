<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Ajouter un aliment</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<form method="post" action="AjoutAliment">
		<fieldset>
    		<legend>Ajouter un aliment</legend>
    			<div class="form-group">
    				<label for="nomAliment">Nom de l'aliment</label>
    				<input type="text" name="nomAliment" id="nomAliment" required="required">
    			</div>
    			<div class="form-group">
    				<label for="calorie">Calorie</label>
    				<input type="number" name="calorie" id="calorie" required="required">
    			</div>
    			<div class="form-group">
    				<label for="lipide">Lipides</label>
    				<input type="number" name="lipide" id="lipide" min="0" required="required">
    			</div>
    			<div class="form-group">
    				<label for="acide_gras">Acides gras saturés</label>
    				<input type="number" name="acide_gras" id="acide_gras" min="0" required="required">
    			</div>
    			<div class="form-group">
    				<label for="proteine">Protéines</label>
    				<input type="number" name="proteine" id="proteine" min="0" required="required">
    			</div>
    			<div class="form-group">
    				<label for="glucide">Glucide</label>
    				<input type="number" name="glucide" id="glucide" min="0" required="required">
    			</div>
    			<div class="form-group">
    				<label for="sucre">Sucre</label>
    				<input type="number" name="sucre" id="sucre" min="0" required="required">
    			</div>
    			<div class="form-group">
    				<label for="quantite">Quantités (g)</label>
    				<input type="number" name="quantite" id="quantite" min="0" required="required">
    			</div>
    			<input type="submit" value="Enregistrer" />
				<input type=button onclick=window.location.href='/FitLife/Journee' value=Annuler />
		</fieldset>
	</form>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>