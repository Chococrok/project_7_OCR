package io.ab.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.ab.library.model.Book;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByNameContainingIgnoreCase(String name);

	@Query("SELECT book FROM Book book WHERE LOWER(book.author.firstName) LIKE LOWER(CONCAT('%', ?1,'%')) OR LOWER(book.author.lastName) LIKE LOWER(CONCAT('%', ?1,'%'))")
	List<Book> findByAuthorFirstNameOrLastNameContaining(String name) throws Exception;
	
	@Query("SELECT book FROM Book book WHERE LOWER(book.publisher.name) LIKE LOWER(CONCAT('%', ?1,'%'))")
	List<Book> findByPublisherNameContaining(String name) throws Exception;
	
	@Query("SELECT book FROM Book book WHERE (SELECT tag.id FROM Tag tag WHERE tag.value LIKE LOWER(CONCAT('%', ?1,'%'))) MEMBER OF book.tags")
	List<Book> findByTagValueContaining(String value) throws Exception;

}
