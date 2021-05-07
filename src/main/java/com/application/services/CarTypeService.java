package com.application.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.application.repositories.CarTypeRepository;
import com.application.entities.CarType;

import java.util.Optional;

@Service
public class CarTypeService {

	@Autowired
	private CarTypeRepository carTypeRepository;
	
	public Optional<CarType> getCarTypeByName(String name) {
		return carTypeRepository.findByName(name);
	}
	
}
