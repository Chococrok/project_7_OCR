<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bibliothèque</title>
<%@ include file="/WEB-INF/style/global-style.jsp"%>
</head>
<body onload="load();">

	<div class="card mx-5 my-4">
		<div class="card-header">
			<h4 class="card-title">Recherche</h4>
			<p class="card-text">
				Sur cette page vous pouvez effectuer une recherche par nom, par
				auteur, par maison d'édition ou bien par Tag. Choisissez simplement
				la recherche a effectuer, puis entrez le mot à rechercher et enfin
				tapez entrer</a>
			</p>
		</div>
		<div class="card-body">
			<ul class="list-group list-group-flush">
				<li class="list-group-item">
					<form class="btn-toolbar flex-column" role="toolbar"
						action="/library/search/${ requestScope.lastSearchType }"
						aria-label="Toolbar with button groups" id="searchForm">
						<div class="btn-group mb-2 justify-content-between" role="group"
							aria-label="First group">
							<button type="button"
								class="btn btn-secondary col searchTypeButton" value="book">Livre</button>
							<button type="button"
								class="btn btn-secondary col searchTypeButton" value="author">Auteur</button>
							<button type="button"
								class="btn btn-secondary col searchTypeButton" value="publisher">Editeur</button>
							<button type="button"
								class="btn btn-secondary col searchTypeButton" value="tag">Tag</button>
						</div>
						<div class="input-group">
							<span class="input-group-addon" id="btnGroupAddon">${ requestScope.lastSearchTypeFR }</span>
							<input list="listSearch" type="text" class="form-control" id="inputSearch"
								placeholder="Ecrivez un mot puis tapez sur la touche entrer"
								aria-label="Input group example"
								aria-describedby="btnGroupAddon" name="search">
							<datalist id="listSearch">
							</datalist>
							<button type="submit" class="btn btn-primary ml-2">Rechercher</button>
						</div>
					</form>
				</li>
				<%@ include file="/WEB-INF/content/books-component.jsp"%>
			</ul>
		</div>
	</div>
	<%@ include file="/WEB-INF/javascript/search.js.jsp"%>
</body>
</html>
