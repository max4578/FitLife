<!DOCTYPE >
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<!--  Liste des séances -->
	<!-- 
	<c:forEach items="${ liste }">
			<p> <c:out value="${ Exercice }"></c:out>
		</c:forEach>
	 -->
	<!--  Boutton de création d'une nouvelle séance -->
	<input type=button onclick=window.location.href='/FitLife/CreerSeance' value="Créer une nouvelle séance" class="btn btn-default"/>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>