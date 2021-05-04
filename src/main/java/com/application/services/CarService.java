package com.application.services;

import com.application.cars.Engine;
import com.application.stream.StreamApi;

import java.util.NoSuchElementException;

public class CarService {
    StreamApi streamApi;

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
