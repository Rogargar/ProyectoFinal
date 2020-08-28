package com.application.fProject.dtos;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class MenuPersistentDto implements Serializable {

	private static final long serialVersionUID = 5117293199549470219L;

	private SavedRecipesDto savedRecipes;

	private Date date;

	private String menu;

	public SavedRecipesDto getSavedRecipes() {
		return savedRecipes;
	}

}
