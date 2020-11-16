package com.application.fProject.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RolePersistentDto extends ElementPersistDto {
	
	private static final long serialVersionUID = -743172468052616427L;

}
