package com.application.fProject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.fProject.models.SavedRecipe;
import com.application.fProject.models.User;

@Repository
public interface SaveRecipeRepository extends JpaRepository<SavedRecipe, String> {

	@Modifying
	@Query(value = "truncate table save_recipe cascade", nativeQuery = true)
	void truncateTable();

	List<SavedRecipe> findByUser(User user);
	
	
}
