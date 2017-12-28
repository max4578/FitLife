<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link type="text/css" rel="stylesheet" href="form.css" />
</head>
<body>
<%@ include file="Menu.jsp" %>
<form method="post" action="Connexion">
     <fieldset>
         <legend>Connexion</legend>
         <p>Vous pouvez vous inscrire via ce formulaire.</p>

         <label for="email">Adresse email <span class="requis">*</span></label>
         <input type="text" id="email" name="email" value="${param.email}" size="20" maxlength="60" />
         <span class="erreur">${erreurs['email']}</span>
         <br />

         <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
         <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
         <span class="erreur">${erreurs['motdepasse']}</span>
         <br />

         <input type="submit" value="Connexion" class="sansLabel" />
         <br />
     </fieldset>
</form>
<%@ include file="Footer.jsp" %>
</body>
</html>