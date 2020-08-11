package com.application.fProject.models;

import java.sql.Blob;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "recipes")
public class Recipes {

	@Column(name = "id")
	@Id
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "img")
	private Blob img;

	@Column(name = "ingredients")
	private String ingredients;

	@Column(name = "preparation")
	private String preparation;

	@Column(name = "difficulty")
	private String difficulty;

	@Column(name = "time")
	private String time;

	@Column(name = "ration")
	private String ration;

	@Column(name = "suggestions")
	private String suggestions;

	@ManyToMany
	@JoinColumn(name = "id_label", nullable = false, foreignKey = @ForeignKey(name = "FK_recipes_label"))
	private Set<Label> label;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_owner", nullable = false, foreignKey = @ForeignKey(name = "FK_recipes_owner"))
	private User owner;

}
