package com.application.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.application.entities.Color;

@Entity
@Table(name = "cars")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Car {

	@Id
	@Column(name = "car_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "weight")
	@Min(value = 100)
	@NotNull
	private int weight;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "color", nullable = false,
    			foreignKey = @ForeignKey(name = "fk_cars_colors_color"))
	@NotNull
  	private Color color;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "car_type", nullable = false,
				foreignKey = @ForeignKey(name = "fk_cars_car_types_car_type"))
	@NotNull
	private CarType carType;
	
	@ManyToOne
	@JoinColumn(name = "owner_id", nullable = false,
				foreignKey = @ForeignKey(name = "fk_cars_users_owner_id"))
	private User owner;
	
}
