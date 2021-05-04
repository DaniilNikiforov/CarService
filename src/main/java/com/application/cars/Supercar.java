package com.application.cars;

import com.application.enam.WheelTypes;
import com.application.exception.InputValueRuntimeException;
import com.application.interfaces.PassengerCapacity;

import java.util.Objects;

public class Supercar extends Car implements PassengerCapacity {
    private boolean isCabriolet;
    private int numberOfPassengers;

    private Supercar(Builder builder) {
        super(builder.weight, builder.color, builder.wheelType, builder.engine);
        this.isCabriolet = builder.isCabriolet;
        this.numberOfPassengers = builder.numberOfPassengers;
    }

    public boolean isCabriolet() {
        return isCabriolet;
    }

    @Override
    public int getNumberOfPassenger() {
        return numberOfPassengers;
    }

    @Override
    public String drive() {
        return "Super car is driving...";
    }

    @Override
    public String toString() {
        StringBuilder stringBuilderSupercar = new StringBuilder().append("Supercar{").append("isCabriolet=")
                .append(isCabriolet).append(", numberOfPassengers=").append(numberOfPassengers)
                .append(super.toString());
        return stringBuilderSupercar.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supercar supercar = (Supercar) o;
        return isCabriolet == supercar.isCabriolet &&
                numberOfPassengers == supercar.numberOfPassengers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isCabriolet, numberOfPassengers);
    }

    public static class Builder {
        private int weight;
        private String color;
        private Engine engine;
        private WheelTypes wheelType;
        private boolean isCabriolet;
        private int numberOfPassengers;

        public Builder setWeight(int weight) {
            if (weight > 100) {
                this.weight = weight;
                return this;
            }
            throw new InputValueRuntimeException("Weight can't be less than 100kg");
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public Builder setWheelType(WheelTypes wheelType) {
            this.wheelType = wheelType;
            return this;
        }

        public Builder setCabriolet(boolean cabriolet) {
            isCabriolet = cabriolet;
            return this;
        }

        public Builder setNumberOfPassengers(int numberOfPassengers) {
            if (numberOfPassengers > 0) {
                this.numberOfPassengers = numberOfPassengers;
                return this;
            }
            throw new InputValueRuntimeException("Number of passengers can't be less than 1");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Builder builder = (Builder) o;
            return weight == builder.weight &&
                    isCabriolet == builder.isCabriolet &&
                    numberOfPassengers == builder.numberOfPassengers &&
                    Objects.equals(color, builder.color) &&
                    Objects.equals(engine, builder.engine) &&
                    wheelType == builder.wheelType;
        }

        @Override
        public int hashCode() {
            return Objects.hash(weight, color, engine, wheelType, isCabriolet, numberOfPassengers);
        }

        public Supercar build() {
            return new Supercar(this);
        }
    }
}
