<%@ page import="accueil.Type" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Cr�er une s�ance</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<form method="post" action="CreerSeance">
         <div class="form-group">
	         <label for="nom">Nom de la s�ance</label>
	   		 <input type="text" name="nom" id="nom" required="required" placeholder="Nom de la s�ance"/>
	   		 <input type="submit" value="Enregistrer" />
         </div>
	</form>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>