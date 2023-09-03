package dat3.car.dto;

import dat3.car.entity.AdminDetails;
import dat3.car.entity.Car;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CarRequest {

    int id;
    String brand;
    String model;
    double pricePrDay;
    int bestDiscount;

    // Car to CarRequest conversion
    public CarRequest(Car c) {
        this.brand = c.getBrand();
        this.model = c.getModel();
        this.pricePrDay = c.getPricePrDay();
        this.bestDiscount = c.getBestDiscount();
    }

    // Denne bruges til at konvertere en CarRequest til en Car
    public static Car getCarEntity(CarRequest c) {
        return new Car(c.getBrand(), c.getModel(), c.getPricePrDay(), c.getBestDiscount());
    }

}
