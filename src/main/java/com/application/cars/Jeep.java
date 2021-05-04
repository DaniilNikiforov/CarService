package com.application.cars;

import com.application.enam.WheelTypes;
import com.application.exception.InputValueRuntimeException;
import com.application.interfaces.LiftingCapacity;
import com.application.interfaces.PassengerCapacity;
import org.apache.log4j.*;

import java.util.Objects;

public class Jeep extends Car implements PassengerCapacity, LiftingCapacity {
    private int maxLiftingCapacity;
    private int numberOfPassenger;

    public Jeep() {
    }

    public Jeep(int weight, String color, Engine engine, WheelTypes wheelType, int maxLiftingCapacity, int numberOfPassenger) {
        super(weight, color, wheelType, engine);
        this.maxLiftingCapacity = maxLiftingCapacity;
        this.numberOfPassenger = numberOfPassenger;
    }

    public void setMaxLiftingCapacity(int maxLiftingCapacity) {
        if (maxLiftingCapacity > 50) {
            this.maxLiftingCapacity = maxLiftingCapacity;
            return;
        }
        throw new InputValueRuntimeException("Max lifting capacity can;t be less then 50");
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        if (numberOfPassengers > 0) {
            this.numberOfPassenger = numberOfPassengers;
            return;
        }
        throw new InputValueRuntimeException("Number of passengers can't be less than 1");
    }

    @Override
    public int getMaxLiftingCapacity() {
        return maxLiftingCapacity;
    }

    @Override
    public int getNumberOfPassenger() {
        return numberOfPassenger;
    }

    @Override
    public String drive() {
        return "Jeep is driving...";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jeep jeep = (Jeep) o;
        return maxLiftingCapacity == jeep.maxLiftingCapacity &&
                numberOfPassenger == jeep.numberOfPassenger;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxLiftingCapacity, numberOfPassenger);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilderJeep = new StringBuilder().append("Jeep{").append("maxLiftingCapacity=")
                .append(maxLiftingCapacity).append(", numberOfPassenger=").append(numberOfPassenger)
                .append(super.toString());
        return stringBuilderJeep.toString();
    }
}
