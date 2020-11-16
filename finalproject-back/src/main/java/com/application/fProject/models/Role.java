package com.application.fProject.models;

import java.util.List;

import javax.persistence.Entity;
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
@Table(name = "role")
public class Role extends Element {

	private static final long serialVersionUID = 155323391256981135L;

	@ManyToMany(mappedBy = "roles")
	private List<User> usuers;

}
