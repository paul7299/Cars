package dat3.car.repository;

import dat3.car.entity.Car;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {

    @Autowired
    CarRepository carRepository;
    boolean isInitialized = false;

    @BeforeEach
    void setUp() {
        if(!isInitialized) {
            carRepository.deleteAll();
            carRepository.save(new Car("Tesla", "Model 3", 1300, 30));
            carRepository.save(new Car("Porsche", "Panamera", 2000, 28));
            carRepository.save(new Car("Jaguar", "XE", 1800, 25));
            carRepository.save(new Car("Land Rover", "Discovery", 2500, 15));
            carRepository.save(new Car("Volvo", "S60", 1100, 10));
            isInitialized = true;
        }
    }

    @Test
    void findCarByPricePrDay() {
        Car c = carRepository.findCarByPricePrDay(1100);
        assertEquals("Volvo", c.getBrand());
    }
}