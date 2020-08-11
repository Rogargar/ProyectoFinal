package com.application.fProject.dtos;

import java.io.Serializable;
import java.sql.Blob;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RecipesPersistentDto implements Serializable{
	
	private static final long serialVersionUID = -421678120591597533L;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String difficulty;

	@Getter
	@Setter
	private Blob img;

	@Getter
	@Setter
	private String ingredients;

	@Getter
	@Setter
	private LabelDto label;

	@Getter
	@Setter
	private String preparation;

	@Getter
	@Setter
	private String ration;

	@Getter
	@Setter
	private String suggestion;

	@Getter
	@Setter
	private String time;

	@Getter
	@Setter
	private UserDto owner;

}
