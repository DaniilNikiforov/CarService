package com.application.stream;

import com.application.cars.*;
import com.application.enam.WheelTypes;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import com.application.stream.StreamApi;

import java.util.List;
import java.util.Map;

public class StreamApiTest {

    private static StreamApi streamApi;
    private static Car truck1;
    private static Car truck2;
    private static Jeep jeep;
    private static Supercar supercar;
    private static int expectedSum;
    private static double expectedAverageWeight;


    public StreamApiTest() {
    }

    @BeforeClass
    public static void initialValue() {
        Engine truckEngine = new Engine(500, 140, 10);
        Engine supercarEngine = new Engine(700, 340, 7);
        Engine jeepEngine = new Engine(250, 160, 5);
        truck1 = new Truck(4000, "Grey", truckEngine, WheelTypes.SUMMER, 5000, false);
        truck2 = new Truck(5000, "White", truckEngine, WheelTypes.SUMMER, 10000, true);
        jeep = new Jeep(2500, "Black", jeepEngine, WheelTypes.ROADLESS, 500, 5);
        supercar = new Supercar.Builder()
                .setWeight(1300)
                .setColor("Red")
                .setWheelType(WheelTypes.SPORTS)
                .setEngine(supercarEngine)
                .setNumberOfPassengers(2)
                .setCabriolet(true)
                .build();

        streamApi = new StreamApi(List.of(truck1, truck2, jeep, supercar));
        expectedSum = supercar.getWeight();
        expectedAverageWeight = (truck1.getWeight() + truck2.getWeight() + supercar.getWeight() + jeep.getWeight()) / 4.;
    }


    @Test
    public void findAllSupercar_ListOfCars_CorrectValue() {
        List<Car> actual = streamApi.findAllSupercar();  //Шукаємо всі суперкари в списку
        Assert.assertEquals(1, actual.size()); // Порівнюмо кількість об'єктів в списку
        Assert.assertEquals(supercar, actual.get(0)); // Порівнюємо два об'єкти суперкар
    }

    @Test
    public void findAllSupercarWeight_ListOfCars_CorrectValue() {
        int actualSum = streamApi.findAllSupercarWeight();
        Assert.assertEquals(expectedSum, actualSum);
    }

    @Test
    public void findMaxCarEnginePower_ListOfCars_CorrectValue() {
        Car actualCar = streamApi.findMaxCarEnginePower();
        Assert.assertEquals(supercar, actualCar);
    }

    @Test
    public void findAverageWeight_ListOfCars_CorrectValue() {
        double actualValue = streamApi.findAverageWeight();
        Assert.assertEquals(expectedAverageWeight, actualValue, 0.001);
    }

    @Test
    public void findMapCarWithKeyValue_ListOfCars_CorrectValue() {
        Map<String, List<Car>> expectedMap = streamApi.findMapCarWithKeyValue(WheelTypes.SUMMER);
        List<Car> expectedCorrectCar  = List.of(truck1, truck2);
        List<Car> expectedIncorrectCar = List.of(supercar, jeep);
        List<Car> actualCorrectCar = null;
        List<Car> actualIncorrectCar  = null;

        for (Map.Entry<String, List<Car>> entry : expectedMap.entrySet()) { //Проходимо по мапі
            if(entry.getKey().equals("correct")){
                actualCorrectCar = entry.getValue(); // Дістаємо список машин які нам підходять
            }else{
                actualIncorrectCar = entry.getValue(); // Дістаємо список машин які не підходять
            }
        }

        Assert.assertEquals(expectedCorrectCar.size(), actualCorrectCar.size());
        Assert.assertEquals(expectedIncorrectCar.size(), actualIncorrectCar.size());

        for (Car car : expectedCorrectCar) {
            Assert.assertTrue(actualCorrectCar.contains(car));
        }
        for (Car car : expectedIncorrectCar) {
            Assert.assertTrue(actualIncorrectCar.contains(car));
        }
    }
}
