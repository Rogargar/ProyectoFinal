package com.application.fProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.fProject.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, String> {

	@Modifying
	@Query(value = "truncate table Menu cascade", nativeQuery = true)
	void truncateTable();

}
