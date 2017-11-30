package io.ab.library.repository;

import org.springframework.data.repository.CrudRepository;

import io.ab.library.model.Rental;
import io.ab.library.model.RentalPK;

public interface RentalRepository extends CrudRepository<Rental, RentalPK> {

}
