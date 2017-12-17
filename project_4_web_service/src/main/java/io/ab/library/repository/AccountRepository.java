package io.ab.library.repository;

import org.springframework.data.repository.CrudRepository;

import io.ab.library.model.Account;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AccountRepository extends CrudRepository<Account, Long> {

}
