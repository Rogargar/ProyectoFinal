package com.application.fProject.repositories;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SoftDelete<T, I extends Serializable> extends JpaRepository<T, I> {

	@Query("FROM #{#entityName} e WHERE e.deletedOn IS NULL")
	List<T> findAll();

	@Query("FROM #{#entityName} e WHERE e.id=:id AND e.deletedOn IS NULL")
	Optional<T> findById(I id);

	@Query("FROM #{#entityName} e WHERE e.deletedOn IS NOT NULL")
	public List<T> recycleBin();

	@Modifying
	@Query("UPDATE #{#entityName} e SET e.deletedOn=sysdate() WHERE e.id=:id")
	void softDelete(I id);

}
