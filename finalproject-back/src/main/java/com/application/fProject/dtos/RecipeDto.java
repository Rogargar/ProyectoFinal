package com.application.fProject.dtos;

import java.util.UUID;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *DTO to get Recipe
 * 
 * @author Rocío García
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RecipeDto extends RecipePersistentDto {

	private static final long serialVersionUID = -7920820738072602272L;

	@NotNull
	private String id;

	public RecipeDto() {
		super();
		this.id = UUID.randomUUID().toString();
	}

	public void generateId() {
		this.id = UUID.randomUUID().toString();
	}


}
