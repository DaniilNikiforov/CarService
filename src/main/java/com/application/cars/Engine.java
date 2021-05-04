package com.application.cars;

import com.application.exception.InputValueRuntimeException;

import java.util.Objects;

public class Engine {
    private int horsepower;
    private int maxSpeed;
    private int numberOfGears;

    public Engine() {
    }

    public Engine(int horsepower, int maxSpeed, int numberOfGears) {
        this.horsepower = horsepower;
        this.maxSpeed = maxSpeed;
        this.numberOfGears = numberOfGears;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        if (horsepower > 0) {
            this.horsepower = horsepower;
            return;
        }
        throw new InputValueRuntimeException("Horsepower can't be less than 1");
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        if (maxSpeed >= 10) {
            this.maxSpeed = maxSpeed;
            return;
        }
        throw new InputValueRuntimeException("Max speed can't be less than 10");
    }

    public int getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(int numberOfGears) {
        if (numberOfGears > 0) {
            this.numberOfGears = numberOfGears;
            return;
        }
        throw new InputValueRuntimeException("Number of gears can't be less than 1");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilderEngine = new StringBuilder().append("Engine{").append("horsepower=")
                .append(horsepower).append(", maxSpeed=").append(maxSpeed).append(", numberOfGears=")
                .append(numberOfGears).append('}');
        return stringBuilderEngine.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return horsepower == engine.horsepower &&
                maxSpeed == engine.maxSpeed &&
                numberOfGears == engine.numberOfGears;
    }

    @Override
    public int hashCode() {
        return Objects.hash(horsepower, maxSpeed, numberOfGears);
    }
}
