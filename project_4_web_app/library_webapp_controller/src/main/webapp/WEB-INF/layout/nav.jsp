<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav>
	<ul class="nav nav-tabs">
		<li class="nav-item">
			<a class="nav-link ${ requestScope.page == 'home' ? 'active' : '' }" href="/library/home">Accueil</a>
		</li>
		<li class="nav-item">
			<a class="nav-link ${ requestScope.page == 'search' ? 'active' : '' }" href="/library/search">Search</a>
		</li>
		<li class="nav-item">
			<a class="nav-link ${ requestScope.page == 'user' ? 'active' : '' }" href="/library/user">Mon espace</a>
		</li>
	</ul>
</nav>
