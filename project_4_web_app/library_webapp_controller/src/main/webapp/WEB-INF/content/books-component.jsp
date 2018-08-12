<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<c:forEach items="${ requestScope.books }" var="book">
	<li class="list-group-item">
		<div class="row">
			<p class="col">
				<strong>${ book.name }</strong> de ${ book.author.firstName } ${ book.author.lastName }
				(Editon ${ book.publisher.name })
			</p>

			<div class="col">
				<p class="${ book.available ? '' : 'text-danger' }">${ book.available ? 'disponible' : 'indisponible' }
					(${ book.availableCopy }/${ book.copy })</p>
				<c:if test="${!book.available}">
					<p>Date de retour prévu: ${ book.getFormattedBackDate() }</p>
					<p class="${ book.maxReservationReached ? 'text-danger' : '' }">Nombre
						de réservation déjà effectué: ${ book.reservations.size() }/${ book.copy * 2 }</p>
				</c:if>
			</div>

			<form class="col d-flex" method="POST" action="/library/reservation"
				id="reservationForm${ book.id }">
				<input hidden value="${ book.id }" name="bookId"
					form="reservationForm${ book.id }"></input>
				<c:choose>
					<c:when test="${ book.rentedByCurrentUser}">
						<button type="submit" class="btn btn-primary mx-auto mb-auto"
							disabled>Vous avez déjà emprunté ce livre</button>
					</c:when>

					<c:when test="${ book.bookedByCurrentUser}">
						<button type="submit" class="btn btn-primary mx-auto mb-auto"
							disabled>Vous avez déjà réservé ce livre</button>
					</c:when>

					<c:when test="${ book.maxReservationReached}">
						<button type="submit" class="btn btn-primary mx-auto mb-auto"
							disabled>Trop de réservation !</button>
					</c:when>

					<c:when test="${ book.available }">
					</c:when>

					<c:otherwise>
						<button type="submit" class="btn btn-primary mx-auto mb-auto">Reserver</button>
					</c:otherwise>
				</c:choose>
			</form>
		</div>
	</li>
</c:forEach>