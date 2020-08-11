package com.application.fProject.dtos;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SavedRecipesPersistentDto implements Serializable {

	private static final long serialVersionUID = -6272263316631833987L;

	private UserDto user;

	private RecipesDto recipes;

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public RecipesDto getRecipes() {
		return recipes;
	}

	public void setRecipes(RecipesDto recipes) {
		this.recipes = recipes;
	}

}
