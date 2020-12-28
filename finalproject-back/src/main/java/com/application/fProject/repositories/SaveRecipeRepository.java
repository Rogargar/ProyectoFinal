package com.application.fProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.fProject.models.Recipe;
import com.application.fProject.models.SavedRecipe;
import com.application.fProject.models.User;

/**
 * Save Recipe repository
 * 
 * @author Rocío García
 *
 */
@Repository
public interface SaveRecipeRepository extends JpaRepository<SavedRecipe, String> {

	@Modifying
	@Query(value = "truncate table save_recipe cascade", nativeQuery = true)
	void truncateTable();

	List<SavedRecipe> findByUser(User user);

	SavedRecipe findByUserAndRecipes(User user, Recipe recipe);

	List<SavedRecipe> findByRecipes(Recipe recipes);

	/*
	 * @Query("INSERT INTO saved_recipes('id_recipes', 'id_user') VALUES(:idRecipe,:idUser)"
	 * ) SavedRecipe guardarReceta(String idRecipe, String idUser);
	 */

}
