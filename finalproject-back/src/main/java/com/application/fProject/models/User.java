package com.application.fProject.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "users")
public class User extends Element {

	private static final long serialVersionUID = -7928136832993275046L;

	@Column(name = "surnames")
	private String surnames;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "pass")
	private String pass;
	
	@Column(name = "img")
	private String img;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_roles", nullable = false, foreignKey = @ForeignKey(name = "FK_roles_user"))
	private List<Role> roles;

}
