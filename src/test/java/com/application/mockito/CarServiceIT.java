package com.application.mockito;

import com.application.cars.*;
import com.application.enam.WheelTypes;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.application.services.CarService;
import com.application.stream.StreamApi;

import java.util.List;
import java.util.NoSuchElementException;

import static org.mockito.BDDMockito.given;

public class CarServiceIT {

    @Mock
    private static StreamApi streamApi;

    private CarService carService;
    private static Supercar supercar;
    private static Engine supercarEngine;
    private static Jeep jeep;

    public CarServiceIT() {
        MockitoAnnotations.initMocks(this);
        carService = new CarService(streamApi);
    }

    @BeforeClass
    public static void initialization() {
        supercarEngine = new Engine(700, 340, 7);
        Engine jeepEngine = new Engine(250, 160, 5);
        supercar = new Supercar.Builder()
                .setWeight(1300)
                .setColor("Red")
                .setWheelType(WheelTypes.SPORTS)
                .setEngine(supercarEngine)
                .setNumberOfPassengers(2)
                .setCabriolet(true)
                .build();
        jeep = new Jeep(2500, "Black", jeepEngine, WheelTypes.ROADLESS, 500, 5);
    }

    @Test
    public void containsAnySupercar_SupercarValue_True() {
        given(streamApi.findAllSupercar()).willReturn(List.of(supercar));
        Assert.assertTrue(carService.containsAnySupercar());
    }

    @Test
    public void containsAnySupercar_NullValue_False() {
        given(streamApi.findAllSupercar()).willReturn(null);
        Assert.assertFalse(carService.containsAnySupercar());
    }

    @Test
    public void getEngineWithMaxHorsePower_CarValue_EqualsTrue() {
        given(streamApi.findMaxCarEnginePower()).willReturn(supercar);
        Assert.assertEquals(supercarEngine, carService.getEngineWithMaxHorsePower());
    }

    @Test(expected = NoSuchElementException.class)
    public void getEngineWithMaxHorsePower_NullValue_Exception() {
        given(streamApi.findMaxCarEnginePower()).willReturn(null);
        carService.getEngineWithMaxHorsePower();
    }

    @Test
    public void findSumOfSupercarsWeight_CorrectValue_True() {
        given(streamApi.findAllSupercarWeight()).willReturn(5000);
        int actualWeight = carService.findSumOfSupercarsWeight();
        Assert.assertEquals(5000, actualWeight);
    }

    @Test(expected = RuntimeException.class)
    public void findSumOfSupercarsWeight_NegativeValue_Exception() {
        given(streamApi.findAllSupercarWeight()).willReturn(-1000);
        carService.findSumOfSupercarsWeight();
    }
}
