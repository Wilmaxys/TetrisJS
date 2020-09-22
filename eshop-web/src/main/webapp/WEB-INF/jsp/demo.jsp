<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
	</head>
	
	<body>
		<h1>COUCOU ${ utilisateur } - ${ util.getUsername() } | ${ util.username }</h1>
		
		<ul>
			<c:forEach var="prenom" items="${ prenoms }">
				<li>${ prenom }</li>
			</c:forEach>
		</ul>
		
		
		<form method="POST">
			<div>
				<label>Nom d'utilisateur</label>
				<input type="text" name="username" />
			</div>
			
			<div>
				<label>Mot de passe</label>
				<input type="password" name="password" />
			</div>
			
			<div>
				<input type="submit" value="Se connecter" />
			</div>
		</form>
	</body>
</html>