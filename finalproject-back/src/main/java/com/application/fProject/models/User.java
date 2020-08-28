package com.application.fProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@Entity
@Table(name = "users")
public class User {

	@Column(name = "id")
	@Id
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "surnames")
	private String surnames;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "pass")
	private String pass;

	@Column(name = "rol")
	private String rol;

}
