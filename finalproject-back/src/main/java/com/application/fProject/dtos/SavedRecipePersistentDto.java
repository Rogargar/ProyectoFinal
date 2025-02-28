package com.application.fProject.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *Create and update Saved recipe DTO
 * 
 * @author Rocío García
 *
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SavedRecipePersistentDto extends ElementPersistDto {

	private static final long serialVersionUID = -6272263316631833987L;

	private UserDto user;

	private RecipeDto recipes;

}
