package com.application.fProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.fProject.models.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, String> {

	@Modifying
	@Query(value = "truncate table label cascade", nativeQuery = true)
	void truncateTable();

	Label findByName(String name);
}
