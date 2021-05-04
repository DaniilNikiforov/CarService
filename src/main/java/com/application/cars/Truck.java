package com.application.cars;

import com.application.enam.WheelTypes;
import com.application.exception.IncorrectEnteredValueException;
import com.application.exception.InputValueRuntimeException;
import com.application.interfaces.LiftingCapacity;

import java.awt.*;
import java.util.Objects;

public class Truck extends Car implements LiftingCapacity {
    private int maxLiftingCapacity;
    private boolean hasTrailer;

    public Truck() {
    }

    public Truck(int weight, String color, Engine engine, WheelTypes wheelType, int maxLiftingCapacity, boolean hasTrailer) {
        super(weight, color, wheelType, engine);
        this.maxLiftingCapacity = maxLiftingCapacity;
        this.hasTrailer = hasTrailer;
    }

    public void setMaxLiftingCapacity(int maxLiftingCapacity) {
        if(maxLiftingCapacity>50) {
            this.maxLiftingCapacity = maxLiftingCapacity;
            return;
        }
        throw new InputValueRuntimeException("Max lifting capacity can't be less then 50");
    }

    public boolean isHasTrailer() {
        return hasTrailer;
    }

    public void setHasTrailer(boolean hasTrailer) {
        this.hasTrailer = hasTrailer;
    }

    public double moneyForGasolineOnTrip(int distance) throws IncorrectEnteredValueException {
        if(distance>0){
            double gasoline =  (distance/100.)*getEngine().getHorsepower()*0.05;
            return hasTrailer ? gasoline*1.5*28 : gasoline*28;
        }
        throw new IncorrectEnteredValueException("Distance cannot be zero or less!");
    }

    @Override
    public int getMaxLiftingCapacity() {
        return maxLiftingCapacity;
    }

    @Override
    public String drive() {
        return "Truck is driving...";
    }

    @Override
    public String toString() {
        StringBuilder stringBuilderTruck = new StringBuilder();
        stringBuilderTruck.append("Truk{").append("maxLiftingCapacity=").append(maxLiftingCapacity)
                .append(", hasTrailer=").append(hasTrailer).append(super.toString());
        return stringBuilderTruck.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Truck truck = (Truck) o;
        return maxLiftingCapacity == truck.maxLiftingCapacity &&
                hasTrailer == truck.hasTrailer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxLiftingCapacity, hasTrailer);
    }
}
