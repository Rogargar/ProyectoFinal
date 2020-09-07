package com.application.fProject.dtos;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ElementPersistDto implements Serializable {

	private static final long serialVersionUID = 3562012376378232580L;

	private String name;
}
