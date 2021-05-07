package com.application.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.application.entities.Color;
import com.application.repositories.ColorRepository;

import java.util.Optional;

@Service
public class ColorService{

	@Autowired
	private ColorRepository colorRepository;
	
	public Optional<Color> getColorByName(String name) {
		return colorRepository.findByName(name);
	}
	
}
