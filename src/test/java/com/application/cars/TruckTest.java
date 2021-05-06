package com.application.cars;

import com.application.cars.Engine;
import com.application.cars.Truck;
import com.application.enam.WheelTypes;
import com.application.exception.IncorrectEnteredValueException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TruckTest {
    Truck truck;

    @Before
    public void setDefaultInitialization() {
        truck = new Truck();
    }

    @Test(expected = RuntimeException.class)
    public void setMaxLiftingCapacity_InvalidValue_RuntimeException() {
        truck.setMaxLiftingCapacity(-50);
    }

    @Test
    public void setMaxLiftingCapacity_Value1000_True() {
        truck.setMaxLiftingCapacity(1000);
        Assert.assertEquals(1000, truck.getMaxLiftingCapacity());
    }


    @Test(expected = IncorrectEnteredValueException.class)
    public void moneyForGasolineOnTrip_InvalidValue_IncorrectEnteredValueException() throws IncorrectEnteredValueException {
        truck.moneyForGasolineOnTrip(0);
    }

    @Test
    public void equals_SameObjects_True() {
        Engine truckEngine = new Engine(500, 140, 10);
        Truck truck1 = new Truck(4000, "Grey", truckEngine, WheelTypes.SUMMER, 5000, false);
        Truck truck2 = new Truck(4000, "Grey", truckEngine, WheelTypes.SUMMER, 5000, false);
        Assert.assertEquals(truck1,truck2);
    }

    @Test
    public void hashCode_SameObjects_True() {
        Engine truckEngine = new Engine(500, 140, 10);
        Truck truck1 = new Truck(4000, "Grey", truckEngine, WheelTypes.SUMMER, 5000, false);
        Truck truck2 = new Truck(4000, "Grey", truckEngine, WheelTypes.SUMMER, 5000, false);
        Assert.assertEquals(truck1.hashCode(),truck2.hashCode());
    }

    @Test
    public void hashCode_DifferentObjects_False() {
        Engine truckEngine = new Engine(500, 140, 10);
        Truck truck1 = new Truck(4000, "Grey", truckEngine, WheelTypes.SUMMER, 5000, false);
        Truck truck2 = new Truck(2000, "Blue", truckEngine, WheelTypes.SUMMER, 100, false);
        Assert.assertNotEquals(truck1.hashCode(),truck2.hashCode());
    }
}
