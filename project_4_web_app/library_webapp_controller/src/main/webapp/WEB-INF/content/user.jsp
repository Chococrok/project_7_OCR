<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mon espace</title>
<%@ include file="/WEB-INF/style/global-style.jsp"%>
</head>
<body onload="loadNav();">

	<div class="card mx-5 my-4">
		<div class="card-header">
			<div class="d-flex justify-content-between align-items-center mb-2">
				<h4 class="card-title">Mon espace</h4>
				<button class="btn btn-primary btn-nav" value="logout">Déconnexion</button>
			</div>
			<p class="card-text">
				Bienvenue ${ sessionScope.account.firstName } ${
				sessionScope.account.lastName },
				ici vous pouvez vérifier vos emprunts et les rallonger si vous
				n'avez pas encore fini votre lecture.</a>
			</p>
		</div>
		<div class="card-body">
			<ul class="list-group list-group-flush">
				<c:forEach items="${ requestScope.rentals }" var="rental">
					<li class="list-group-item d-flex">
						<div>
							<p>
								<span>
									<strong>${ rental.book.name }</strong> de ${ rental.book.author.firstName }
									${ rental.book.author.lastName } (Editon ${ rental.book.publisher.name })
								</span>
							</p>
							<p>
								<span>Emprunté jusqu'au ${ rental.getDeadLine().getDay() }/${ rental.getDeadLine().getMonth() }/${ rental.getDeadLine().getYear() }</span>
							</p>
						</div>
						<div class="d-flex m-auto">
							<button class="btn btn-primary">Ajouter 1 mois de location</button>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>
