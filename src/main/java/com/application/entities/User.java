package com.application.entities;

import com.application.entities.*;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ForeignKey;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

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
		this.password = password;
	}
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name")
	@Pattern(regexp = "[^0-9]*")
	private String name;
	
	@Column(name = "surname")
	@Pattern(regexp = "[^0-9]*")
	private String surname;
	
	@Column (name = "username")
	@Pattern(regexp = "[^0-9]*")
	@NotNull
	private String username;

	@Column(name = "password_hash")
	@Pattern(regexp = "^\\$2[ayb]\\$.{56}$")
    @NotNull
	private String password;

  	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_type", nullable = false,
    			foreignKey = @ForeignKey(name = "fk_users_role_account_type"))
	@NotNull
  	private Role role;

  	public boolean checkPassword(String password, BCryptPasswordEncoder passwordEncoder) {
  		return passwordEncoder.matches(password, this.password);
  	}
  	
}
