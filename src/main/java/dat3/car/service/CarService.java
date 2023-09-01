package dat3.car.service;

import dat3.car.repository.CarRepository;
import org.springframework.stereotype.Service;
@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }




}
