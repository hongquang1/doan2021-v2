package fpt.edu.mlem.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fpt.edu.mlem.entities.Account;
import fpt.edu.mlem.entities.Provider;






public interface AccountRepository extends CrudRepository<Account, Integer> {

	@Query("SELECT u FROM Account u WHERE u.email = :email AND u.provider = :auth_provider")
	public Account getUserByEmail(@Param("email") String email,
			                   @Param("auth_provider") Provider provider);


}