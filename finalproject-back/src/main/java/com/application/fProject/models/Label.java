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
@Table(name = "label")
public class Label {

	@Column(name = "id")
	@Id
	private String id;

	@Column(name = "name")
	private String name;

}
