package com.application.fProject.dtos;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserPersistentDto extends ElementPersistDto {

	private static final long serialVersionUID = 708421553616066107L;

	private String name;

	private String surnames;

	private String email;

	private String pass;
	
	private String img;
	
	private List<RoleDto> roles;

}
