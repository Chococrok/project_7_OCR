package io.ab.library.repository;

import org.springframework.data.repository.CrudRepository;

import io.ab.library.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Integer> {

}
