package com.application.fProject.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RecipeUploadedPersistentDto extends ElementPersistDto {

	private static final long serialVersionUID = -4667600344680980415L;

	private UserDto owner;

	private RecipesDto recipes;

	private String state;

}
