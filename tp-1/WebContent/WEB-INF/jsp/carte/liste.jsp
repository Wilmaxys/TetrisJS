<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Liste des cartes</title>
	</head>
	
	<body>
		<h1>Liste des cartes</h1>
		
		<ul>
			<c:forEach var="carte" items="${ cartes }">
				<li>
					${ carte.nom }
					[ <a href="editer?id=${ carte.id }">Modifier</a> ]
					[ <a href="supprimer?id=${ carte.id }">Supprimer</a> ]
				</li>
			</c:forEach>
		</ul>
	</body>
</html>