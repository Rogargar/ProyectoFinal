package com.application.fProject.models;

import java.sql.Date;

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

/**
 * The persistent class for the menu database table
 * 
 * @author Rocío García
 *
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "menu")
public class Menu extends Element {

	private static final long serialVersionUID = -5206583754452545080L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_savedRecipes", nullable = false, foreignKey = @ForeignKey(name = "FK_menu_savedRecipe"))
	private SavedRecipe savedRecipes;

	@Column(name = "date")
	private Date date;

	@Column(name = "menu")
	private String menu;

}
