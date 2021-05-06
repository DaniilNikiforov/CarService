package com.application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.application.entities.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, Long> {

	Optional<Color> findByName(String name);
	
}
