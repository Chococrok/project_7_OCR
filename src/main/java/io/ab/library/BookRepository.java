package io.ab.library;

import org.springframework.data.repository.CrudRepository;

import io.ab.library.Account;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BookRepository extends CrudRepository<Book, Long> {

}
