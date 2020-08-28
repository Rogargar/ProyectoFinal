package com.application.fProject.dtos;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class RecipeUploadedPersistentDto implements Serializable {

	private static final long serialVersionUID = -4667600344680980415L;

	private UserDto owner;

	private RecipesDto recipes;

	private String state;

}
