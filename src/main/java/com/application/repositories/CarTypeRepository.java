package com.application.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.entities.CarType;

@Repository
public interface CarTypeRepository extends JpaRepository<CarType, Long>{

	Optional<CarType> findByName(String name);
	
}
