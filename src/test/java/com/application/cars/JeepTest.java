package com.application.cars;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JeepTest {
    private Jeep jeep;

    @Before
    public void setDefaultValue() {
        jeep = new Jeep();
    }

    @Test(expected = RuntimeException.class)
    public void setMaxLiftingCapacity_InvalidValue_RuntimeException() {
        jeep.setMaxLiftingCapacity(-1000);
    }

    @Test
    public void setMaxLiftingCapacity_Value1000_True() {
        int value = 1500;
        jeep.setMaxLiftingCapacity(value);
        Assert.assertEquals(jeep.getMaxLiftingCapacity(), value);
    }

    @Test(expected = RuntimeException.class)
    public void setNumberOfPassengers_InvalidValue_RuntimeException() {
        jeep.setNumberOfPassengers(-1);
    }

    @Test
    public void setNumberOfPassengers_Value10_True() {
        int value = 100;
        jeep.setMaxLiftingCapacity(value);
        Assert.assertEquals(jeep.getMaxLiftingCapacity(), value);
    }
}
