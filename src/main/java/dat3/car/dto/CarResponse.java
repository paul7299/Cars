package dat3.car.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import dat3.car.entity.Car;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class CarResponse {

    int id;
    String brand;
    String model;
    double pricePrDay;

    //@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING) // TODO Hvorfor udkommenteret
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;



    // Car to CarResponse conversion
    public CarResponse(Car c) {
        this.brand = c.getBrand();
        this.model = c.getModel();
        this.pricePrDay = c.getPricePrDay();
    }

    public static Car getCarEntity(CarRequest c) {
        return new Car(c.getBrand(), c.getModel(), c.getPricePrDay(), c.getBestDiscount());
    }

}
