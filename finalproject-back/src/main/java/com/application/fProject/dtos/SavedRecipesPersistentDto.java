package com.application.fProject.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SavedRecipesPersistentDto extends ElementPersistDto {

	private static final long serialVersionUID = -6272263316631833987L;

	private UserDto user;

	private RecipesDto recipes;

}
