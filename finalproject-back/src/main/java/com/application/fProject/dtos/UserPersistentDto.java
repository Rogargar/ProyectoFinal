package com.application.fProject.dtos;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class UserPersistentDto implements Serializable {

	private static final long serialVersionUID = 708421553616066107L;

	private String name;

	private String surnames;

	private String email;

	private String pass;

	private String rol;

}
