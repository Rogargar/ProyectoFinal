package com.application.fProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.fProject.models.Recipe;
import com.application.fProject.models.User;

/**
 *  Recipe repository
 *  
 * @author Rocío García
 *
 */
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {

	@Modifying
	@Query(value = "truncate table recipes cascade", nativeQuery = true)
	void truncateTable();

	List<Recipe> findByOwner(User owner);
	
	

}
