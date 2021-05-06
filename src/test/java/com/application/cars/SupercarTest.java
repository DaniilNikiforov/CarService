package com.application.cars;

import com.application.enam.WheelTypes;
import org.junit.Assert;
import org.junit.Test;

public class SupercarTest {

    @Test(expected = RuntimeException.class)
    public void setNumberOfPassengers_InvalidValue_RuntimeException() {
        Supercar supercar = new Supercar.Builder()
                .setNumberOfPassengers(-5)
                .build();
    }

    @Test
    public void setNumberOfPassengers_CorrectValues_True() {
        Supercar supercar = new Supercar.Builder()
                .setWeight(1200)
                .setColor("Red")
                .setWheelType(WheelTypes.SPORTS)
                .setNumberOfPassengers(2)
                .setCabriolet(true)
                .setEngine(null)
                .build();
        Assert.assertEquals(1200, supercar.getWeight());
        Assert.assertEquals("Red", supercar.getColor());
        Assert.assertEquals(WheelTypes.SPORTS, supercar.getWheelType());
        Assert.assertEquals(true, supercar.isCabriolet());
        Assert.assertEquals(null, supercar.getEngine());
        Assert.assertEquals(2, supercar.getNumberOfPassenger());
    }

}
