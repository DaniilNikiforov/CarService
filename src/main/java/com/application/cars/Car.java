package com.application.cars;

import com.application.enam.WheelTypes;
import com.application.exception.InputValueRuntimeException;

import java.awt.*;
import java.util.Objects;

public abstract class Car {
    private int weight;
    private String color;
    private Engine engine;
    private WheelTypes wheelType;
    private Color colorAwt;

    protected Car() {
    }

    protected Car(int weight, String color, WheelTypes wheelType, Engine engine) {
        this.weight = weight;
        this.color = color;
        this.engine = engine;
        this.wheelType = wheelType;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight > 100) {
            this.weight = weight;
            return;
        }
        throw new InputValueRuntimeException("Weight can't be less then 100");
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public WheelTypes getWheelType() {
        return wheelType;
    }

    public void setWheelType(WheelTypes wheelType) {
        this.wheelType = wheelType;
    }

    public Color getColorAwt() {
        return colorAwt;
    }

    public void setColorAwt(Color colorAwt) {
        this.colorAwt = colorAwt;
    }

    public abstract String drive();

    public double accelerationTimeTo100() {
        int time = weight / engine.getHorsepower();
        return wheelType.isForFastDriving() ? time : time * 1.2;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilderCar = new StringBuilder();
        stringBuilderCar.append(" weight=").append(weight).append(", color='").append(color).append("\'")
                .append(", engine=").append(engine).append(", wheelType=").append(wheelType).append('}');
        return stringBuilderCar.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return weight == car.weight &&
                Objects.equals(color, car.color) &&
                Objects.equals(engine, car.engine) &&
                wheelType == car.wheelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, color, engine, wheelType);
    }
}
