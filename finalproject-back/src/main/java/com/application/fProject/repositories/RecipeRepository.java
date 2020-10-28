package com.application.fProject.repositories;

import java.util.List;

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

	/*@Query(value = "select r.name from Recipe r inner join Label l on r.label.id=label.id where l.id=:idlabel")
	List<Recipe> findByLabelPro(String idlabel);*/

}
