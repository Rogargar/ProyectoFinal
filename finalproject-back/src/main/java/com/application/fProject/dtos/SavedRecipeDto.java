package com.application.fProject.dtos;

import java.util.UUID;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *DTO to get Saved Recipe
 * 
 * @author Rocío García
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SavedRecipeDto extends SavedRecipePersistentDto {

	private static final long serialVersionUID = 1257093394295651957L;

	@NotNull
	private String id;

	public SavedRecipeDto() {
		super();
		this.id = UUID.randomUUID().toString();
	}

	public void generateId() {
		this.id = UUID.randomUUID().toString();
	}
}
