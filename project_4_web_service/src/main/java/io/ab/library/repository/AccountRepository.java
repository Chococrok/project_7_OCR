package io.ab.library.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import io.ab.library.model.Account;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface AccountRepository extends CrudRepository<Account, Integer> {
	
	Account findByEmailIs(String email);
	
	@Query(value = "SELECT EXISTS(SELECT 1 FROM account WHERE account.email = ?1 AND account.password = ?2)", nativeQuery = true)
	Boolean checkPassword(String email, String password);
	

}
