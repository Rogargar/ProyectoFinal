package com.application.fProject.models;

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
@Table(name = "saved_recipes")
public class SavedRecipe extends Element {

	private static final long serialVersionUID = -5578975813583858244L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false, foreignKey = @ForeignKey(name = "FK_savedRecipe_user"))
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_recipes", nullable = false, foreignKey = @ForeignKey(name = "FK_savedRecipe_recpes"))
	private Recipe recipes;

}
