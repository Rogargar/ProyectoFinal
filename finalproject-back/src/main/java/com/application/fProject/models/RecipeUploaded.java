package com.application.fProject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
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
@Table(name = "recipes_uploaded")
public class RecipeUploaded extends Element {

	private static final long serialVersionUID = 2198080229554223357L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_owner", nullable = false, foreignKey = @ForeignKey(name = "FK_recipeUploaded_user"))
	private User owner;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_recipes", nullable = false, foreignKey = @ForeignKey(name = "FK_recipeUploaded_recpes"))
	private Recipes recipes;

	@Column(name = "state")
	private String state;

}
