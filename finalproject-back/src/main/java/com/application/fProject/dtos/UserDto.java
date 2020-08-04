package com.application.fProject.dtos;

import java.util.UUID;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserDto extends UserPersistentDto {

	@NotNull
	private String id;
	
	public UserDto() {
		super();
		this.id=UUID.randomUUID().toString();
	}
	
	public void generateId() {
		this.id=UUID.randomUUID().toString();
	}
	
}
