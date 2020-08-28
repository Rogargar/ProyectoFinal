package com.application.fProject.dtos;

import java.io.Serializable;
import java.sql.Blob;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class RecipesPersistentDto implements Serializable {

	private static final long serialVersionUID = -421678120591597533L;

	private String name;

	private String difficulty;

	private Blob img;

	private String ingredients;

	private LabelDto label;

	private String preparation;

	private String ration;

	private String suggestion;

	private String time;

	private UserDto owner;

}
