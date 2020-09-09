package com.application.fProject.dtos;

import java.util.UUID;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RecipesDto extends RecipesPersistentDto {

	private static final long serialVersionUID = -7920820738072602272L;

	@NotNull
	private String id;

	public RecipesDto() {
		super();
		this.id = UUID.randomUUID().toString();
	}

	public void generateId() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
