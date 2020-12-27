package com.application.fProject.dtos;

import java.util.UUID;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *DTO to get Label
 * 
 * @author Rocío García
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LabelDto extends LabelPersistentDto {

	private static final long serialVersionUID = -6005187588151974618L;

	@NotNull
	private String id;

	public LabelDto() {
		super();
		this.id = UUID.randomUUID().toString();
	}

	public void generateId() {
		this.id = UUID.randomUUID().toString();
	}

}
