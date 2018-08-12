<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bibliothèque</title>
<%@ include file="/WEB-INF/style/global-style.jsp"%>
</head>
<body>

	<div class="card mx-5 my-4">
		<div class="card-header">
			<h4 class="card-title">Nos livres</h4>
			<p class="card-text">
				L'emsemble des livres référencés dans notre bibliothèque
				apparaissent dans la liste qui suit. <a href="search">Si vous
					recherchez un livre en particulier rendez vous sur la page de
					recherche.</a>
			</p>
		</div>
		<div class="card-body">
			<ul class="list-group list-group-flush">
				<%@ include file="/WEB-INF/content/books-component.jsp"%>
			</ul>
		</div>
	</div>

</body>
</html>
