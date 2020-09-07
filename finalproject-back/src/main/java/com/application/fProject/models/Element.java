package com.application.fProject.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@MappedSuperclass
public class Element implements Serializable {

	private static final long serialVersionUID = -2817506085826919381L;

	@Id
	@Column(name = "id", updatable = false, nullable = false, length = 40)
	private String id;

	@NotBlank
	@Column(name = "name", nullable = false)
	private String name;

	/*
	 * @Temporal(TemporalType.TIMESTAMP)
	 * 
	 * @Column(name = "deleted_on") private Date deleteOn;
	 */

	public Element() {
		super();
		this.id = UUID.randomUUID().toString();
	}

}
