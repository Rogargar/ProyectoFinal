package com.application.fProject.dtos;

import java.util.UUID;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RoleDto extends RolePersistentDto {

	private static final long serialVersionUID = 2532358389531767717L;
	@NotNull
	private String id;

	public RoleDto() {
		super();
		this.id = UUID.randomUUID().toString();
	}

	public void generateId() {
		this.id = UUID.randomUUID().toString();
	}
}
