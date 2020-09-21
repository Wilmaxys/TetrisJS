<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Ajouter une carte</title>
	</head>
	
	<body>
		<h1>
			<c:if test="${ carte == null }">Ajouter une carte</c:if>
			<c:if test="${ carte != null }">Modifier la carte</c:if>
		</h1>
		
		
		<form method="POST">
			<div>
				<label>Nom</label>
				<input type="text" name="nom" value="${ carte.nom }" />
			</div>
			
			<div>
				<input type="submit" value="Valider" />
			</div>
		</form>
	</body>
</html>