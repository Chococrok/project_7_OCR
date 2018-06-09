package io.ab.library.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.ab.library.model.Account;
import io.ab.library.model.Book;
import io.ab.library.model.Reservation;
import io.ab.library.model.ReservationPK;

public interface ReservationRepository extends CrudRepository<Reservation, ReservationPK> {
	
	List<Reservation> findAllByBook(Book book);
	List<Reservation> findAllByAccount(Account account);
	Reservation findFirstByBookOrderByAccountIdAsc(Book book) throws Exception;

}
