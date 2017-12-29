<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="FitLife/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="FitLife/css/bootstrap-theme.css" type="text/css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<h1>Nous sommes le <c:out value="${ journee }"></c:out></h1>
	
	<div>
		<h2>Séance sportive</h2>
		<!-- 
		<c:forEach items="${ exercices }">
			<p> <c:out value="${ exercice }"></c:out>
		</c:forEach>
		 -->
		<input type="button" value="Ajouter une séance" >
	</div>
	
	<div>
		<h2>Aliment(s) consommé(s) sur la journée</h2>
		<input type="button" value="Ajouter une consommation">
		<br />
		<br />
		<input type=button onclick=window.location.href='/FitLife/AjoutAliment' value="Ajouter un nouvel aliment" />
	</div>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>