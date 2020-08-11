package com.application.fProject.dtos;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MenuPersistentDto implements Serializable {

	private static final long serialVersionUID = 5117293199549470219L;

	private SavedRecipesDto savedRecipes;

	private Date date;

	private String menu;

	public SavedRecipesDto getSavedRecipes() {
		return savedRecipes;
	}

	public void setSavedRecipes(SavedRecipesDto savedRecipes) {
		this.savedRecipes = savedRecipes;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

}
