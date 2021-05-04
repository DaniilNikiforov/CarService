package com.application.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.Set;
import java.util.HashSet;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.codec.digest.DigestUtils;

@Entity
@Table(name = "users")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User {
	
	public User(String username, String password) {
		this.username = username;
		this.passwordSalt = RandomStringUtils.random(32);
		this.passwordHash = DigestUtils.sha256Hex(password + passwordSalt);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	@Pattern(regexp = "[^0-9][0-255]")
	private String name;
	
	@Column
	@Pattern(regexp = "[^0-9][0-255]*")
	private String surname;
	
	@Column
	@Pattern(regexp = "[0-9A-Za-z][0-255]*")
	@NotNull
	private String username;
	
	@Column
	@Pattern(regexp = "[0-9A-Za-z][0-255]*")
    @NotNull
	private String passwordSalt;

	@Column
	@Pattern(regexp = "[0-9A-Za-z][0-255]*")
    @NotNull
	private String passwordHash;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false, 
			foreignKey = @ForeignKey(name = "fk_roles_user_id"))
	private Role role;
	
	public boolean checkPassword(String password) {
        return DigestUtils.sha256Hex(password + passwordSalt).equals(passwordHash);
	}
	
}
