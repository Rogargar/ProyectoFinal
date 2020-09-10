package com.application.fProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.fProject.models.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, String> {

	@Modifying
	@Query(value = "truncate table recipes cascade", nativeQuery = true)
	void truncateTable();

}
