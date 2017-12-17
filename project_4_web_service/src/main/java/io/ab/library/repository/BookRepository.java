package io.ab.library.repository;

import org.springframework.data.repository.CrudRepository;

import io.ab.library.model.Account;
import io.ab.library.model.Book;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BookRepository extends CrudRepository<Book, Long> {

}
