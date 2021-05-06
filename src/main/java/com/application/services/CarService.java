package com.application.services;

import com.application.entities.Car;
import com.application.repositories.CarRepository;
import com.application.stream.*;
import com.application.cars.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CarService {
    
	@Autowired
	private CarRepository carRepository; 
	
	@Autowired
	private StreamApi streamApi;
	
	public void createOrder(Car car) {
		carRepository.save(car);
	}

    public CarService(StreamApi streamApi) {
        this.streamApi = streamApi;
    }

    public boolean containsAnySupercar() {
        return streamApi.findAllSupercar() == null ? false : streamApi.findAllSupercar().size() != 0;
    }

    public Engine getEngineWithMaxHorsePower() {
        if (streamApi.findMaxCarEnginePower() != null) {
            return streamApi.findMaxCarEnginePower().getEngine();
        }
        throw new NoSuchElementException("No such object exists!");
    }

    public int findSumOfSupercarsWeight() {
        if (streamApi.findAllSupercarWeight() >= 0) {
            return streamApi.findAllSupercarWeight();
        }
        throw new RuntimeException("Sum of weight can't be less than 0!");
    }
	
}
