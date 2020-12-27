package com.application.fProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.application.fProject.models.Role;

/**
 *  Role repository
 *  
 * @author Rocío García
 *
 */
public interface RoleRepository extends JpaRepository<Role, String> {

	@Modifying
	@Query(value = "truncate table role cascade", nativeQuery = true)
	void truncateTable();
}
