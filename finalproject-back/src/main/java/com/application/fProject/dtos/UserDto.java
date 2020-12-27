package com.application.fProject.dtos;

import java.util.UUID;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *DTO to get User
 * 
 * @author Rocío García
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserDto extends UserPersistentDto {

	private static final long serialVersionUID = -1103409295788306897L;

	@NotNull
	private String id;

	public UserDto() {
		super();
		this.id = UUID.randomUUID().toString();
	}

	public void generateId() {
		this.id = UUID.randomUUID().toString();
	}

}
