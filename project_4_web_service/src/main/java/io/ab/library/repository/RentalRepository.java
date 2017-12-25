package io.ab.library.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.ab.library.model.Book;
import io.ab.library.model.Rental;
import io.ab.library.model.RentalPK;

public interface RentalRepository extends CrudRepository<Rental, RentalPK> {
	
	List<Rental> findAllByBook(Book book) throws Exception;

}
