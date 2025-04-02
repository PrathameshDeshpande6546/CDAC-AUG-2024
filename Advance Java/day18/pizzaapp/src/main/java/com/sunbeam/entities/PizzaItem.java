package com.sunbeam.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = {"priceList"})
@Entity
@Table(name = "pizza_items")
public class PizzaItem {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="ID")
	private int id;
	@Column(name="Name")
	private String name;
	@Column(name="Type")
	private String type;
	@Column(name="Category")
	private String category;
	@Column(name="Description")
	private String description;
	@JsonIgnore
	@OneToMany(mappedBy = "item")
	private List<PizzaPricing> priceList;
}

