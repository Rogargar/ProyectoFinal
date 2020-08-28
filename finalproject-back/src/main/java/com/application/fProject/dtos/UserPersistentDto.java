package com.application.fProject.dtos;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
public class UserPersistentDto implements Serializable {

	private static final long serialVersionUID = 708421553616066107L;

	private String name;

	private String surnames;

	private String email;

	private String pass;

	private String rol;

}
