package com.application.fProject.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public class Element implements Serializable {

	private static final long serialVersionUID = -2817506085826919381L;

	@Id
	@Column(name = "id", updatable = false, nullable = false, length = 40)
	private String id;

	@Column(name = "name")
	private String name;

	public Element() {
		super();
		this.id = UUID.randomUUID().toString();
	}

}
