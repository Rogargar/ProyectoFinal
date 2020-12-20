package com.application.fProject.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class EmailBody extends ElementPersistDto {

	private static final long serialVersionUID = -4085865654230902688L;

	String email;

	String content;

	String subject;
}
