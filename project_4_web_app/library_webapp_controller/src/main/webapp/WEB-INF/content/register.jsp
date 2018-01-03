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
			<h4 class="card-title">Création de mon compte</h4>
			<p class="card-text">Renseignez les informations demandées puis
				cliquez sur Envoyer pour créer votre compte.</p>
		</div>
		<div class="card-body">
			<form action="/library/register/submit">
				 <s:actionerror/>
				<div class="form-group">
					<label for=inputEmail>Email</label>
					<input type="email" class="form-control" id="inputEmail"
						placeholder="Email" name="signUpForm.email">
				</div>
				<div class="form-group">
					<label for=inputFirstName>Prénom</label>
					<input type="text" class="form-control" id="inputFirstName"
						placeholder="Prénom" name="signUpForm.firstName">
				</div>
				<div class="form-group">
					<label for=inputLastName>Nom</label>
					<input type="text" class="form-control" id="inputLastName"
						placeholder="Nom" name="signUpForm.lastName">
				</div>
				<div class="form-group">
					<label for="inputPassword">Mot de passe</label>
					<input type="password" class="form-control" id="inputPassword"
						placeholder="Mot de passe" name="signUpForm.password">
				</div>
				<div class="form-group">
					<label for="inputCheckPassword">Confirmation</label>
					<input type="password" class="form-control" id="inputCheckPassword"
						placeholder="Vérifiez le mot de passe"
						name="signUpForm.checkPassword">
				</div>
				<div class="form-group">
					<label for=inputPhone>Numéro de téléphone</label>
					<input type="text" class="form-control" id="inputPhone"
						placeholder="Numéro de téléphone" name="signUpForm.phoneNumber">
				</div>
				<button type="submit" class="btn btn-primary">Envoyer</button>
			</form>
		</div>
	</div>
</body>
</html>
