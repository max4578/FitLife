<!DOCTYPE >
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Insert title here</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
	<!--  Liste des s�ances -->
	<!-- 
	<c:forEach items="${ liste }">
			<p> <c:out value="${ Exercice }"></c:out>
		</c:forEach>
	 -->
	<!--  Boutton de cr�ation d'une nouvelle s�ance -->
	<input type=button onclick=window.location.href='/FitLife/CreerSeance' value="Cr�er une nouvelle s�ance" class="btn btn-default"/>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>