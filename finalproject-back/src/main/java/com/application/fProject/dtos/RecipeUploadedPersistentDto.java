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
public class RecipeUploadedPersistentDto implements Serializable {

	private static final long serialVersionUID = -4667600344680980415L;

	private UserDto owner;

	private RecipesDto recipes;

	private String state;

	public UserDto getOwner() {
		return owner;
	}

	public void setOwner(UserDto owner) {
		this.owner = owner;
	}

	public RecipesDto getRecipes() {
		return recipes;
	}

	public void setRecipes(RecipesDto recipes) {
		this.recipes = recipes;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
