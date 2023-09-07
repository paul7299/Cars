package dat3.car.dto;

import dat3.car.entity.Reservation;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationResponse {

    //TODO

    int id;
    int carId;
    String brand;
    String model;
    double price;
    LocalDate rentalDate;

    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.carId = reservation.getCar().getId();
        this.brand = reservation.getCar().getBrand();
        this.model = reservation.getCar().getModel();
        this.price = reservation.getCar().getPricePrDay();
        this.rentalDate = reservation.getRentalDate();
    }

}
