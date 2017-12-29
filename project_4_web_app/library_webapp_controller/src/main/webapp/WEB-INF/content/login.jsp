<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon espace</title>
<%@ include file="/WEB-INF/style/global-style.jsp"%>
</head>
<body>

	<div class="card mx-5 my-4">
		<div class="card-header">
			<h4 class="card-title">Connexion à mon espace</h4>
			<p class="card-text">
				Sur cette page vous pouvez vous connecter à votre espace. <a
					href="/library/register">Si vous n'avez pas encore de compte
					cliquez sur ce lien !</a>
			</p>
		</div>
		<div class="card-body">
			<form action="/library/login/submit">
				<div class="form-group">
					<label for=inputEmail>Email</label>
					<input type="email" class="form-control" id="inputEmail"
						placeholder="Email" name="signInForm.email">
				</div>
				<div class="form-group">
					<label for="inputPassword">Mot de passe</label>
					<input type="password" class="form-control" id="inputPassword"
						placeholder="Mot de passe" name="signInForm.password">
				</div>
				<button type="submit" class="btn btn-primary">Envoyer</button>
			</form>
			<a href="/library/register">Si vous n'avez pas encore de compte
				cliquez sur ce lien !</a>
		</div>
	</div>



</body>
</html>
