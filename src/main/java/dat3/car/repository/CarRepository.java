package dat3.car.repository;

import dat3.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

    Car findCarByPricePrDay(double pricerPrDay);
    // TODO findRentalPriceByCarName

    Car findCarByBrandAndModel(String brand, String model);

}
