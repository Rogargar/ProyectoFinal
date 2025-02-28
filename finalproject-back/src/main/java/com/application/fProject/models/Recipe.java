package com.application.fProject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * The persistent class for the Recipe database table
 * 
 * @author Rocío García
 *
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "recipes")
public class Recipe extends Element {

	private static final long serialVersionUID = 6766929063510637268L;

	@Column(name = "img")
	private String img;

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

	@Column(name = "state")
	private String state;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_recipe", nullable = false, foreignKey = @ForeignKey(name = "FK_recipes_label"))
	private List<Label> label;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_owner", nullable = false, foreignKey = @ForeignKey(name = "FK_recipes_owner"))
	private User owner;

	@Column(name = "publicationDate")
	private Date publicationDate;

}
