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
    int bestDiscount; // TODO kun admin

    //@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING) // TODO Hvorfor udkommenteret
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;



    // Car to CarResponse conversion
    public CarResponse(Car c, boolean includeAll) {
        this.brand = c.getBrand();
        this.model = c.getModel();
        this.pricePrDay = c.getPricePrDay();

        if(includeAll){
            this.created = c.getCreated();
            this.edited = c.getLastEdited();
            this.bestDiscount = c.getBestDiscount();
        }

    }

}
