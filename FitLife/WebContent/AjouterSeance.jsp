<!DOCTYPE html>
<html>
<head>
<%@ include file="Head.jsp" %>
<title>Ajouter une séance</title>
</head>
<body>
<%@ include file="Menu.jsp" %>
<div class="container">
    <div class="table-responsive">
        <form method="post" action="AjouterSeance">
        <!--  Liste des séances du joueur identifié -->
        <table class="table table-bordered">
            <caption>Liste des séances</caption>
            <thead class="thead-dark">
                <tr>
                    <th scope="col"> Nom des séances </th>
                    <th scope="col"> Période </th>
                </tr>
            </thead>
            <c:forEach items="${listeSeance}" var="item" varStatus="loop">
                <tr>
                    <td>
                        <c:out value="${item.nom}" />
                    </td>
                    <td>
                    <select id="periode" name="periode">
                      <option value="Matin" selected>Matin</option> 
                      <option value="Midi">Midi</option>
                      <option value="Soir">Soir</option>
                    </select>
                    </td>
                    <td>
                        <button type="submit" name="numSeance" value="${ loop.index }" class="btn btn-primary">Selectionner</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
            <div>
                <input type=button onclick="history.go(-1)" value="Annuler" class="btn btn-default"/>
            </div>
        </form>
    </div>
    <br>
    <p><c:out value="${ erreurAjout }" ></c:out></p>
</div>

	
<%@ include file="Footer.jsp" %>
</body>
</html>