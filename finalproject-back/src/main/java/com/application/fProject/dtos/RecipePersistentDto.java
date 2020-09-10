package com.application.fProject.dtos;

import java.sql.Blob;
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

	private Blob img;

	private String ingredients;

	private List<LabelDto> label;

	private String preparation;

	private String ration;

	private String suggestion;

	private String time;

	private UserDto owner;

}
