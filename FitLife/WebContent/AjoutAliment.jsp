<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ajouter un aliment</title>
</head>
<body>
<h1>Cr�er l'aliment</h1>
<form method="post" action="">
		<table>
			<tbody>
				<tr>
					<td>
						<label for="nomAliment">Nom de l'aliment:</label>
					</td>
					<td>
						<input type="text" name="nomAliment" id="nomAliment" required="required">
					</td>
				</tr>
				<tr>
					<td>
						<label for="lipide">Lipides :</label>
					</td>
					<td>
						<input type="text" name="lipide" id="lipide" required="required">
					</td>
				</tr>
				<tr>
					<td>
						<label for="acide_gras">Acides gras saturés :</label>
					</td>
					<td>
						<input type="text" name="acide_gras" id="sacide_gras" required="required">
					</td>
				</tr>
				<tr>
					<td>
						<label for="proteine">Protéines :</label>
					</td>
					<td>
						<input type="text" name="proteine" id="proteine" required="required">
					</td>
				</tr>
				<tr>
					<td>
						<label for="glucide">Glucide :</label>
					</td>
					<td>
						<input type="text" name="glucide" id="glucide" required="required">
					</td>
				</tr>
				<tr>
					<td>
						<label for="sucre">Sucre :</label>
					</td>
					<td>
						<input type="text" name="sucre" id="sucre" required="required">
					</td>
				</tr>
				<tr>
					<td>
						<label for="quantite">Quantités (mg) :</label>
					</td>
					<td>
						<input type="text" name="quantite" id="quantite" required="required">
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Enregistrer" /></td>
					<td><input type="reset" value="Annuler" /></td>
				</tr>
			</tbody>
		</table>
		
	</form>
</body>
</html>