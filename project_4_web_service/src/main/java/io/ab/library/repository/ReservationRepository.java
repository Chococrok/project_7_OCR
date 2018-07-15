package io.ab.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.ab.library.model.Book;
import io.ab.library.model.Reservation;
import io.ab.library.model.ReservationPK;

public interface ReservationRepository extends CrudRepository<Reservation, ReservationPK> {
	
	Reservation findFirstByBookOrderByAccountIdAsc(Book book) throws Exception;
	
	@Query("SELECT r FROM Reservation r WHERE r.id.bookId=?1")
	List<Reservation> findAllByBook(int bookId);
	
	@Query("SELECT r FROM Reservation r WHERE r.id.accountId=?1")
	List<Reservation> findAllByAccount(int accountId);
	
	@Query("SELECT r FROM Reservation r WHERE r.id.accountId=?1 AND bookId=?2")
	Reservation findOneByAccountAndByBook(int accountId, int bookId);
}
