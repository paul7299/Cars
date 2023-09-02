package dat3.car.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.car.entity.Car;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

// Hvis ikke denne er inkluderet, sendes også dates med (som null)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {

    int id;
    String brand;
    String model;
    double pricePrDay;
    Integer bestDiscount;

    //@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING) // TODO Hvorfor udkommenteret
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;



    // Car to CarResponse conversion
    public CarResponse(Car c, boolean includeAll) {
        this.id = c.getId();
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
