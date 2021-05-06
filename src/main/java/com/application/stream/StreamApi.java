package com.application.stream;

import com.application.cars.Car;
import com.application.cars.Supercar;
import com.application.enam.WheelTypes;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class StreamApi {
    private List<Car> listCar;

    public List<Car> getListCar() {
        return listCar;
    }

    public void setListCar(List<Car> listCar) {
        this.listCar = listCar;
    }

    public StreamApi(List<Car> listCar) {
        this.listCar = listCar;
    }

    public List<Car> findAllSupercar() {
        return getListCar().stream()
                .filter(e -> e.getClass() == Supercar.class)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int findAllSupercarWeight() {
        return listCar.stream()
                .filter(e -> e.getClass() == Supercar.class)
                .mapToInt(Car::getWeight)
                .sum();
    }

    public Car findMaxCarEnginePower() {
        return listCar.stream()
                .max(Comparator.comparingInt(e -> e.getEngine().getHorsepower()))// Шукаємо максимальне значення хорсавер
                .orElse(null);
    }

    public double findAverageWeight() {
        return listCar.stream()
                .mapToInt(Car::getWeight)
                .average().orElseThrow(NoSuchElementException::new);
    }

    public Map<String, List<Car>> findMapCarWithKeyValue(WheelTypes wheelTypes) {
        Map<String, List<Car>> map = new HashMap<>();

        List<Car> correctCar = new ArrayList<>();
        List<Car> incorrectCar = new ArrayList<>();
        map.put("correct", correctCar);
        map.put("incorrect", incorrectCar);

        listCar.stream().forEach(
                e -> {
                    if (e.getWheelType() == wheelTypes) {
                        correctCar.add(e);
                    } else {
                        incorrectCar.add(e);
                    }
                });
        return map;
    }
}
