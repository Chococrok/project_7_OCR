package io.ab.library.repository;

import org.springframework.data.repository.CrudRepository;

import io.ab.library.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
