package com.application.fProject.dtos;

import java.sql.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MenuPersistentDto extends ElementPersistDto {

	private static final long serialVersionUID = 5117293199549470219L;

	private SavedRecipeDto savedRecipes;

	private Date date;

	private String menu;

	public SavedRecipeDto getSavedRecipes() {
		return savedRecipes;
	}

}
