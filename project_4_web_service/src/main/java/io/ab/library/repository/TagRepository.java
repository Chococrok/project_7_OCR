package io.ab.library.repository;

import org.springframework.data.repository.CrudRepository;

import io.ab.library.model.Tag;

public interface TagRepository extends CrudRepository<Tag, Integer> {

}
