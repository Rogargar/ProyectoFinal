package com.application.fProject.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LabelPersistentDto extends ElementPersistDto {

	private static final long serialVersionUID = -2696718218074953785L;

	private String name;

}
