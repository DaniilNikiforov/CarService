package com.application.cars;

import org.junit.Assert;
import org.junit.Test;

public class CarTest {

    @Test
    public void setWeightNormalWeight() {
        int weight = 1000;
        Car car = new Jeep();
        car.setWeight(weight);
        Assert.assertEquals(car.getWeight(), weight);
    }

    @Test(expected = RuntimeException.class)
    public void setWeightWrongWeight() {
        Car car = new Jeep();
        car.setWeight(-100);
    }
}
