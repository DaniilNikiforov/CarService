package com.application.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "users_roles")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_id_seq")
	@SequenceGenerator(
			name = "roles_id_seq",
			sequenceName = "roles_id_seq",
			allocationSize = 1
	)
	private Long id;
	
	@Column
	private String name;
}
