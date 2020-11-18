package com.application.fProject.dtos;


import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RecipePersistentDto extends ElementPersistDto {

	private static final long serialVersionUID = -421678120591597533L;

	private String name;

	private String difficulty;

	private String img;

	private String ingredients;

	private List<LabelDto> label;

	private String preparation;

	private String ration;

	private String suggestions;

	private String time;

	private String state;

	private UserDto owner;

	private Date publicationDate;

}
