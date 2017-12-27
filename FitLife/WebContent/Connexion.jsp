<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<p>Page de connexion</p>
<form action="" method="post">
	<table border="1">
         <tbody>
	        <tr>
	        	<td>Nom de compte</td>
	            <td><input type="text" name="login" value="" size="20" /></td>
	        </tr>
	        <tr>
	            <td>Mot de passe</td>
	            <td><input type="text" name="pass" value="" size="20" /></td>
	        </tr>
		 	<tr>
	       		<td> <input type="submit" value="valider" name="validation" /></td>
	       		<td> <input type="button" value="S'inscrire" name="inscription" /></td>
	         </tr>
          </tbody>
     </table>
</form>
<%@ include file="Footer.jsp" %>
</body>
</html>