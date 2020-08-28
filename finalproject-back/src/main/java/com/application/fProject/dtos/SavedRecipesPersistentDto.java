package com.application.fProject.dtos;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class SavedRecipesPersistentDto implements Serializable {

	private static final long serialVersionUID = -6272263316631833987L;

	private UserDto user;

	private RecipesDto recipes;

}
