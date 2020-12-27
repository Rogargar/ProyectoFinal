package com.application.fProject.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.fProject.models.User;

/**
 *  User repository
 *  
 * @author Rocío García
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

	@Modifying
	@Query(value = "truncate table users cascade", nativeQuery = true)
	void truncateTable();

	Optional<User> findByEmail(String email);

}
